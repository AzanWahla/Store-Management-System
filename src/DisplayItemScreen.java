//FA22

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Store.*;

public class DisplayItemScreen implements Initializable {
    public Label title;
    public Button back;
    public Button close;
    public ArrayList<Item> itemArrayList =new ArrayList<Item>();
    public TableView<Item> table = new TableView<Item>();
    public TableColumn<Item, Integer> ColID = new TableColumn<Item, Integer>();
    public TableColumn<Item, String> ColName=new TableColumn<Item, String>();
    public TableColumn<Item, Double> ColPrice=new TableColumn<Item,Double>();
    public TableColumn<Item, Integer> ColQuantity=new TableColumn<Item,Integer>();

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("ItemScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a) {
            System.out.println(a.getMessage());
        }
    }

    public void closeScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ColID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
            ColName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            ColPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
            ColQuantity.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));

            // Set the ObservableList as the data source for the TableView
            table.setItems(dataModel());
        } catch (IOException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).showAndWait();
        }

    }


    private ObservableList<Item> dataModel() throws IOException, ClassNotFoundException {

        itemArrayList=(ArrayList<Item>) Item.display();
        ObservableList<Item> productList = FXCollections.observableArrayList(itemArrayList);
        table.setItems(productList);
        Item.ListItem.clear();
        return productList;


}
}