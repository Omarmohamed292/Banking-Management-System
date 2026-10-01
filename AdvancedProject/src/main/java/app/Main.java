package app;

import Scenes.CustomerScene;
import Scenes.EmployeeScene;
import Scenes.LoginScene;
import Scenes.SignUpScene;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import mainClasses.Customer;
import mainClasses.Employee;
import services.BankService;

/** JavaFX entry point and UI event wiring. Business logic lives in BankService. */
public class Main extends Application {
    private final BankService bankService = new BankService();

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {
        EmployeeScene employeeScene = new EmployeeScene();
        SignUpScene signUpScene = new SignUpScene();
        LoginScene loginScene = new LoginScene();
        CustomerScene customerScene = new CustomerScene();

        updateTable(employeeScene.getCustomersTable());

        employeeScene.getCreateInvAccNode().getCreateButton().setOnAction(e -> {
            String id = employeeScene.getCreateInvAccNode().getIdTextField().getText().trim();
            if (bankService.openInvestmentAccount(id)) {
                clear(employeeScene.getCreateInvAccNode().getIdTextField());
                updateTable(employeeScene.getCustomersTable());
            } else showError("Unable to create account", "Customer not found or already has an account.");
        });

        employeeScene.getCreateNorAccNode().getCreateButton().setOnAction(e -> {
            String id = employeeScene.getCreateNorAccNode().getIdTextField().getText().trim();
            if (bankService.openNormalAccount(id)) {
                clear(employeeScene.getCreateNorAccNode().getIdTextField());
                updateTable(employeeScene.getCustomersTable());
            } else showError("Unable to create account", "Customer not found or already has an account.");
        });

        employeeScene.getDeleteAccNode().getDeleteButton().setOnAction(e -> {
            String id = employeeScene.getDeleteAccNode().getIdTextField().getText().trim();
            if (bankService.closeAccount(id)) {
                clear(employeeScene.getDeleteAccNode().getIdTextField());
                updateTable(employeeScene.getCustomersTable());
            } else showError("Unable to delete account", "Customer not found or has no account.");
        });

        employeeScene.getDipWithNode().getDepositButton().setOnAction(e -> {
            String id = employeeScene.getDipWithNode().getDepositIdTextField().getText().trim();
            Double amount = parseAmount(employeeScene.getDipWithNode().getDepositAmountTextField().getText());
            if (amount != null && bankService.deposit(id, amount)) {
                clear(employeeScene.getDipWithNode().getDepositIdTextField());
                clear(employeeScene.getDipWithNode().getDepositAmountTextField());
                updateTable(employeeScene.getCustomersTable());
            } else showError("Deposit failed", "Check the account ID and enter a valid positive amount.");
        });

        employeeScene.getDipWithNode().getWithdrawButton().setOnAction(e -> {
            String id = employeeScene.getDipWithNode().getWithdrawIdTextField().getText().trim();
            Double amount = parseAmount(employeeScene.getDipWithNode().getWithdrawAmountTextField().getText());
            if (amount != null && bankService.withdraw(id, amount)) {
                clear(employeeScene.getDipWithNode().getWithdrawIdTextField());
                clear(employeeScene.getDipWithNode().getWithdrawAmountTextField());
                updateTable(employeeScene.getCustomersTable());
            } else showError("Withdrawal failed", "Check the account ID, amount, and available balance.");
        });

        employeeScene.getLogoutButton().setOnAction(e -> primaryStage.setScene(loginScene.getScene()));

        loginScene.getLoginButton().setOnAction(e -> {
            String id = loginScene.getIdTextfield().getText().trim();
            String password = loginScene.getPasswordField().getText();

            Customer customer = bankService.authenticateCustomer(id, password);
            if (customer != null) {
                clearLogin(loginScene);
                loadCustomer(customer, customerScene);
                primaryStage.setScene(customerScene.getScene());
                return;
            }

            Employee employee = bankService.authenticateEmployee(id, password);
            if (employee != null) {
                clearLogin(loginScene);
                employeeScene.getEmployeeInfoNode().setNameValue(employee.getName());
                employeeScene.getEmployeeInfoNode().setIdValue(employee.getId());
                employeeScene.getEmployeeInfoNode().setPhoneValue(employee.getPhoneNumber());
                primaryStage.setScene(employeeScene.getScene());
                return;
            }

            showError("Login failed", "Invalid ID or password.");
        });

        loginScene.getSignUpButton().setOnAction(e -> {
            clearLogin(loginScene);
            clearSignUp(signUpScene);
            primaryStage.setScene(signUpScene.getScene());
        });

        signUpScene.getSignUpButton().setOnAction(e -> {
            String id = signUpScene.getIdTextfield().getText().trim();
            String name = signUpScene.getNameTextfield().getText().trim();
            String phone = signUpScene.getPhoneTextfield().getText().trim();
            String password = signUpScene.getPasswordField().getText();

            if (!signUpScene.getAgreeCheckBox().isSelected()) {
                showError("Registration failed", "Please accept the terms first.");
                return;
            }
            try {
                bankService.registerCustomer(name, phone, id, password);
                // Refresh the employee customer table immediately so newly registered
                // customers appear the next time the employee opens/views it.
                updateTable(employeeScene.getCustomersTable());
                clearSignUp(signUpScene);
                showInfo("Account created", "Your customer account was created successfully. You can log in now.");
                primaryStage.setScene(loginScene.getScene());
            } catch (IllegalArgumentException exception) {
                showError("Registration failed", exception.getMessage());
            }
        });

        signUpScene.getLoginButton().setOnAction(e -> {
            clearSignUp(signUpScene);
            primaryStage.setScene(loginScene.getScene());
        });

        customerScene.getLogoutButton().setOnAction(e -> {
            customerScene.reset();
            primaryStage.setScene(loginScene.getScene());
        });

        customerScene.getCustomerInfoNode().getNameChangeButton().setOnAction(e -> updateCustomerName(customerScene));
        customerScene.getCustomerInfoNode().getPhoneChangeButton().setOnAction(e -> updateCustomerPhone(customerScene));
        customerScene.getCustomerInfoNode().getPasswordChangeButton().setOnAction(e -> updateCustomerPassword(customerScene));

        primaryStage.setTitle("BankFX - Banking Management System");
        primaryStage.setScene(loginScene.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void updateCustomerName(CustomerScene scene) {
        String id = scene.getCustomerInfoNode().getSingedId();
        String value = scene.getCustomerInfoNode().getNameTextfield().getText().trim();
        Customer customer = bankService.findCustomer(id);
        if (customer == null || value.isEmpty()) {
            showError("Update failed", "Name cannot be blank.");
            return;
        }
        customer.setName(value);
        updateTable(findEmployeeTable(scene));
        showInfo("Updated", "Name updated successfully.");
    }

    private void updateCustomerPhone(CustomerScene scene) {
        String id = scene.getCustomerInfoNode().getSingedId();
        String value = scene.getCustomerInfoNode().getPhoneTextfield().getText().trim();
        Customer customer = bankService.findCustomer(id);
        if (customer == null || value.isEmpty()) {
            showError("Update failed", "Phone cannot be blank.");
            return;
        }
        customer.setPhoneNumber(value);
        showInfo("Updated", "Phone number updated successfully.");
    }

    private void updateCustomerPassword(CustomerScene scene) {
        String id = scene.getCustomerInfoNode().getSingedId();
        String value = scene.getCustomerInfoNode().getPasswordTextfield().getText();
        Customer customer = bankService.findCustomer(id);
        if (customer == null || value.isBlank()) {
            showError("Update failed", "Password cannot be blank.");
            return;
        }
        customer.setPassword(value);
        showInfo("Updated", "Password updated successfully.");
    }

    private TableView<Customer> employeeTable;

    private TableView<Customer> findEmployeeTable(CustomerScene ignored) {
        return employeeTable;
    }

    private void updateTable(TableView<Customer> table) {
        employeeTable = table;
        table.setItems(FXCollections.observableArrayList(bankService.getCustomers()));
        table.refresh();
    }

    private void loadCustomer(Customer customer, CustomerScene scene) {
        scene.getCustomerInfoNode().setNameTextfield(customer.getName());
        scene.getCustomerInfoNode().setPasswordTextfield(customer.getPassword());
        scene.getCustomerInfoNode().setPhoneTextfield(customer.getPhoneNumber());
        scene.getCustomerInfoNode().setSingedId(customer.getId());
        scene.loadAccount(customer.getAccount());
    }

    private static Double parseAmount(String text) {
        try {
            double amount = Double.parseDouble(text.trim());
            return amount > 0 && Double.isFinite(amount) ? amount : null;
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    private static void clear(javafx.scene.control.TextInputControl control) { control.clear(); }
    private static void clearLogin(LoginScene scene) { scene.getIdTextfield().clear(); scene.getPasswordField().clear(); }
    private static void clearSignUp(SignUpScene scene) {
        scene.getIdTextfield().clear(); scene.getNameTextfield().clear(); scene.getPhoneTextfield().clear();
        scene.getPasswordField().clear(); scene.getAgreeCheckBox().setSelected(false);
    }

    private static void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private static void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
