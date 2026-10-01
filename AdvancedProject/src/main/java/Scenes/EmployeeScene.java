package Scenes;

import Nodes.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import mainClasses.Customer;
import mainClasses.Employee;


public class EmployeeScene {
    Label header;
    Button logoutButton;
    GridPane gridPane;
    CustomersTable customersTable;
    EmployeeInfoNode employeeInfoNode;
    CreateNorAccNode createNorAccNode;
    CreateInvAccNode createInvAccNode;
    DeleteAccNode deleteAccNode;
    DipWithNode dipWithNode;
    ImageView imageView;
    Scene scene;

    public EmployeeScene(){
        init();
        builder();
        style();
    }
    public void init(){
        imageView = new ImageView(new Image(EmployeeScene.class.getResourceAsStream("/BankFX.png")));
        header = new Label("Customers");
        logoutButton = new Button("Logout");
        gridPane = new GridPane();
        customersTable = new CustomersTable();
        createInvAccNode = new CreateInvAccNode();
        createNorAccNode = new CreateNorAccNode();
        deleteAccNode = new DeleteAccNode();
        dipWithNode = new DipWithNode();
        employeeInfoNode = new EmployeeInfoNode();
        scene = new Scene(gridPane,1200,700);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }
    public void builder(){
        header.setTranslateX(180);
        logoutButton.setTranslateX(100);
        imageView.setTranslateX(390);
        employeeInfoNode.getAsElement().setTranslateX(50);

        gridPane.add(imageView,0,0,3,1);
        gridPane.add(header,2,1);
        gridPane.add(logoutButton,3,1);
        gridPane.add(employeeInfoNode.getAsElement(),1,2);
        gridPane.add(createInvAccNode.getAsElement(),1,3);
        gridPane.add(createNorAccNode.getAsElement(),1,4);
        gridPane.add(deleteAccNode.getAsElement(),1,5);
        gridPane.add(customersTable.getAsElement(),2,2,1,4);
        gridPane.add(dipWithNode.getAsElement(),3,2,1,4);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPrefWidth(1000);
        gridPane.setPrefHeight(700);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }
    public void style(){

    }
    public Scene getScene(){
        return scene;
    }
    public TableView<Customer> getCustomersTable(){
        return customersTable.getAsTable();
    }

    public Button getLogoutButton() {
        return logoutButton;
    }

    public EmployeeInfoNode getEmployeeInfoNode() {
        return employeeInfoNode;
    }

    public CreateNorAccNode getCreateNorAccNode() {
        return createNorAccNode;
    }

    public CreateInvAccNode getCreateInvAccNode() {
        return createInvAccNode;
    }

    public DeleteAccNode getDeleteAccNode() {
        return deleteAccNode;
    }

    public DipWithNode getDipWithNode() {
        return dipWithNode;
    }
}
