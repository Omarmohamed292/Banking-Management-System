package Nodes;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainClasses.Account;
import mainClasses.Customer;

public class CustomersTable {
    TableView<Customer> table;
    public CustomersTable(){
        inti();
        builder();
    }

    public void inti() {
        table = new TableView<>();
    }

    public void builder(){
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPlaceholder(new Label("No Customers to display"));

        TableColumn<Customer,String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setMaxWidth(150);

        TableColumn<Customer,String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneCol.setMaxWidth(150);

        TableColumn<Customer,String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setMaxWidth(150);


        TableColumn<Customer, Account> accountCol = new TableColumn<>("Account");
        accountCol.setCellValueFactory(new PropertyValueFactory<>("account"));
        accountCol.setPrefWidth(250);
        accountCol.setMaxWidth(350);

        table.setEditable(false);
        table.getColumns().addAll(nameCol,phoneCol,idCol,accountCol);
    }

    public Node getAsElement(){
        return table;
    }

    public TableView<Customer> getAsTable(){
        return table;
    }

}
