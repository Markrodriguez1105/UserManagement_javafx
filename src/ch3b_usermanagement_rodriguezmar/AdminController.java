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

/**
 * FXML Controller class
 *
 * @author Hello Mark
 */
public class AdminController implements Initializable {

    Database database = new Database();

    @FXML
    private TableColumn<Information, Integer> count;
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

    static ObservableList<Information> informations;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.count.setCellValueFactory(new PropertyValueFactory<>("count"));
        this.residentID.setCellValueFactory(new PropertyValueFactory<>("residentID"));
        this.username.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.password.setCellValueFactory(new PropertyValueFactory<>("password"));
        this.firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        this.lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.token.setCellValueFactory(new PropertyValueFactory<>("token"));
        this.status.setCellValueFactory(new PropertyValueFactory<>("status"));

        informations = table.getItems();
        informations.addAll(database.getListInfo());
        table.setItems(informations);

    }

    @FXML
    private void add(ActionEvent event) throws IOException {
        Main main = new Main();
        main.overlayWindow("Add.fxml");
    }

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void remove(ActionEvent event) {
        table.selectionModelProperty();
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("LogIn.fxml");
    }

    public void setTable() {

        informations.clear();
        informations.addAll(database.getListInfo());
        table.setItems(informations);
    }

}
