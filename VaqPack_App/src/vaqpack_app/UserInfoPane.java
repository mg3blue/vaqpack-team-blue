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
    //static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/test";
    
    //Register Pane nodes
    GridPane userInfoPane = new GridPane();
    Button modUserInfoBtn = new Button("Change");
    TextField firstNameTF = new TextField();
    TextField lastNameTF = new TextField();
    TextField phonNumTF = new TextField();
    TextField emailTF = new TextField();
    Label firstName = new Label("First Name: ");
    Label lastName = new Label("Last Name: ");
    Label phonNum = new Label("Phone Number: ");
    Label email = new Label("E-mail address: ");

    //Pane to return;
    Pane main = new Pane();
    
    UserInfoPane() {
        
        userInfoPane.addRow(0, firstName, firstNameTF);
        userInfoPane.addRow(1, lastName, lastNameTF);
        userInfoPane.addRow(2, phonNum, phonNumTF);
        userInfoPane.addRow(3, email, emailTF);
        userInfoPane.addRow(4, modUserInfoBtn);
        userInfoPane.setAlignment(Pos.CENTER);
        
        
        //Register Pane settings and setup
//        rpRegisterButton.disableProperty().bind(regConfTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(firstNameTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(lastNameTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(phonNumTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(emailTF.textProperty().isEmpty());


        StackPane pane = new StackPane();
        pane.getChildren().addAll(userInfoPane);
        main = pane;
        

    }
    
    public Pane getMain(){
        return this.main;
    }
    
}
