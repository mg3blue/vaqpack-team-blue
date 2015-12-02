/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbloginprototype;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jonathan
 */
public class DBLoginPrototype extends Application {
    static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/test";
    @Override
    public void start(Stage primaryStage) {
        
        Button loginBtn = new Button("Login");
        Button registerBtn = new Button("Register");
        TextField logTF = new TextField();
        TextField pwTF = new TextField();
        Label logL = new Label("Username: ");
        Label pwL = new Label("Password: ");
        Label newUser = new Label("New User?");
        Label suc = new Label("");
        
        
        GridPane loginPane = new GridPane();        
        loginPane.addRow(0, logL, logTF);
        loginPane.addRow(1, pwL, pwTF);
        loginPane.addRow(2, loginBtn);
        loginPane.addRow(4, newUser, registerBtn);
        loginPane.setAlignment(Pos.CENTER);
        suc.setVisible(false);
        suc.setAlignment(Pos.CENTER);
        
        // Stays disabled as long as lgin TextField and pass TextField are empty
        loginBtn.disableProperty().bind(logTF.textProperty().isEmpty());
        loginBtn.disableProperty().bind(pwTF.textProperty().isEmpty());
        loginBtn.setOnAction((ActionEvent event) -> {
            Connection connect = null;
            Statement state = null;
            ResultSet result = null;
            ArrayList<String> what = new ArrayList<>();
            try
            {
                connect = DriverManager.getConnection(DATABASE_URL, "local", "Plethora98!");
                state = connect.createStatement();
                result = state.executeQuery("SELECT username, pass FROM test.User WHERE username = '" + logTF.getText() + "';");
                ResultSetMetaData meta = result.getMetaData();
                int numberOfColumns = meta.getColumnCount();
                System.out.println(numberOfColumns);
                while (result.next())
                {
                    for (int i = 1; i <= numberOfColumns; i++)
                    {
                        what.add(result.getObject(i) + "");
                    }
                }
                if (what.isEmpty() == false)
                {
                    if (pwTF.getText().equals(what.get(1)))
                    {
                        loginPane.setVisible(false);
                        suc.setVisible(true);
                        suc.setText("You have successfully logged in!");
                    }
                    else
                    {
                        logTF.clear();
                        pwTF.clear();
                        suc.setVisible(true);
                        suc.setText("Login failed. Please try again.");
                    }
                }
                else
                {
                    logTF.clear();
                    pwTF.clear();
                    suc.setVisible(true);
                    suc.setText("Login failed. Please try again.");
                }
            }
            catch (SQLException sqlexception)
            {
                sqlexception.printStackTrace();
                System.out.println("ERROR ERROR ERROR");
            }
            finally
            {
                try
                {
                    result.close();
                    state.close();
                    connect.close();
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    System.out.println("ERROR ERROR ERROR");
                }
            }
        });
        
        Label regUser = new Label("Username: ");
        Label regPass = new Label("Password: ");
        Label regConf = new Label("Confirm New Password: ");
        Label firstName = new Label("First Name: ");
        Label lastName = new Label("Last Name: ");
        Label phonNum = new Label("Phone Number: ");
        Label email = new Label("E-mail address: ");
        TextField regUserTF = new TextField();
        TextField regPassTF = new TextField();
        TextField regConfTF = new TextField();
        TextField firstNameTF = new TextField();
        TextField lastNameTF = new TextField();
        TextField phonNumTF = new TextField();
        TextField emailTF = new TextField();
        GridPane registerPane = new GridPane();
        Button done = new Button("Register");
        Button back = new Button("Return");
        done.disableProperty().bind(regUserTF.textProperty().isEmpty());
        done.disableProperty().bind(regPassTF.textProperty().isEmpty());
        done.disableProperty().bind(regConfTF.textProperty().isEmpty());
        done.disableProperty().bind(firstNameTF.textProperty().isEmpty());
        done.disableProperty().bind(lastNameTF.textProperty().isEmpty());
        done.disableProperty().bind(phonNumTF.textProperty().isEmpty());
        done.disableProperty().bind(emailTF.textProperty().isEmpty());
        
        done.setOnAction((ActionEvent event) -> {
            loginPane.setVisible(true);
            registerPane.setVisible(false);
            suc.setText("Please login now.");
        });
        registerPane.addRow(0, regUser, regUserTF);
        registerPane.addRow(1, regPass, regPassTF);
        registerPane.addRow(2, regConf, regConfTF);
        registerPane.addRow(3, firstName, firstNameTF);
        registerPane.addRow(4, lastName, lastNameTF);
        registerPane.addRow(5, phonNum, phonNumTF);
        registerPane.addRow(6, email, emailTF);
        registerPane.addRow(7, done);
        registerPane.addRow(8, back);
        
        registerPane.setVisible(false);
        registerPane.setAlignment(Pos.CENTER);
        registerBtn.setOnAction((ActionEvent event) -> {
            loginPane.setVisible(false);
            registerPane.setVisible(true);
            suc.setText("Please fill the text fields.");
        });
        
        back.setOnAction((ActionEvent event) -> {
            loginPane.setVisible(true);
            registerPane.setVisible(false);
        });
        
        
        StackPane swtch = new StackPane();
        swtch.getChildren().addAll(loginPane, registerPane);
        BorderPane root = new BorderPane();
        root.setCenter(swtch);
        root.setBottom(suc);
        Scene scene = new Scene(root, 500, 450);
        
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
