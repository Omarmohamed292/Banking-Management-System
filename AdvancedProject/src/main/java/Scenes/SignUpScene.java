package Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class SignUpScene {
    ImageView imageView;
    Text header;
    Label idLabel;
    Label nameLabel;
    Label phoneLabel;
    Label passwordLabel;

    TextField idTextfield;
    TextField nameTextfield;
    TextField phoneTextfield;
    PasswordField passwordField;
    CheckBox agreeCheckBox;
    Button signUpButton,loginButton;
    GridPane gridPane;
    Scene scene;

    public SignUpScene(){
        init();
        builder();
        style();
    }

    public void init(){
        imageView = new ImageView(new Image(SignUpScene.class.getResourceAsStream("/BankFX.png")));

        header = new Text("Sign up Page");
        idLabel = new Label("ID:");
        nameLabel = new Label("Name: ");
        phoneLabel = new Label("Phone: ");
        passwordLabel = new Label("Password: ");
        idTextfield = new TextField();
        nameTextfield = new TextField();
        phoneTextfield = new TextField();
        passwordField = new PasswordField();

        agreeCheckBox = new CheckBox("I agree -------------");
        signUpButton = new Button("Sign Up");
        loginButton = new Button("Go to login");

        gridPane = new GridPane();
        scene = new Scene(gridPane, 700, 700);
    }

    public void builder(){
        header.setTranslateX(50);
        header.setTranslateY(-15);
        imageView.setTranslateX(-50);
        imageView.setTranslateY(-15);
        gridPane.setTranslateX(60);

        gridPane.add(imageView,0,0,4,1);
        gridPane.add(header,1,1,2,1);
        gridPane.add(idLabel,1,2);
        gridPane.add(idTextfield,2,2);
        gridPane.add(nameLabel, 1, 3);
        gridPane.add(nameTextfield, 2, 3);
        gridPane.add(phoneLabel, 1, 4);
        gridPane.add(phoneTextfield, 2, 4);
        gridPane.add(passwordLabel, 1, 5);
        gridPane.add(passwordField, 2, 5);
        gridPane.add(agreeCheckBox, 1, 6, 2, 1);
        gridPane.add(signUpButton, 1, 7);
        gridPane.add(loginButton,2,7);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(13);
        gridPane.setVgap(13);
    }
    public void style(){
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        header.getStyleClass().add("title");
        idLabel.getStyleClass().add("label");
        nameLabel.getStyleClass().add("label");
        phoneLabel.getStyleClass().add("label");
        passwordLabel.getStyleClass().add("label");
        idTextfield.getStyleClass().add("textfield");
        nameTextfield.getStyleClass().add("textfield");
        phoneTextfield.getStyleClass().add("textfield");
        passwordField.getStyleClass().add("textfield");
        signUpButton.getStyleClass().add("button");
        loginButton.setStyle("-fx-font-size: 15px;\n" +
                "     -fx-font-weight: bold;\n" +
                "     -fx-text-fill: #1178fe;\n" +
                "     -fx-font-family: \"Arial\";\n" +
                "     -fx-background-color: #F9F9F9;\n" +
                "     -fx-border: solid #D9D9D9;\n" +
                "     -fx-border-radius: 5px;");
    }

    public Scene getScene(){
        return scene;
    }

    public TextField getNameTextfield() {
        return nameTextfield;
    }

    public TextField getPhoneTextfield() {
        return phoneTextfield;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getSignUpButton() {
        return signUpButton;
    }

    public CheckBox getAgreeCheckBox() {
        return agreeCheckBox;
    }

    public TextField getIdTextfield() {
        return idTextfield;
    }

    public Button getLoginButton() {
        return loginButton;
    }
}
