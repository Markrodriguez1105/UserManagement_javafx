/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ch3b_usermanagement_rodriguezmar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hello Mark
 */
public class UpdateController implements Initializable {

    static int index;
    
    private int residentID;
    
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
    
    AdminController admin = new AdminController();
    static Information selected;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inputToken.setItems(FXCollections.observableArrayList("RESIDENT", "ADMIN"));
        inputStatus.setItems(FXCollections.observableArrayList("ACTIVE", "INACTIVE"));
            residentID = selected.getResidentID();
            inputFirstname.setText(selected.getFirstName());
            inputMiddlename.setText(selected.getMiddleName());
            inputLastname.setText(selected.getLastName());
            inputUsername.setText(selected.getUsername());
            inputPassword.setText(selected.getPassword());
            inputToken.setValue(selected.getToken());
            inputStatus.setValue(selected.getStatus());
    }


    @FXML
    private void cancel(ActionEvent event) {
        Main main = new Main();
        main.closeWindow(event);
    }

    @FXML
    private void update(ActionEvent event) {
        selected = new Information(residentID, inputUsername.getText(), inputPassword.getText(), 
                inputLastname.getText(), inputFirstname.getText(), inputMiddlename.getText(), 
                inputToken.getSelectionModel().getSelectedItem(), inputStatus.getSelectionModel().getSelectedItem());
        AdminController.updates.add(selected);
        
        AdminController.residents.set(index, selected);
        admin.setTable();
        
        Main main = new Main();
        main.closeWindow(event);
    }
}
