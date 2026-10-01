package Scenes;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class LoginScene{

    Text header;
    Button loginButton, signUpButton;
    Label idLabel, passwordLabel;
    GridPane gridPane;
    TextField idTextfield;
    PasswordField passwordField;
    Scene scene;
    ImageView imageView;


    public LoginScene(){
        init();
        builder();
        style();
    }

    public void init(){
        header = new Text("Log in Page");
        loginButton = new Button("Log in");
        signUpButton = new Button("Go to Sign up");

        idLabel = new Label("ID:");
        passwordLabel = new Label("Password:");

        idTextfield = new TextField();
        passwordField = new PasswordField();

        imageView = new ImageView(new Image(LoginScene.class.getResourceAsStream("/BankFX.png")));


        gridPane = new GridPane();
        scene = new Scene(gridPane,700,500);
    }

    public void builder(){
        header.setTranslateX(50);
        header.setTranslateY(-15);
        imageView.setTranslateX(-50);
        imageView.setTranslateY(-15);
        gridPane.setTranslateX(60);

        gridPane.add(imageView,0,0,4,1);
        gridPane.add(header,1,1,2,1);
        gridPane.add(idLabel, 1, 2);
        gridPane.add(passwordLabel, 1, 3);
        gridPane.add(idTextfield, 2, 2);
        gridPane.add(passwordField, 2, 3);
        gridPane.add(loginButton, 1, 4);
        gridPane.add(signUpButton, 2, 4);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
    }

    public void style(){
        header.getStyleClass().add("title");
        idLabel.getStyleClass().add("label");
        idTextfield.getStyleClass().add("textfield");
        passwordField.getStyleClass().add("textfield");
        loginButton.getStyleClass().add("button");
        signUpButton.setStyle("-fx-font-size: 15px;\n" +
                "     -fx-font-weight: bold;\n" +
                "     -fx-text-fill: #1178fe;\n" +
                "     -fx-font-family: \"Arial\";\n" +
                "     -fx-background-color: #F9F9F9;\n" +
                "     -fx-border: solid #D9D9D9;\n" +
                "     -fx-border-radius: 5px;");
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }

    public Scene getScene(){
        return scene;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getSignUpButton() {
        return signUpButton;
    }

    public TextField getIdTextfield() {
        return idTextfield;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }
}
