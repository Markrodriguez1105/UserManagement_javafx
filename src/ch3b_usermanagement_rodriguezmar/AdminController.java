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
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.scene.control.SelectionMode;

/**
 * FXML Controller class
 *
 * @author Hello Mark
 */
public class AdminController implements Initializable {

    Database database = new Database();

    @FXML
    private TableColumn<Information, Integer> residentID;
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
    private TableView<Information> table = new TableView<>();

    //Objects for Batch Update
    static ObservableList<Information> add = FXCollections.observableArrayList();
    static ObservableList<Information> updates = FXCollections.observableArrayList();
    static ObservableList<Information> deletion = FXCollections.observableArrayList();
    static ObservableList<Information> residents;
    
    //Object for encrption on token and status
    Encryption encryp = new Encryption();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.residentID.setCellValueFactory(new PropertyValueFactory<>("residentID"));
        this.username.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.password.setCellValueFactory(new PropertyValueFactory<>("password"));
        this.firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        this.lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.token.setCellValueFactory(new PropertyValueFactory<>("token"));
        this.status.setCellValueFactory(new PropertyValueFactory<>("status"));
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        residents = table.getItems();
        residents.addAll(database.getListInfo());
        table.setItems(residents);

    }

    @FXML
    private void add(ActionEvent event) throws IOException {
        Main main = new Main();
        main.overlayWindow("Add.fxml");
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        Main main = new Main();
        try {
            UpdateController.selected = table.getSelectionModel().getSelectedItem();
            UpdateController.index = table.getSelectionModel().getSelectedIndex();
            main.overlayWindow("Update.fxml");
        } catch (Exception e) {
            System.out.println("null");
        }
        
        
    }

    @FXML
    private void remove(ActionEvent event) {
        deletion.add(table.getSelectionModel().getSelectedItem());
        updates.remove(table.getSelectionModel().getSelectedItem());
        add.remove(table.getSelectionModel().getSelectedItem());
        residents.remove(table.getSelectionModel().getSelectedItem());
        setTable();
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException, SQLException {
        for(Information info : deletion){
            database.executeQuery(String.format("DELETE FROM `user_info` WHERE `residentID` = %s", info.getResidentID()));
        }
        for(Information info : updates){
            ResultSet result = database.getFromDatabase(String.format("SELECT * FROM `user_info` WHERE `residentID` = %s", info.getResidentID()));
            while(result.next()){
                database.executeQuery(String.format("UPDATE `user_info` SET `residentID`= %s,`username`='%s',`password`='%s',`fname`='%s',`mname`='%s',`lname`='%s',`token`=%s,`status`=%s WHERE `residentID` = %s", info.getResidentID(), info.getUsername(), info.getPassword(), info.getLastName(), info.getFirstName(), info.getMiddleName(), encryp.ecryptionToken(info.getToken()), encryp.ecryptionStatus(info.getStatus()), info.getResidentID()));
            }
        }
        for(Information info : add){
            database.insertNewInfo(info.getResidentID(), info.getUsername(), info.getPassword(), info.getLastName(), info.getFirstName(), info.getMiddleName(), encryp.ecryptionToken(info.getToken()), encryp.ecryptionStatus(info.getStatus()));
        }
        Main main = new Main();
        main.changeScene("LogIn.fxml");
    }

    public void setTable() {
        table.setItems(residents);
    }
}
