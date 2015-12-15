/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mg3Blue
 */
public class VaqPack_App extends Application {
    
    
    //Database pane stuff
    static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/test";
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
    Label valid1 = new Label("");
    Label valid2 = new Label("");

    
    //Pane to return;
    Pane loginpane = new Pane();
    
    
    Scene scene;
    Button userInfoBtn = new Button("Personal");
    Button resumeBtn = new Button("Resume");
    Button coverBtn = new Button("Cover Letter");
    Button generateBtn = new Button("Generate Docs");
    Button emailBtn = new Button("E-mail");
    BorderPane main = new BorderPane();
    ResumePane resumepane = new ResumePane();
    CoverLetterPane coverpane = new CoverLetterPane();
    UserInfoPane userpane = new UserInfoPane();
    MakeDocsPane makepane = new MakeDocsPane();
    MailPane mailpane;
    VBox btnBox = new VBox(5);
    
    @Override
    public void start(Stage primaryStage) {
        mailpane = new MailPane(primaryStage);
        userInfoBtn.setMaxWidth(Double.MAX_VALUE);
        resumeBtn.setMaxWidth(Double.MAX_VALUE);
        coverBtn.setMaxWidth(Double.MAX_VALUE);
        generateBtn.setMaxWidth(Double.MAX_VALUE);
        emailBtn.setMaxWidth(Double.MAX_VALUE);
        btnBox.getChildren().addAll(userInfoBtn, resumeBtn, coverBtn, generateBtn, emailBtn);
        btnBox.setPadding(new Insets(10, 50, 0, 10));
        
        
        
        
        
       
        //Login Pane settings and setup
        loginPane.setVisible(true);
        loginPane.addRow(0, logL, logTF);
        loginPane.addRow(1, pwL, pwTF);
        loginPane.addRow(2, loginBtn);
        loginPane.addRow(4, newUser, registerBtn);
        loginPane.addRow(5, valid1);
        loginPane.setAlignment(Pos.CENTER);

        // Stays disabled as long as lgin TextField and pass TextField are empty
        loginBtn.disableProperty().bind(logTF.textProperty().isEmpty());
        loginBtn.disableProperty().bind(pwTF.textProperty().isEmpty());
        loginBtn.setOnAction((ActionEvent event) -> {
            Connection connect = null;
            Statement state = null;
            ResultSet result = null;
            ArrayList<String> what = new ArrayList<>();
            try {
                connect = DriverManager.getConnection(DATABASE_URL, "root", "2198");
                state = connect.createStatement();
                result = state.executeQuery("SELECT username, pass FROM test.User WHERE username = '" + logTF.getText() + "';");
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
                        userpane.setUsername(what.get(0));
                        userpane.initialize();
                        primaryStage.setScene(scene);
                    } else {
                        valid1.setText("Invalid Login");
                        logTF.clear();
                        pwTF.clear();
                    }
                } else {
                    valid1.setText("Invalid Login");
                    logTF.clear();
                    pwTF.clear();
                }
            } catch (SQLException sqlexception) {
                System.out.println("ERROR ERROR ERROR");
            } finally {
                try {
                    result.close();
                    state.close();
                    connect.close();
                } catch (Exception exception) {
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
            ResultSet result = null;
            if (regPassTF.getText().equals(regConfTF.getText())) {
                ArrayList<String> what = new ArrayList<>();
                try {
                    connect = DriverManager.getConnection(DATABASE_URL, "root", "2198");
                    state = connect.createStatement();
                    state.executeUpdate("INSERT INTO test.user "
                            + "VALUES ('" + regUserTF.getText() + "', '" + regPassTF.getText()
                            + "', '" + firstNameTF.getText() + "', '" + lastNameTF.getText()
                            + "', " + phonNumTF.getText() + ", '" + emailTF.getText() + "');");
                } catch (SQLException sqlexception) {
                    System.out.println("ERROR ERROR ERROR");
                } finally {
                    try {
                        state.close();
                        connect.close();
                    } catch (Exception exception) {
                        System.out.println("ERROR ERROR ERROR");
                    }
                }
                loginPane.setVisible(true);
                registerPane.setVisible(false);
            }
            else{
                valid2.setText("Passwords didn't match");
            }
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
        registerPane.addRow(9, valid2);

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
        loginpane = swtch;
        
        
        
        
        
        
        
        resumeBtn.setOnAction((ActionEvent event) -> {
            main.setCenter(resumepane.getMain());
        });
        userInfoBtn.setOnAction((ActionEvent event) -> {
            
            main.setCenter(userpane.getMain());
        });
        coverBtn.setOnAction((ActionEvent event) -> {
            main.setCenter(coverpane.getMain());
        });
        
        generateBtn.setOnAction((ActionEvent event) -> {
            makepane.setData(userpane.getPer(), resumepane.getExpList(), resumepane.getEduList(), resumepane.getSkillList(), coverpane.getEmpList());
            main.setCenter(makepane.getMain());
            
            
        });
        emailBtn.setOnAction((ActionEvent event) -> {
            mailpane.setEmp(coverpane.getEmpList());
            main.setCenter(mailpane.getMain());
            
            
        });
        
        
        main.setLeft(btnBox);
        
        main.setCenter(userpane.getMain());
        
        Scene sceneStart = new Scene(loginpane, 600, 400);
        scene = new Scene(main, 600, 400);
        primaryStage.setTitle("VaqPack");
        primaryStage.getIcons().add(new Image("file:vq.png"));
        primaryStage.setScene(sceneStart);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
public class LoginPane {
    




    LoginPane() {
 
    }
    
}
    
    
}
