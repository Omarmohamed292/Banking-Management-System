package Nodes;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DipWithNode {
    Text depositHeader;
    Label depositIdLabel;
    TextField depositIdTextField;
    Label depositAmountLabel;
    TextField depositAmountTextField;
    Button depositButton;
    GridPane depositgridPane;

    Text withdrawHeader;
    Label withdrawIdLabel;
    TextField withdrawIdTextField;
    Label withdrawAmountLabel;
    TextField withdrawAmountTextField;
    Button withdrawButton;
    GridPane withdrawgridPane;

    VBox vBox;
    public DipWithNode(){
        init();
        builder();
        style();
    }
    public void init(){
        depositHeader = new Text("Deposit into Acc by id ");
        depositIdLabel = new Label("ID");
        depositIdTextField = new TextField();
        depositAmountLabel = new Label("Amount");
        depositAmountTextField = new TextField();
        depositButton = new Button("Deposit");
        depositgridPane = new GridPane();

        withdrawHeader = new Text("Withdraw from Acc by id");
        withdrawIdLabel = new Label("ID");
        withdrawIdTextField = new TextField();
        withdrawAmountLabel = new Label("Amount");
        withdrawAmountTextField = new TextField();
        withdrawButton = new Button("Withdraw");
        withdrawgridPane = new GridPane();

        vBox = new VBox();
    }
    public void builder(){
        depositgridPane.add(depositHeader,0,0,3,1);
        depositgridPane.add(depositIdLabel,0,1);
        depositgridPane.add(depositIdTextField,1,1,3,1);
        depositgridPane.add(depositAmountLabel,0,2);
        depositgridPane.add(depositAmountTextField,1,2,3,1);
        depositgridPane.add(depositButton,0,3);
        depositgridPane.setAlignment(Pos.CENTER);
        depositgridPane.setHgap(10);
        depositgridPane.setVgap(10);

        withdrawgridPane.add(withdrawHeader,0,0,3,1);
        withdrawgridPane.add(withdrawIdLabel,0,1);
        withdrawgridPane.add(withdrawIdTextField,1,1,3,1);
        withdrawgridPane.add(withdrawAmountLabel,0,2);
        withdrawgridPane.add(withdrawAmountTextField,1,2,3,1);
        withdrawgridPane.add(withdrawButton,0,3);
        withdrawgridPane.setAlignment(Pos.CENTER);
        withdrawgridPane.setHgap(10);
        withdrawgridPane.setVgap(10);

        vBox.getChildren().addAll(depositgridPane,withdrawgridPane);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
    }
    public void style(){
        depositHeader.getStyleClass().add("title");
        depositIdLabel.getStyleClass().add("label");
        depositIdTextField.getStyleClass().add("textfield");
        depositAmountLabel.getStyleClass().add("label");
        depositAmountTextField.getStyleClass().add("textfield");
        depositButton.getStyleClass().add("button");

        withdrawHeader.getStyleClass().add("title");
        withdrawIdLabel.getStyleClass().add("label");
        withdrawIdTextField.getStyleClass().add("textfield");
        withdrawAmountLabel.getStyleClass().add("label");
        withdrawAmountTextField.getStyleClass().add("textfield");
        withdrawButton.getStyleClass().add("button");
    }

    public TextField getDepositIdTextField() {
        return depositIdTextField;
    }

    public TextField getDepositAmountTextField() {
        return depositAmountTextField;
    }

    public Button getDepositButton() {
        return depositButton;
    }

    public TextField getWithdrawIdTextField() {
        return withdrawIdTextField;
    }

    public TextField getWithdrawAmountTextField() {
        return withdrawAmountTextField;
    }

    public Button getWithdrawButton() {
        return withdrawButton;
    }

    public Node getAsElement(){
        return vBox;
    }
}
