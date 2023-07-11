//FA22

import Store.Employee;
import Store.Managers;
import Store.Workers;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateEmployeeScreen {

    public TextField id;
    public Label title;
    public TextField NewEmployeeID;
    public TextField NewEmployeeName;
    public TextField NewEmployeeAddress;
    public TextField NewEmployeePhone;
    public Button addItem;
    public Button clear;
    public Button back;
    public RadioButton manager;
    public RadioButton worker;
    public Label employeePostion;

    public void AddItem(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        int ID=0;
        int flag=0;

        if(id.getText().matches("[0-9]*")){
            ID=Integer.parseInt(id.getText());
            flag=1;
        }
        else{
            new Alert(Alert.AlertType.ERROR,"You have Entered Wrong Type in ID To Change...").showAndWait();
            flag=0;
        }
        if(NewEmployeeID.getText().matches("[0-9]*")){
            flag=1;
        }
        else{
            new Alert(Alert.AlertType.ERROR,"You have Entered Wrong Type in New ID...").showAndWait();
            flag=0;
        }

        if(flag==1){
            if(manager.isSelected()) {
                Employee employee = new Managers(Integer.parseInt(NewEmployeeID.getText()), NewEmployeeName.getText(), NewEmployeeAddress.getText(), NewEmployeePhone.getText(),"Manager");
                Employee.update(ID,employee);
                new Alert(Alert.AlertType.INFORMATION,"Employee is Updated in Record...").showAndWait();
            }
            if(worker.isSelected()) {
                Employee employee = new Workers(Integer.parseInt(NewEmployeeID.getText()), NewEmployeeName.getText(), NewEmployeeAddress.getText(), NewEmployeePhone.getText(),"Worker");
                Employee.update(ID,employee);
                new Alert(Alert.AlertType.INFORMATION,"Employee is Updated in Record...").showAndWait();
            }
        }
    }

    public void clearScreen(ActionEvent actionEvent) {
        id.clear();
        NewEmployeeID.clear();
        NewEmployeeName.clear();
        NewEmployeeAddress.clear();
        NewEmployeePhone.clear();
    }

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeScreen.fxml"));
            stage.setTitle("Super Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void ManagerPosition(ActionEvent actionEvent) {
        if(manager.isSelected()){
            worker.setSelected(false);
        }
    }

    public void WorkerPosition(ActionEvent actionEvent) {
        if(worker.isSelected()){
            manager.setSelected(false);
        }
    }
}
