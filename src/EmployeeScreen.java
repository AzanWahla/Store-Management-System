//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeScreen {
    public Button addEmployee;
    public Button back;
    public Button close;
    public Button displayEmployee;
    public Button deleteEmployee;
    public Button updateEmployee;
    public Label title;

    public void addEmployeeScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) addEmployee.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("addEmployeeScreen.fxml"));
            stage.setTitle("main");
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

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    public void displayEmployeeScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("DisplayEmployeeScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void deleteEmployeeScreen(ActionEvent actionEvent) {

        Stage stage = (Stage) deleteEmployee.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("DeleteEmployeeScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void updateEmployeeScreeen(ActionEvent actionEvent) {
        Stage stage = (Stage) updateEmployee.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("UpdateEmployeeScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }

    }
}
