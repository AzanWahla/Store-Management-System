//FA22

import Store.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AddItemScreen {
    public TextField itemID;
    public TextField itemName;
    public TextField itemPrice;
    public TextField itemQuantity;
    public RadioButton householdItem;
    public RadioButton groceryItem;
    public Label itemType;
    public Button addItem;
    public Button clear;
    public Button back;

    public void HouseholdItem(ActionEvent actionEvent) {
        if(householdItem.isSelected())
            groceryItem.setSelected(false);
    }

    public void GroceryItem(ActionEvent actionEvent) {
        if(groceryItem.isSelected())
            householdItem.setSelected(false);
    }

    public void AddItem(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        int id = 0;
        double price=0;
        int quantity=0;
        int flag=0;
        if(itemID.getText().matches("[0-9]*")){
            id=Integer.parseInt(itemID.getText());
            flag=1;
        }
        else{
            showErrorAlert("Error","You have Entered Wrong Type in ID...");
            flag=0;
        }

        if(itemPrice.getText().matches("[0-9]*")){
            price=Double.parseDouble(itemPrice.getText());
            flag=1;
        }
        else{
            showErrorAlert("Error","You have Entered Wrong Type in Price...");
            flag=0;
        }


        if(itemQuantity.getText().matches("[0-9]*")){
            quantity=Integer.parseInt(itemQuantity.getText());
            flag=1;
        }
        else{
            showErrorAlert("Error","You have Entered Wrong Type in Quantity...");
            flag=0;
        }


        if(flag==1){
            if(householdItem.isSelected()) {
                Item item = new HouseholdItems(id, itemName.getText(), price, quantity,"HouseHold");
                Item.add(item);
                showSuccessAlert("Congrats", "Item is Added in Record...");
            }
            if(groceryItem.isSelected()) {
                Item item = new GroceryItems(id, itemName.getText(), price, quantity,"Grocery");
                Item.add(item);
                showSuccessAlert("Congrats", "Item is Added in Record...");
            }
        }

    }

    public void clearScreen(ActionEvent actionEvent) {
        itemID.clear();
        itemName.clear();
        itemPrice.clear();
        itemQuantity.clear();
        householdItem.setSelected(false);
        groceryItem.setSelected(false);
    }

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("ItemScreen.fxml"));
            stage.setTitle("Super Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }
    void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    void showSuccessAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
