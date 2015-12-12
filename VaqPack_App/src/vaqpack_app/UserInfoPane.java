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
    TextField firstNameTF = new TextField("Max");
    TextField lastNameTF = new TextField("Imus");
    TextField phonNumTF = new TextField("555-555-5555");
    TextField emailTF = new TextField("test@edu.com");
    Label firstName = new Label("First Name: ");
    Label lastName = new Label("Last Name: ");
    Label phonNum = new Label("Phone Number: ");
    Label email = new Label("E-mail address: ");
    
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
        
        
        //Register Pane settings and setup
//        rpRegisterButton.disableProperty().bind(regConfTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(firstNameTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(lastNameTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(phonNumTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(emailTF.textProperty().isEmpty());


        
        modUserInfoBtn.setOnAction((ActionEvent event) -> {
            per.setFname(firstNameTF.getText());
            per.setLname(lastNameTF.getText());
            per.setPhone(phonNumTF.getText());
            per.setEmail(emailTF.getText());

        });
        
        
        
        StackPane pane = new StackPane();
        pane.getChildren().addAll(userInfoPane);
        main = pane;
        

    }
    
    public Pane getMain(){
        return this.main;
    }

    /**
     * @return the per
     */
    public Personal getPer() {
        return per;
    }
    
}
