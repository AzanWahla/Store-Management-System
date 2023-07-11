//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeViewScreen {
    public Button item;
    public Button order;
    public Button employee;
    public Button customer;
    public Button back;
    public Button close;

    public void itemScreen(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.ERROR,"You don't Have Access to this Feature...").showAndWait();

    }

    public void orderScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) order.getScene().getWindow();
        try{
            FXMLLoader fx=new FXMLLoader(Main.class.getResource("OrderScreen.fxml"));

            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void employeeScreen(ActionEvent actionEvent) {
    new Alert(Alert.AlertType.ERROR,"You don't Have Access to this Feature...").showAndWait();
    }

    public void customerScreen(ActionEvent actionEvent)  {
        Stage stage = (Stage) customer.getScene().getWindow();
        try{
            FXMLLoader fx=new FXMLLoader(Main.class.getResource("CustomerScreen.fxml"));

            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
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

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
