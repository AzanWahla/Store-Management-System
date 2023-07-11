//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemScreen {
    public Button addItem;
    public Button back;
    public Button displayItem;
    public Button updateItem;
    public Button deleteItem;
    public Button close;

    public void addItemScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) addItem.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("AddItemScreen.fxml"));
            stage.setTitle("Super Store Management System");
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
            stage.setTitle("Super Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void displayItemScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) displayItem.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("DisplayItemScreen.fxml"));
            stage.setTitle("Super Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void updateItemScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) updateItem.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("UpdateItemScreen.fxml"));
            stage.setTitle("Super Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void deleteItemScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("DeleteItemScreen.fxml"));
            stage.setTitle("Super Store Management System");
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
