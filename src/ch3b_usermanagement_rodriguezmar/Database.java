package ch3b_usermanagement_rodriguezmar;

import java.sql.*;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Database {
    
    Encryption encryp = new Encryption();
    
    public Connection connectDb() {
        Connection connect;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ch3b_usermanagement_rodriguezmar", "root", "");
            return connect;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ObservableList<Information> getListInfo(){
        Connection connect = connectDb();
        ObservableList<Information> list = FXCollections.observableArrayList();
        
        Statement prep;
        ResultSet result;
        try {
            prep = connect.createStatement();
            result = prep.executeQuery("SELECT * FROM user_info");
            while (result.next()) {
                Information info = new Information(result.getInt("residentID"), result.getString("username"), result.getString("password"), result.getString("lname"), result.getString("fname"), result.getString("mname"), encryp.DecryptionToken(result.getByte("token")), encryp.DecryptionStatus(result.getBoolean("status")));
                list.add(info);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        FXCollections.sort(list, Comparator.comparing(Information::getLastName));
        return list;
    }
    
    public void insertNewInfo(int residentID, String username, String password, String lastName, String firstName, String middleName, byte token, boolean status){
        String query = String.format("INSERT INTO user_info VALUES (%s,'%s','%s','%s','%s','%s',%s,%s)",residentID, username, password, firstName, middleName, lastName, token, status);
        executeQuery(query);
    }
    
    public void updateInfo(int residentID, String username, String password, String lastName, String firstName, String middleName, byte token, boolean status){
        executeQuery(String.format("UPDATE `user_info` SET `residentID`= %s,`username`='%s',`password`='%s',`fname`='%s',`mname`='%s',`lname`='%s',`token`='%s',`status`='%s' WHERE `residentID = %s", residentID, username, password, firstName, middleName, lastName, token, status, residentID));
    }
    
    void executeQuery(String query){
        Connection connect = connectDb();
        Statement prep;
        
        try {
            prep = connect.createStatement();
            prep.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ResultSet getFromDatabase(String query){
        Connection connect = connectDb();
        PreparedStatement prep;
        ResultSet result = null;
        
        try {
            prep = connect.prepareStatement(query);
            result = prep.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
