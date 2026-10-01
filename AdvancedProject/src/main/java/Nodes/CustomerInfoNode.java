package Nodes;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CustomerInfoNode {
    Text header;
    String singedId;
    Label name; TextField nameTextfield;
    Label password; PasswordField passwordTextfield;
    Label phone; TextField phoneTextfield;
    GridPane gridPane;
    Button nameChangeButton,phoneChangeButton,passwordChangeButton;
    public CustomerInfoNode(){
        init();
        builder();
        style();
    }

    public void init(){
        header = new Text("Customer");
        name = new Label("Name:");
        password = new Label("Password:");
        phone = new Label("Phone:");
        nameChangeButton = new Button("Change");
        phoneChangeButton = new Button("Change");
        passwordChangeButton = new Button("Change");
        nameTextfield = new TextField();
        passwordTextfield = new PasswordField();
        phoneTextfield = new TextField();
        gridPane = new GridPane();
    }
    public void builder(){
        gridPane.add(header,0,0,2,1);
        gridPane.add(name,0,1);
        gridPane.add(nameTextfield,1,1);
        gridPane.add(phone,0,2);
        gridPane.add(phoneTextfield,1,2);
        gridPane.add(password,0,3);
        gridPane.add(passwordTextfield,1,3);
        gridPane.add(nameChangeButton,2,1);
        gridPane.add(phoneChangeButton,2,2);
        gridPane.add(passwordChangeButton,2,3);
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }

    public void style(){
        header.getStyleClass().add("title");
        name.getStyleClass().add("label");
        password.getStyleClass().add("label");
        phone.getStyleClass().add("label");
        nameTextfield.getStyleClass().add("textfield");
        passwordTextfield.getStyleClass().add("textfield");
        phoneTextfield.getStyleClass().add("textfield");
        nameChangeButton.getStyleClass().add("button");
        phoneChangeButton.getStyleClass().add("button");
        passwordChangeButton.getStyleClass().add("button");
    }

    public Node getAsElement(){
        return gridPane;
    }

    public void setNameTextfield(String nameTextfield) {
        this.nameTextfield.setText(nameTextfield);
    }

    public void setPasswordTextfield(String passwordTextfield) {
        this.passwordTextfield.setText(passwordTextfield);
    }

    public void setPhoneTextfield(String phoneTextfield) {
        this.phoneTextfield.setText(phoneTextfield);
    }

    public String getSingedId() {
        return singedId;
    }

    public void setSingedId(String singedId) {
        this.singedId = singedId;
    }

    public TextField getNameTextfield() {
        return nameTextfield;
    }

    public PasswordField getPasswordTextfield() {
        return passwordTextfield;
    }

    public TextField getPhoneTextfield() {
        return phoneTextfield;
    }

    public Button getNameChangeButton() {
        return nameChangeButton;
    }

    public Button getPhoneChangeButton() {
        return phoneChangeButton;
    }

    public Button getPasswordChangeButton() {
        return passwordChangeButton;
    }
}
