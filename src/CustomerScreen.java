//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerScreen {
    public Button addCustomer;
    public Button updateCustomer;
    public Button deleteCustomer;
    public Button displayCustomer;
    public Button back;
    public Button close;

    public void addCustomerScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) addCustomer.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("AddCustomerScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void updateCustomerScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) updateCustomer.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("UpdateCustomerScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }

    }

    public void deleteCustomerScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) deleteCustomer.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("DeleteCustomerScreen.fxml"));
            stage.setTitle("main");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }

    }

    public void displayCustomerScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) displayCustomer.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("DisplayCustomerScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
            stage.setTitle("main");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void closeScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
