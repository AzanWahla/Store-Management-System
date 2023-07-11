//FA22

import Store.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AddEmployeeScreen {
    public Label title;
    public TextField employeeID;
    public TextField employeeName;
    public TextField employeeAddress;
    public TextField employeePhone;
    public RadioButton manager;
    public RadioButton worker;
    public Label employeePostion;
    public Button addEmployee;
    public Button clear;
    public Button back;

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

    public void AddEmployee(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        int id=0;
        int flag=0;

        if(employeeID.getText().matches("[0-9]*")){
            id=Integer.parseInt(employeeID.getText());
            flag=1;
        }
        else{
            new Alert(Alert.AlertType.ERROR,"You have Entered Wrong Type...").showAndWait();
            flag=0;
        }

        if(flag==1){
            if(manager.isSelected()) {
                Employee employee = new Managers(id, employeeName.getText(), employeeAddress.getText(), employeePhone.getText(),"Manager");
                Employee.add(employee);
                new Alert(Alert.AlertType.INFORMATION,"Employee is Added in Record...").showAndWait();
            }
            if(worker.isSelected()) {
                Employee employee = new Workers(id, employeeName.getText(), employeeAddress.getText(), employeePhone.getText(),"Worker");
                Employee.add(employee);
                new Alert(Alert.AlertType.INFORMATION,"Employee is Added in Record...").showAndWait();
            }
        }

    }

    public void clearScreen(ActionEvent actionEvent) {
        employeeID.clear();
        employeeName.clear();
        employeeAddress.clear();
        employeePhone.clear();
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
}
