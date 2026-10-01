package Nodes;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AccountInfoNode {
    Text header;
    Label id; Label idValue;
    Label balance; Label balanceValue;
    Label balanceEg; Label balanceEgValue;
    Label nextMonth; Label nextMonthValue;

    GridPane gridPane;
    public AccountInfoNode(){
        init();
        builder();
        style();
    }

    public void init(){
        header = new Text("Account");
        id = new Label("ID:");
        balance = new Label("Balance:");
        balanceEg = new Label("Balance(EGP):");
        nextMonth = new Label("Next Month:");
        idValue = new Label();
        balanceValue = new Label();
        balanceEgValue = new Label();
        nextMonthValue = new Label();
        gridPane = new GridPane();
    }
    public void builder(){
        gridPane.add(header,0,0,2,1);
        gridPane.add(id,0,1);
        gridPane.add(idValue,1,1);
        gridPane.add(balance,0,2);
        gridPane.add(balanceValue,1,2);
        gridPane.add(balanceEg,0,3);
        gridPane.add(balanceEgValue,1,3);
        gridPane.add(nextMonth,0,4);
        gridPane.add(nextMonthValue,1,4);
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }

    public void style(){
        header.getStyleClass().add("title");
        id.getStyleClass().add("label");
        balance.getStyleClass().add("label");
        balanceEg.getStyleClass().add("label");
        idValue.getStyleClass().add("label");
        balanceValue.getStyleClass().add("label");
        balanceEgValue.getStyleClass().add("label");
        nextMonth.getStyleClass().add("label");
        nextMonthValue.getStyleClass().add("label");
    }

    public Node getAsElement(){
        return gridPane;
    }

    public void setId(String id) {
        this.id.setText(id);
    }

    public void setBalance(String balance) {
        this.balance.setText(balance);
    }

    public void setBalanceEg(String balanceEg) {
        this.balanceEg.setText(balanceEg);
    }

    public void setNextMonth(String nextMonth){
        this.nextMonth.setText(nextMonth);
    }

    public void setIdValue(String idValue) {
        this.idValue.setText(idValue);
    }

    public void setBalanceValue(String balanceValue) {
        this.balanceValue.setText(balanceValue);
    }

    public void setBalanceEgValue(String balanceEgValue) {
        this.balanceEgValue.setText(balanceEgValue);
    }

    public void setNextMonthValue(String nextMonthValue){
        this.nextMonthValue.setText(nextMonthValue);
    }

    public void reset() {
        setId("ID:");
        setBalance("Balance:");
        setBalanceEg("Balance(EGP):");
        setNextMonth("Next Month:");
        setIdValue("");
        setBalanceValue("");
        setBalanceEgValue("");
        setNextMonthValue("");
    }


}
