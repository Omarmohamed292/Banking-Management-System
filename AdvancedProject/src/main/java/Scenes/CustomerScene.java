package Scenes;

import Nodes.AccountInfoNode;
import Nodes.CustomerInfoNode;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import mainClasses.Account;

public class CustomerScene {

    AccountInfoNode accountInfoNode;
    CustomerInfoNode customerInfoNode;
    Button logoutButton;
    GridPane gridPane;
    ImageView imageView;
    Scene scene;
    public CustomerScene(){
        init();
        builder();
        style();
    }
    public void init(){
        accountInfoNode = new AccountInfoNode();
        customerInfoNode = new CustomerInfoNode();
        imageView = new ImageView(new Image(CustomerScene.class.getResourceAsStream("/BankFX.png")));
        logoutButton = new Button("Logout");
        gridPane = new GridPane();
        scene = new Scene(gridPane,700,700);
    }
    public void builder(){
        imageView.setTranslateY(-20);
        gridPane.add(imageView,0,0);
        gridPane.add(logoutButton,1,0);
        gridPane.add(customerInfoNode.getAsElement(),0,1);
        gridPane.add(accountInfoNode.getAsElement(),1,1);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }
    public void style(){
        logoutButton.getStyleClass().add("button");
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }

    public AccountInfoNode getAccountInfoNode() {
        return accountInfoNode;
    }

    public CustomerInfoNode getCustomerInfoNode() {
        return customerInfoNode;
    }

    public Scene getScene(){
        return scene;
    }

    public Button getLogoutButton() {
        return logoutButton;
    }

    public void loadAccount(Account account) {
        if (account == null) {
            accountInfoNode.reset();
            accountInfoNode.setId("No Account yet");
            accountInfoNode.setBalance("");
            accountInfoNode.setBalanceEg("");
            accountInfoNode.setNextMonth("");
            return;
        }

        accountInfoNode.setId("ID:");
        accountInfoNode.setBalance("Balance:");
        accountInfoNode.setBalanceEg("Balance(EGP):");
        accountInfoNode.setNextMonth("Next Month:");
        accountInfoNode.setIdValue(account.getId());
        accountInfoNode.setBalanceValue(String.format("%.2f", account.getBalance()));
        accountInfoNode.setBalanceEgValue(String.format("%.2f", account.getBalanceEG()));
        if (account instanceof mainClasses.InvestmentAccount) {
            accountInfoNode.setNextMonthValue(String.format("%.2f", account.getBalanceAfterIncrease()));
        } else {
            accountInfoNode.setNextMonthValue("");
        }
    }

    public void reset() {
        customerInfoNode.setNameTextfield("");
        customerInfoNode.setPasswordTextfield("");
        customerInfoNode.setPhoneTextfield("");
        customerInfoNode.setSingedId(null);
        accountInfoNode.reset();
    }
}
