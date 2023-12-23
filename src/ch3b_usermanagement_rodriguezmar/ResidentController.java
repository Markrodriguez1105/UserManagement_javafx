/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ch3b_usermanagement_rodriguezmar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author Hello Mark
 */
public class ResidentController implements Initializable {

    static int residentID;

    @FXML
    private TextField firstName;
    @FXML
    private TextField middleName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Database database = new Database();
        ResultSet result = database.getFromDatabase(String.format("SELECT * FROM `user_info` WHERE `residentID` = %s", residentID));
        try {
            if (result.next()) {
                firstName.setText(result.getString("fname"));
                middleName.setText(result.getString("mname"));
                lastName.setText(result.getString("lname"));
                username.setText(result.getString("username"));
                password.setText(result.getString("password"));
            }else{
                firstName.setText("No Infomation has been set!");
                middleName.setText("No Infomation has been set!");
                lastName.setText("No Infomation has been set!");
                username.setText("No Infomation has been set!");
                password.setText("No Infomation has been set!");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("LogIn.fxml");
    }

}
