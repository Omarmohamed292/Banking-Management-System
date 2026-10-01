package Nodes;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CreateInvAccNode {
    Text header;
    Label idLabel;
    TextField idTextField;
    Button createButton;
    GridPane gridPane;
    public CreateInvAccNode(){
        init();
        builder();
        style();
    }
    public void init(){
        header = new Text("Create Invest Acc by id");
        idLabel = new Label("ID");
        idTextField = new TextField();
        createButton = new Button("Create");
        gridPane = new GridPane();
    }
    public void builder(){
        gridPane.add(header,0,0,3,1);
        gridPane.add(idLabel,0,1);
        gridPane.add(idTextField,1,1,3,1);
        gridPane.add(createButton,0,2);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }
    public void style(){
        header.getStyleClass().add("title");
        idLabel.getStyleClass().add("label");
        idTextField.getStyleClass().add("textfield");
        createButton.getStyleClass().add("button");
    }

    public TextField getIdTextField() {
        return idTextField;
    }

    public Button getCreateButton() {
        return createButton;
    }

    public Node getAsElement(){
        return gridPane;
    }
}
