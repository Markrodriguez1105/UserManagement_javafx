package ch3b_usermanagement_rodriguezmar;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private PasswordField inputToken;
    @FXML
    private PasswordField inputStatus;
    
    private int counting = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) {
        counting++;
        Information info = new Information(counting, residentIDgenerator(), 
                inputUsername.getText(), inputPassword.getText(), 
                inputLastname.getText(), inputFirstname.getText(), inputMiddlename.getText(), 
                inputToken.getText(), inputStatus.getText());
        
        AdminController admin = new AdminController();
        ObservableList<Information> informations = admin.table.getItems();
        informations.add(info);
        admin.table.setItems(informations);
    }

    @FXML
    private void reset(ActionEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    String residentIDgenerator(){
        Random ran = new Random();
        return String.valueOf(ran.nextInt(9999 - 1 + 1) + 1);
    }
    
}
