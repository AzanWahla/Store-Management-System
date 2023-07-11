//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AddOrderScreen {
    public Button newCustomer;
    public Label title;
    public Button back;
    public Button oldCustomer;
    public Button close;

    public void NewCustomer(ActionEvent actionEvent) {
        Stage stage = (Stage) newCustomer.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("NewCustomerScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a) {
            a.printStackTrace();
        }
    }

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("OrderScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a) {
            System.out.println(a.getMessage());
        }
    }

    public void OldCustomer(ActionEvent actionEvent) {
        Stage stage = (Stage) oldCustomer.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("OldCustomerScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a) {
            a.printStackTrace();
        }
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
