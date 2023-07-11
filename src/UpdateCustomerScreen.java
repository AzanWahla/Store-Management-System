//FA22

import Store.Customer;
import Store.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateCustomerScreen {
    public TextField id;
    public Label title;
    public TextField NewCustomerID;
    public TextField NewCustomerName;
    public TextField NewCustomerAddress;
    public TextField NewCustomerPhone;
    public Button AddCustomer;
    public Button clear;
    public Button back;

    public void clearScreen(ActionEvent actionEvent) {
        id.clear();
        NewCustomerID.clear();
        NewCustomerName.clear();
        NewCustomerAddress.clear();
        NewCustomerPhone.clear();
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

    public void AddCustomer(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        int ID = 0;
        int flag=0;
        if(id.getText().matches("[0-9]*")){
            ID=Integer.parseInt(id.getText());
            flag=1;
        }
        else{
            showErrorAlert("Error","You have Entered Wrong Type in ID...");
            flag=0;
        }



        if(flag==1){
            Customer customer=new Customer(Integer.parseInt(NewCustomerID.getText()),NewCustomerName.getText(),NewCustomerAddress.getText(),NewCustomerPhone.getText());
            if(Customer.update(ID,customer)==1) {
                showSuccessAlert("Congrats", "Customer is Updated in Record...");
            }
            else{
                showErrorAlert("Error","Customer ID not Found in Record...");
            }
        }

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
