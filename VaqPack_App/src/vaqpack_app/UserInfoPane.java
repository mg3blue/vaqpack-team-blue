/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author mg3Blue
 */
public class UserInfoPane {
    static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/test";
    
    //Register Pane nodes
    GridPane userInfoPane = new GridPane();
    Button modUserInfoBtn = new Button("Change");
    TextField firstNameTF = new TextField("Max");
    TextField lastNameTF = new TextField("Imus");
    TextField phonNumTF = new TextField("555-555-5555");
    TextField emailTF = new TextField("test@edu.com");
    Label firstName = new Label("First Name: ");
    Label lastName = new Label("Last Name: ");
    Label phonNum = new Label("Phone Number: ");
    Label email = new Label("E-mail address: ");
    
    private String username = "";
    
    private Personal per = new Personal();

    //Pane to return;
    Pane main = new Pane();
    
    UserInfoPane() {
        
        userInfoPane.addRow(0, firstName, firstNameTF);
        userInfoPane.addRow(1, lastName, lastNameTF);
        userInfoPane.addRow(2, phonNum, phonNumTF);
        userInfoPane.addRow(3, email, emailTF);
        userInfoPane.addRow(4, modUserInfoBtn);
        userInfoPane.setAlignment(Pos.CENTER);
        

        
        
        modUserInfoBtn.disableProperty().bind(firstNameTF.textProperty().isEmpty());
        modUserInfoBtn.disableProperty().bind(lastNameTF.textProperty().isEmpty());
        modUserInfoBtn.disableProperty().bind(phonNumTF.textProperty().isEmpty());
        modUserInfoBtn.disableProperty().bind(emailTF.textProperty().isEmpty());


        
        modUserInfoBtn.setOnAction((ActionEvent event) -> {
            per.setFname(firstNameTF.getText());
            per.setLname(lastNameTF.getText());
            per.setPhone(phonNumTF.getText());
            per.setEmail(emailTF.getText());      
            Connection connect = null;
            Statement state = null;
            try {
                connect = DriverManager.getConnection(DATABASE_URL, "root", "2198");
                state = connect.createStatement();
                state.executeUpdate("UPDATE test.user SET firstName = '" + firstNameTF.getText() + "', lastName = '" + lastNameTF.getText() + 
                        "', phonNum = " + phonNumTF.getText() + ", email = '" + emailTF.getText() + "' WHERE username = '"+ getUsername() +"'");              
            } catch (SQLException sqlexception) {
                System.out.println("ERROR ERROR ERROR");
            } 
        });
        
        
        StackPane pane = new StackPane();
        pane.getChildren().addAll(userInfoPane);
        main = pane;
        

    }
    
    public Pane getMain() {  
        return this.main;
    }
    
    public void initialize(){
        ArrayList<String> what = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "2198");
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM test.user WHERE username = '"+ getUsername() +"'");
            ResultSetMetaData meta = result.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    what.add(result.getObject(i) + "");
                }
            }
        } catch (SQLException sqlexcept) {
            System.out.println("ERROR ERROR ERROR");
        } finally {
            try {
                result.close();
                statement.close();
                connection.close();
            } catch (Exception exception) {
                System.out.println("ERROR ERROR ERROR");
            }
        }
        if (!what.isEmpty()) {
            firstNameTF.setText(what.get(2));
            lastNameTF.setText(what.get(3));
            phonNumTF.setText(what.get(4));
            emailTF.setText(what.get(5));
        }
        
        per.setFname(firstNameTF.getText());
        per.setLname(lastNameTF.getText());
        per.setPhone(phonNumTF.getText());
        per.setEmail(emailTF.getText());  
    }

    /**
     * @return the per
     */
    public Personal getPer() {
        return per;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
}
