package ch3b_usermanagement_rodriguezmar;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hello Mark
 */
public class AddController implements Initializable {

    @FXML
    private TextField inputFirstname;
    @FXML
    private TextField inputMiddlename;
    @FXML
    private TextField inputLastname;
    @FXML
    private TextField inputUsername;
    @FXML
    private PasswordField inputPassword;
    
    @FXML
    private ComboBox<String> inputToken;
    @FXML
    private ComboBox<String> inputStatus;
    
    Database database = new Database();
    AdminController admin = new AdminController();
    Main main = new Main();
    Encryption encryp = new Encryption();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inputToken.setValue("RESIDENT");
        inputToken.setItems(FXCollections.observableArrayList("RESIDENT", "ADMIN"));
        inputStatus.setValue("ACTIVE");
        inputStatus.setItems(FXCollections.observableArrayList("ACTIVE", "INACTIVE"));
    }    

    @FXML
    private void add(ActionEvent event) {
        
        database.insertNewInfo(residentIDgenerator(), 
                inputUsername.getText(), inputPassword.getText(), 
                inputLastname.getText(), inputFirstname.getText(), inputMiddlename.getText(), 
                encryp.ecryptionToken(inputToken.getSelectionModel().getSelectedItem()), encryp.ecryptionStatus(inputStatus.getSelectionModel().getSelectedItem()));
        admin.setTable();
        main.closeWindow(event);
    }

    @FXML
    private void reset(ActionEvent event) {
        inputFirstname.setText("");
        inputMiddlename.setText("");
        inputLastname.setText("");
        inputUsername.setText("");
        inputPassword.setText("");
        inputToken.setValue("RESIDENT");
        inputStatus.setValue("ACTIVE");
    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    int residentIDgenerator(){
        Random ran = new Random();
        return ran.nextInt(9999 - 1 + 1) + 1;
    }
}
