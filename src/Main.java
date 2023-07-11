//FA22

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Store.*;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fx=new FXMLLoader(Main.class.getResource("Screen.fxml"));

        stage.setTitle("Store Management System");
        stage.setScene(new Scene(fx.load()));
        stage.show();


    }
}