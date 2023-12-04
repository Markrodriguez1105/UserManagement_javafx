package ch3b_usermanagement_rodriguezmar;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    private static Stage stg;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("LogIn");
        stage.setScene(scene);
        stage.show();
    }
    
    public void changeScene(String fxml) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root);
        stg.setTitle(fxml.substring(0, fxml.length()-5));
    }
    
    public void overlayWindow(String fxml) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(fxml.substring(0, fxml.length()-5));
        stage.setScene(scene);
        stage.show();
    }
    
    public void closeWindow(String fxml) throws IOException{
//        Parent root = FXMLLoader.load(getClass().getResource(fxml));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.close();
    }
}
