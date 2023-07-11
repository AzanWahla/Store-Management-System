//FA22

import Store.Customer;
import Store.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Store.Customer.ListCustomer;
import static Store.Item.*;


public class OldCustomerScreen implements Initializable {
    public TextField customerID;
    public TextField customerName;
    public TextField customerAddress;
    public TextField customerPhone;
    public Button reset;
    public Button back;
    public Button searchCustomer;
    public Button clearCustomer;
    public TextField itemID;
    public TextField itemName;
    public Label orlabel;
    public Button searchID;
    public Button searchName;
    public Button close;
    public Label amount;
    public Button purchase;
    public Label title;
    public Label isFound;
    public ArrayList<Item> itemArrayList =new ArrayList<Item>();
    public TableView<Item> table = new TableView<Item>();
    public TableColumn<Item, Integer> ColID = new TableColumn<Item, Integer>();
    public TableColumn<Item, String> ColName=new TableColumn<Item, String>();
    public TableColumn<Item, Double> ColPrice=new TableColumn<Item, Double>();
    public TableColumn<Item, Integer> ColQuantity=new TableColumn<Item, Integer>();
    public TableColumn<Item, Integer> ColQuantity2 = new TableColumn<>("Quantity");
    public Spinner<Integer> idSpinner;
    public Spinner<Integer> nameSpinner;
    public Label isFoundCustomer;


    public void resetScreen(ActionEvent actionEvent) {
        customerID.clear();
        customerName.clear();
        customerAddress.clear();
        customerPhone.clear();
        itemID.clear();
        itemName.clear();
        table.getItems().clear();

    }

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("AddOrderScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a) {
            System.out.println(a.getMessage());
        }
    }

    public void SearchCustomer(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        int flag=0;
        if(customerID.getText().matches("[0-9]*")){
            int id= Integer.parseInt(customerID.getText());
            flag=1;
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Wrong Type Entered ...").showAndWait();
            flag=0;
        }
        int id= Integer.parseInt(customerID.getText());
        if(flag==1){
            if(Customer.search(id)==1){
                isFoundCustomer.setText("Item Found & Deleted");
                isFoundCustomer.setTextFill(Color.GREEN);
            }
            else{
                isFoundCustomer.setText("Item Not Found");
                isFoundCustomer.setTextFill(Color.RED);
            }
        }
    }

    public void ClearCustomerScreen(ActionEvent actionEvent) {
        customerID.clear();
        customerName.clear();
        customerAddress.clear();
        customerPhone.clear();
    }

    public void SearchID(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        Item.ListItem.clear();
        if (new File("store_item.dat").exists())
            readFromItem();

        int flag=0;

        for (int i = 0; i < ListItem.size(); i++) {
            if(ListItem.get(i).getItemID()==Integer.parseInt(itemID.getText())){
                itemArrayList.add(ListItem.get(i));

                isFound.setText("Item Found...");
                isFound.setTextFill(Color.GREEN);

                flag=1;
            }

        }

        if(flag==0){
            isFound.setText("Item Not Found");
            isFound.setTextFill(Color.RED);
        }

        writeIntoItem();
        Item.ListItem.clear();

        ObservableList<Item> productList = FXCollections.observableArrayList(itemArrayList);
        table.setItems(productList);
    }

    public void SearchName(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        Item.ListItem.clear();
        if (new File("store_item.dat").exists())
            readFromItem();

        int flag=0;

        for (int i = 0; i < ListItem.size(); i++) {
            if(ListItem.get(i).getItemName().compareTo(itemName.getText())==0){
                itemArrayList.add(ListItem.get(i));

                isFound.setText("Item Found...");
                isFound.setTextFill(Color.GREEN);

                flag=1;
            }
        }

        if(flag==0){
            isFound.setText("Item Not Found");
            isFound.setTextFill(Color.RED);
        }

        writeIntoItem();
        Item.ListItem.clear();

        ObservableList<Item> productList = FXCollections.observableArrayList(itemArrayList);
        table.setItems(productList);
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    public void Purchase(ActionEvent actionEvent) {
        Item selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            int quantityToPurchase = (int) idSpinner.getValue(); // or (int) nameSpinner.getValue();

            if (selectedItem.getItemQuantity() >= quantityToPurchase) {
                selectedItem.setItemQuantity(selectedItem.getItemQuantity() - quantityToPurchase);
                // Update the table view to reflect the changes
                table.refresh();

                // Show a confirmation message
                new Alert(Alert.AlertType.INFORMATION, "Purchase successful!").showAndWait();
            } else {
                new Alert(Alert.AlertType.WARNING, "Insufficient quantity available.").showAndWait();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "No item selected.").showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ColID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        ColPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        ColQuantity.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
        ColQuantity2.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));



        // Configure spinners
        SpinnerValueFactory.IntegerSpinnerValueFactory idSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        idSpinner.setValueFactory(idSpinnerValueFactory);

        SpinnerValueFactory.IntegerSpinnerValueFactory nameSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        nameSpinner.setValueFactory(nameSpinnerValueFactory);

        // Listen for spinner value changes
        idSpinnerValueFactory.valueProperty().addListener((observable, oldValue, newValue) -> {
            Item selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                selectedItem.setItemQuantity(selectedItem.getItemQuantity() - newValue);
                table.refresh();
            }
        });

        nameSpinnerValueFactory.valueProperty().addListener((observable, oldValue, newValue) -> {
            Item selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                selectedItem.setItemQuantity(selectedItem.getItemQuantity() - newValue);
                table.refresh();
            }
        });

        try {
            table.setItems(dataModel());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private ObservableList<Item> dataModel() throws IOException, ClassNotFoundException {

        ObservableList<Item> productList = FXCollections.observableArrayList(itemArrayList);
        for (Item item : itemArrayList) {
            //   item.setItemQuantity2(item.getItemQuantity());

            productList.add(item);
        }

        return productList;


    }
}
