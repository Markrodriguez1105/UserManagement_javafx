package ch3b_usermanagement_rodriguezmar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 *
 * @author Hello Mark
 */
public class LogInController implements Initializable {
    
    private Label label;
    @FXML
    private ComboBox<String> dropBox;
    @FXML
    private Label indicator;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    
    String sampleUsername = "09637752208" , samplePassword = "12345";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dropBox.setValue("RESIDENT");
        dropBox.setItems(FXCollections.observableArrayList("RESIDENT", "ADMIN"));
    }    

    @FXML
    private void userLogIn(ActionEvent event) throws IOException {
//        if(dropBox.getSelectionModel().getSelectedItem().equals("RESIDENT") && userName.getText().equals(sampleUsername) && password.getText().equals(samplePassword)){
//            Main main = new Main();
//            main.overlayWindow("Admin.fxml");
//        }else if(dropBox.getSelectionModel().getSelectedItem().equals("ADMIN") && userName.getText().equals(sampleUsername) && password.getText().equals(samplePassword)){
//            Main main = new Main();
//            main.changeScene("Admin.fxml");
//        } else if(userName.getText().isEmpty() || password.getText().isEmpty()){
//            indicator.setText("Please Enter your Username and Password");
//            indicator.setTextFill(Color.RED);
//        }else{
//            indicator.setText("Wrong Username and Password");
//            indicator.setTextFill(Color.RED);
//        }
            Main main = new Main();
            main.changeScene("Admin.fxml");
    }
}
