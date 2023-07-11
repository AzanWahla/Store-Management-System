//FA22

import Store.GroceryItems;
import Store.HouseholdItems;
import Store.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateItemScreen {
    public Label title;
    public TextField NewItemID;
    public TextField NewItemName;
    public TextField NewItemPrice;
    public TextField NewItemQuantity;
    public Label itemType;
    public RadioButton householdItem;
    public RadioButton groceryItem;
    public Button addItem;
    public Button clear;
    public Button back;
    public TextField id;

    public void HouseholdItem(ActionEvent actionEvent) {
        if(householdItem.isSelected())
            groceryItem.setSelected(false);
    }

    public void GroceryItem(ActionEvent actionEvent) {
        if(groceryItem.isSelected())
            householdItem.setSelected(false);
    }

    public void AddItem(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        int change=0;
        int Id = 0;
        double price=0;
        int quantity=0;
        int flag=0;
        if(id.getText().matches("[0-9]*")){
            change=Integer.parseInt(id.getText());
            flag=1;
        }
        else{
            showErrorAlert("Error","You have Entered Wrong Type in ID...");
            flag=0;
        }
        if(NewItemID.getText().matches("[0-9]*")){
            Id=Integer.parseInt(NewItemID.getText());
            flag=1;
        }
        else{
            showErrorAlert("Error","You have Entered Wrong Type in ID...");
            flag=0;
        }

        if(NewItemPrice.getText().matches("[0-9]*")){
            price=Integer.parseInt(NewItemID.getText());
            flag=1;
        }
        else{
            showErrorAlert("Error","You have Entered Wrong Type in Price...");
            flag=0;
        }


        if(NewItemQuantity.getText().matches("[0-9]*")){
            quantity=Integer.parseInt(NewItemID.getText());
            flag=1;
        }
        else{
            showErrorAlert("Error","You have Entered Wrong Type in Quantity...");
            flag=0;
        }


        if(flag==1){
            if(householdItem.isSelected()) {
                Item item = new HouseholdItems(Id, NewItemName.getText(), price, quantity,"HouseHold");
                if(Item.update(change,item)==1) {
                    showSuccessAlert("Congrats", "Item is Updated in Record...");
                }
                else{
                    showErrorAlert("Error","Item ID not Found in Record...");
                }
            }
            if(groceryItem.isSelected()) {
                Item item = new GroceryItems(Id, NewItemName.getText(), price, quantity,"Grocery");
                if(Item.update(change,item)==1) {
                    showSuccessAlert("Congrats", "Item is Updated in Record...");
                }
                else{
                    showErrorAlert("Error","Item ID not Found in Record...");
                }
            }
        }
    }

    public void clearScreen(ActionEvent actionEvent) {

        NewItemID.clear();
        NewItemName.clear();
        NewItemPrice.clear();
        NewItemQuantity.clear();
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
