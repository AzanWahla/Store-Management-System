//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderScreen {
    public Button addOrder;
    public Button back;
    public Button viewOrder;
    public Button close;

    public void addOrderScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) addOrder.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("AddOrderScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a) {
            System.out.println(a.getMessage());
        }
    }

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a) {
            System.out.println(a.getMessage());
        }
    }


    public void viewOrderScreen(ActionEvent actionEvent) {
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
