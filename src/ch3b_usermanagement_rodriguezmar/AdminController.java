/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ch3b_usermanagement_rodriguezmar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Hello Mark
 */
public class AdminController implements Initializable {
    
    @FXML
    private TableColumn<Information, Integer> count;
    @FXML
    private TableColumn<Information, String> residentID;
    @FXML
    private TableColumn<Information, String> username;
    @FXML
    private TableColumn<Information, String> password;
    @FXML
    private TableColumn<Information, String> lastName;
    @FXML
    private TableColumn<Information, String> firstName;
    @FXML
    private TableColumn<Information, String> middleName;
    @FXML
    private TableColumn<Information, String> token;
    @FXML
    private TableColumn<Information, String> status;
    @FXML
    public TableView<Information> table;

    /**
     * Initializes the controller class.
     */
    private int counting = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        count.setCellValueFactory(new PropertyValueFactory<>("count"));
        residentID.setCellValueFactory(new PropertyValueFactory<>("residentID"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        token.setCellValueFactory(new PropertyValueFactory<>("token"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
    }    

    @FXML
    private void add(ActionEvent event) throws IOException {
        Main main = new Main();
        main.overlayWindow("Add.fxml");
//        counting++;
//        Information info = new Information(counting, "1234", "Markmark", "1234", "Rodriguez", "Mark Anthony", "Amican", "Resident", "Active");
//        ObservableList<Information> informations = table.getItems();
//        informations.add(info);
//        table.setItems(informations);
    }

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void remove(ActionEvent event) {
    }

    @FXML
    private void logOut(ActionEvent event) {
    }
    
}
