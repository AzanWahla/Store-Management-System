//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen {

    public Label title;
    public Button manager;
    public Button employee;
    public Button back;
    public Button close;

    public void managerScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) manager.getScene().getWindow();
        try {
            stage.setScene(new Scene(new FXMLLoader(Main.class.getResource("ManagerLogin.fxml")).load()));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }*/
    }

    public void employeeScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) employee.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeLoginSc.fxml"));
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
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("Screen.fxml"));
            stage.setTitle("Store Management System");
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
