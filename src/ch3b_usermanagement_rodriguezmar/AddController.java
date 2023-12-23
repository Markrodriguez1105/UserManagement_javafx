package ch3b_usermanagement_rodriguezmar;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    Encryption encryp = new Encryption();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
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
        Information newInfo = new Information(residentIDgenerator(),
                inputUsername.getText(), inputPassword.getText(),
                inputLastname.getText(), inputFirstname.getText(), inputMiddlename.getText(),
                inputToken.getSelectionModel().getSelectedItem(), inputStatus.getSelectionModel().getSelectedItem());
        AdminController.residents.add(newInfo);
        AdminController.add.add(newInfo);
        
        AdminController admin = new AdminController();
        admin.setTable();
        
        Main main = new Main();
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
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    int residentIDgenerator() {
        Database database = new Database();
        Random ran = new Random();
        int random = 0;
        boolean repeat = true;
        try {
            while (repeat) {                
                random = ran.nextInt(9999 - 1 + 1) + 1;
                repeat = database.getFromDatabase(String.format("SELECT `residentID` FROM `user_info` WHERE `residentID` = %s", random)).next();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return random;
    }
}
