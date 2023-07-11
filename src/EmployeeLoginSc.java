//FA22


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeLoginSc {
    public TextField UsernameEmployeeLoginlb;
    public PasswordField EMployeeLoginPasswordLb;
    public Button LOGINEMployeeBUtton;
    public Button BACKLoginE;
    String user="AZAN";
    String pass="AZAN";
    public static String WorkingEmployeeDSale;

    public void LoginEmployeeButton(ActionEvent actionEvent) throws IOException {
        if (UsernameEmployeeLoginlb.getText().equals(user) && EMployeeLoginPasswordLb.getText().equals(pass)) {
            Stage stage = (Stage) LOGINEMployeeBUtton.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeScreen.fxml"));
            stage.setTitle("main");
            stage.setScene(new Scene(fx.load()));
            System.out.println("correct");
            stage.show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Username or Password Not Match").show();
        }


    }


    public void BACKLoginF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) LOGINEMployeeBUtton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("Screen.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }


}


