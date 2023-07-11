//FA22

import Store.Item;
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

public class DeleteItemScreen {
    public Label title;
    public TextField itemID;
    public Button search;
    public Button back;
    public Button close;
    public Label found;
    public Label notFound;
    public Label isFound;
    public Label itemDetail;

    public void searchButton(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        int id,flag=0;
        if (itemID.getText().matches("[0-9]*"))
        {
            id = Integer.parseInt(itemID.getText());
            flag=Item.remove(id);
        }else
            new Alert(Alert.AlertType.ERROR,"Wrong Type Entered ...").show();

        if (flag==1){
            isFound.setText("Item Found & Deleted");
            isFound.setTextFill(Color.GREEN);
        }
        if (flag==0){
            isFound.setText("Item Not Found");
            isFound.setTextFill(Color.RED);
        }


        /*int flag=0;
        if(itemID.getText().matches("[0-9]*")){
            int id= Integer.parseInt(itemID.getText());
            flag=1;
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Wrong Type Entered ...").showAndWait();
            flag=0;
        }
        int id= Integer.parseInt(itemID.getText());
        if(flag==1){
               if(Item.remove(id)==0){
            isFound.setText("Item Not Found");
            isFound.setTextFill(Color.RED);
             }
        else{
            isFound.setText("Item Found & Deleted");
            isFound.setTextFill(Color.GREEN);
          }
        }*/

    }

    public void closeScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    public void backScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("ItemScreen.fxml"));
            stage.setTitle("Store Management System");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }

    }
}
