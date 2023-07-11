//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Store.*;

import java.io.IOException;

public class AddCustomerScreen {

    public TextField customerID;
    public TextField customerName;
    public TextField customerAddress;
    public TextField customerPhone;
    public Button addCustomer;
    public Button clear;
    public Button back;
    public Label title;

    public void AddCustomer(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        int id = 0;
        int flag=0;
        if(customerID.getText().matches("[0-9]*")){
            id=Integer.parseInt(customerID.getText());
            flag=1;
        }
        else{
            showErrorAlert("Error","You have Entered Wrong Type in ID...");
            flag=0;
        }



        if(flag==1){
            Customer customer=new Customer(id,customerName.getText(),customerAddress.getText(),customerPhone.getText());
            Customer.add(customer);
            showSuccessAlert("Congrats", "Customer is Added in Record...");
        }

    }

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("CustomerScreen.fxml"));
            stage.setTitle("Super Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void clearScreen(ActionEvent actionEvent) {
        customerID.clear();
        customerName.clear();
        customerAddress.clear();
        customerPhone.clear();
    }

    void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    void showSuccessAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
