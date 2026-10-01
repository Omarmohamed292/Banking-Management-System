package services;

import mainClasses.Account;
import mainClasses.Customer;
import mainClasses.Employee;
import mainClasses.NormalAccount;
import mainClasses.InvestmentAccount;

import java.util.ArrayList;
import java.util.List;

/** Business operations kept outside the JavaFX UI layer. */
public class BankService {
    private final List<Customer> customers = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private int nextAccountNumber;

    public BankService() { seedData(); }

    private void seedData() {
        customers.add(new Customer("Belal", "012012", "C0", "123"));
        customers.add(new Customer("Ahmed", "013013", "C1", "123"));
        customers.add(new Customer("Omar", "014014", "C2", "123"));
        customers.add(new Customer("Marwan", "016016", "C3", "123"));
        Customer customer = new Customer("Mahmoud", "015015", "C4", "123");
        customer.setAccount(new NormalAccount(nextAccountId(), 200.0));
        customers.add(customer);

        employees.add(new Employee("Tamer Ghaly", "0992542", "1", "1"));
        employees.add(new Employee("Hany Abdulah", "0983944", "2", "2"));
        employees.add(new Employee("Fouad Abdelrahman", "0983944", "3", "3"));
    }

    private String nextAccountId() { return "A" + nextAccountNumber++; }

    public List<Customer> getCustomers() { return customers; }
    public List<Employee> getEmployees() { return employees; }

    public Customer authenticateCustomer(String id, String password) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id) && customer.getPassword().equals(password)) return customer;
        }
        return null;
    }

    public Employee authenticateEmployee(String id, String password) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id) && employee.getPassword().equals(password)) return employee;
        }
        return null;
    }

    public boolean idExists(String id) {
        return customers.stream().anyMatch(c -> c.getId().equals(id))
                || employees.stream().anyMatch(e -> e.getId().equals(id));
    }

    public Customer registerCustomer(String name, String phone, String id, String password) {
        if (idExists(id)) throw new IllegalArgumentException("ID already exists");
        Customer customer = new Customer(name, phone, id, password);
        customers.add(customer);
        return customer;
    }

    public boolean openNormalAccount(String customerId) {
        Customer customer = findCustomer(customerId);
        if (customer == null || customer.getAccount() != null) return false;
        customer.setAccount(new NormalAccount(nextAccountId(), 0.0));
        return true;
    }

    public boolean openInvestmentAccount(String customerId) {
        Customer customer = findCustomer(customerId);
        if (customer == null || customer.getAccount() != null) return false;
        customer.setAccount(new InvestmentAccount(nextAccountId(), 0.0));
        return true;
    }

    public boolean closeAccount(String customerId) {
        Customer customer = findCustomer(customerId);
        if (customer == null || customer.getAccount() == null) return false;
        customer.setAccount(null);
        return true;
    }

    public boolean deposit(String accountId, double amount) {
        Customer customer = findByAccountId(accountId);
        if (customer == null) return false;
        customer.getAccount().deposit(amount);
        return true;
    }

    public boolean withdraw(String accountId, double amount) {
        Customer customer = findByAccountId(accountId);
        return customer != null && customer.getAccount().withdraw(amount);
    }

    public Customer findCustomer(String id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public Customer findByAccountId(String accountId) {
        return customers.stream()
                .filter(c -> c.getAccount() != null && c.getAccount().getId().equals(accountId))
                .findFirst().orElse(null);
    }

    public Account findAccount(String accountId) {
        Customer customer = findByAccountId(accountId);
        return customer == null ? null : customer.getAccount();
    }
}
