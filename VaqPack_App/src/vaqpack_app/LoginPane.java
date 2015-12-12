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
import javafx.geometry.Insets;
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
public class LoginPane {
    static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/test";
    static final ArrayList<String> what = new ArrayList<>();
    //Login Pane nodes
    GridPane loginPane = new GridPane();
    Button loginBtn = new Button("Login");
    Button registerBtn = new Button("Register");
    TextField logTF = new TextField();
    TextField pwTF = new TextField();
    Label logL = new Label("Username: ");
    Label pwL = new Label("Password: ");
    Label newUser = new Label("New User?");
    
    //Register Pane nodes
    GridPane registerPane = new GridPane();
    Button rpRegisterButton = new Button("Register");
    Button backBtn = new Button("Return");
    TextField regUserTF = new TextField();
    TextField regPassTF = new TextField();
    TextField regConfTF = new TextField();
    TextField firstNameTF = new TextField();
    TextField lastNameTF = new TextField();
    TextField phonNumTF = new TextField();
    TextField emailTF = new TextField();
    Label regUser = new Label("Username: ");
    Label regPass = new Label("Password: ");
    Label regConf = new Label("Confirm New Password: ");
    Label firstName = new Label("First Name: ");
    Label lastName = new Label("Last Name: ");
    Label phonNum = new Label("Phone Number: ");
    Label email = new Label("E-mail address: ");

    //Pane to return;
    Pane main = new Pane();
    
    
    
    LoginPane() {

        
        //Login Pane settings and setup
        loginPane.setVisible(true);
        loginPane.addRow(0, logL, logTF);
        loginPane.addRow(1, pwL, pwTF);
        loginPane.addRow(2, loginBtn);
        loginPane.addRow(4, newUser, registerBtn);
        loginPane.setAlignment(Pos.CENTER);

        // Stays disabled as long as lgin TextField and pass TextField are empty
        loginBtn.disableProperty().bind(logTF.textProperty().isEmpty());
        loginBtn.disableProperty().bind(pwTF.textProperty().isEmpty());
        loginBtn.setOnAction((ActionEvent event) -> {
            Connection connect = null;
            Statement state = null;
            ResultSet result = null;           
            try {
                connect = DriverManager.getConnection(DATABASE_URL, "local", "Plethora98!");
                state = connect.createStatement();
                result = state.executeQuery("SELECT * FROM test.User WHERE username = '" + logTF.getText() + "';");
                ResultSetMetaData meta = result.getMetaData();
                int numberOfColumns = meta.getColumnCount();
                while (result.next()) {
                    for (int i = 1; i <= numberOfColumns; i++) {
                        what.add(result.getObject(i) + "");
                    }
                }
                if (what.isEmpty() == false) {
                    if (pwTF.getText().equals(what.get(1))) {
                        loginPane.setVisible(false);
                    } else {
                        logTF.clear();
                        pwTF.clear();
                    }
                } else {
                    logTF.clear();
                    pwTF.clear();
                }
            } catch (SQLException sqlexception) {
                sqlexception.printStackTrace();
                System.out.println("ERROR ERROR ERROR");
            } finally {
                try {
                    result.close();
                    state.close();
                    connect.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    System.out.println("ERROR ERROR ERROR");
                }
            }
        });
        //Register Pane settings and setup
        rpRegisterButton.disableProperty().bind(regUserTF.textProperty().isEmpty());
        rpRegisterButton.disableProperty().bind(regPassTF.textProperty().isEmpty());
        rpRegisterButton.disableProperty().bind(regConfTF.textProperty().isEmpty());
        rpRegisterButton.disableProperty().bind(firstNameTF.textProperty().isEmpty());
        rpRegisterButton.disableProperty().bind(lastNameTF.textProperty().isEmpty());
        rpRegisterButton.disableProperty().bind(phonNumTF.textProperty().isEmpty());
        rpRegisterButton.disableProperty().bind(emailTF.textProperty().isEmpty());

        rpRegisterButton.setOnAction((ActionEvent event) -> {
            Connection connect = null;
            Statement state = null;
            try {
                connect = DriverManager.getConnection(DATABASE_URL, "local", "Plethora98!");
                state = connect.createStatement();
                state.executeUpdate("INSERT INTO test.user " +
                        "VALUES ('" + regUserTF.getText() + "', '" + regPassTF.getText() + 
                        "', '" + firstNameTF.getText() + "', '" + lastNameTF.getText() + 
                        "', " + phonNumTF.getText() + ", '" + emailTF.getText() + "');");              
            } catch (SQLException sqlexception) {
                sqlexception.printStackTrace();
                System.out.println("ERROR ERROR ERROR");
            } finally {
                try {
                    state.close();
                    connect.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    System.out.println("ERROR ERROR ERROR");
                }
            }
            loginPane.setVisible(true);
            registerPane.setVisible(false);
        });
        registerPane.addRow(0, regUser, regUserTF);
        registerPane.addRow(1, regPass, regPassTF);
        registerPane.addRow(2, regConf, regConfTF);
        registerPane.addRow(3, firstName, firstNameTF);
        registerPane.addRow(4, lastName, lastNameTF);
        registerPane.addRow(5, phonNum, phonNumTF);
        registerPane.addRow(6, email, emailTF);
        registerPane.addRow(7, rpRegisterButton);
        registerPane.addRow(8, backBtn);

        registerPane.setVisible(false);
        registerPane.setAlignment(Pos.CENTER);
        registerBtn.setOnAction((ActionEvent event) -> {
            loginPane.setVisible(false);
            registerPane.setVisible(true);
            //suc.setText("Please fill the text fields.");
        });

        backBtn.setOnAction((ActionEvent event) -> {
            loginPane.setVisible(true);
            registerPane.setVisible(false);
        });
        
        
        StackPane swtch = new StackPane();
        swtch.getChildren().addAll(loginPane, registerPane);
        main = swtch;
        

    }
    
    public Pane getMain(){
        return this.main;
    }
    
}
