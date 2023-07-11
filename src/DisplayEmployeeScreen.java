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

public class DisplayEmployeeScreen implements Initializable {
    public Label title;
    public Button back;
    public Button close;
    public ArrayList<Employee> employeeArrayList =new ArrayList<Employee>();
    public TableView<Employee> table = new TableView<Employee>();
    public TableColumn<Employee, Integer> ColID = new TableColumn<Employee, Integer>();
    public TableColumn<Employee, String> ColName=new TableColumn<Employee, String>();
    public TableColumn<Employee, String> ColAddress=new TableColumn<Employee, String>();
    public TableColumn<Employee, String > ColPhone=new TableColumn<Employee, String>();
    public TableColumn<Employee, String > ColPosition=new TableColumn<Employee, String>();

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeScreen.fxml"));
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
            ColPosition.setCellValueFactory(new PropertyValueFactory<>("position"));

            // Set the ObservableList as the data source for the TableView
            table.setItems(dataModel());
        } catch (IOException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).showAndWait();
        }

    }


    private ObservableList<Employee> dataModel() throws IOException, ClassNotFoundException {

        employeeArrayList=(ArrayList<Employee>) Employee.display();
        ObservableList<Employee> productList = FXCollections.observableArrayList(employeeArrayList);
        table.setItems(productList);
        Employee.ListEmployee.clear();
        return productList;


    }
}