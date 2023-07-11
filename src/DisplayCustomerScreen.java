//FA22

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Store.*;

public class DisplayCustomerScreen implements Initializable {
    public Label title;
    public Button back;
    public Button close;
    public ArrayList<Customer> customerArrayList =new ArrayList<Customer>();
    public TableView<Customer> table = new TableView<Customer>();
    public TableColumn<Customer, Integer> ColID = new TableColumn<Customer, Integer>();
    public TableColumn<Customer, String> ColName=new TableColumn<Customer, String>();
    public TableColumn<Customer, String> ColAddress=new TableColumn<Customer, String>();
    public TableColumn<Customer, String> ColPhone=new TableColumn<Customer, String>();

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("CustomerScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a) {
            System.out.println(a.getMessage());
        }
    }

    public void closeScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ColID.setCellValueFactory(new PropertyValueFactory<>("id"));
            ColName.setCellValueFactory(new PropertyValueFactory<>("name"));
            ColAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            ColPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

            // Set the ObservableList as the data source for the TableView
            table.setItems(dataModel());
        } catch (IOException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).showAndWait();
        }

    }


    private ObservableList<Customer> dataModel() throws IOException, ClassNotFoundException {

        customerArrayList=(ArrayList<Customer>) Customer.display();
        ObservableList<Customer> productList = FXCollections.observableArrayList(customerArrayList);
        table.setItems(productList);
        Customer.ListCustomer.clear();
        return productList;


    }
}