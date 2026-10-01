package Nodes;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class EmployeeInfoNode {
    Text header;
    Label name; Label nameValue;
    Label id; Label idValue;
    Label phone; Label phoneValue;
    GridPane gridPane;
    public EmployeeInfoNode(){
        init();
        builder();
        style();
    }

    public void init(){
        header = new Text("Employee");
        name = new Label("Name:");
        id = new Label("ID:");
        phone = new Label("Phone:");
        nameValue = new Label();
        idValue = new Label();
        phoneValue = new Label();
        gridPane = new GridPane();
    }
    public void builder(){
        gridPane.add(header,0,0,2,1);
        gridPane.add(name,0,1);
        gridPane.add(nameValue,1,1);
        gridPane.add(phone,0,2);
        gridPane.add(phoneValue,1,2);
        gridPane.add(id,0,3); //0 2
        gridPane.add(idValue,1,3);// 1 2
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }

    public void style(){
        header.getStyleClass().add("label");
        name.getStyleClass().add("label");
        id.getStyleClass().add("label");
        phone.getStyleClass().add("label");
        nameValue.getStyleClass().add("label");
        idValue.getStyleClass().add("label");
        phoneValue.getStyleClass().add("label");
    }

    public Node getAsElement(){
        return gridPane;
    }

    public void setNameValue(String nameValue) {
        this.nameValue.setText(nameValue);
    }

    public void setIdValue(String idValue) {
        this.idValue.setText(idValue);
    }

    public void setPhoneValue(String phoneValue) {
        this.phoneValue.setText(phoneValue);
    }
}
