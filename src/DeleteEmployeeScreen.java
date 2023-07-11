//FA22

import Store.Customer;
import Store.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteEmployeeScreen {
    public Label title;
    public TextField employeeID;
    public Button search;
    public Button close;
    public Label notFound;
    public Button back;
    public Label found;
    public Label isFound;

    public void searchButton(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        int flag=0;
        if(employeeID.getText().matches("[0-9]*")){
            int id= Integer.parseInt(employeeID.getText());
            flag=1;
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Wrong Type Entered ...").showAndWait();
            flag=0;
        }
        int id= Integer.parseInt(employeeID.getText());
        if(flag==1){
            if(Employee.remove(id)==1){
                isFound.setText("Item Found & Deleted");
                isFound.setTextFill(Color.GREEN);
            }
            else{
                isFound.setText("Item Not Found");
                isFound.setTextFill(Color.RED);
            }
        }
    }

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeScreen.fxml"));
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
