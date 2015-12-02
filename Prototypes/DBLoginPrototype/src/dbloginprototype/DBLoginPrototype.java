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
        Button btn = new Button("Login");
        Button regis = new Button("Register");
        TextField lgin = new TextField();
        TextField pass = new TextField();
        Label log = new Label("Username: ");
        Label pss = new Label("Password: ");
        Label newUser = new Label("New User?");
        Label suc = new Label("");
        GridPane lg = new GridPane();        
        lg.addRow(0, log, lgin);
        lg.addRow(1, pss, pass);
        lg.addRow(2, btn);
        lg.addRow(4, newUser, regis);
        lg.setAlignment(Pos.CENTER);
        suc.setVisible(false);
        suc.setAlignment(Pos.CENTER);
        // Stays disabled as long as lgin TextField and pass TextField are empty
        btn.disableProperty().bind(lgin.textProperty().isEmpty());
        btn.disableProperty().bind(pass.textProperty().isEmpty());
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Connection connect = null;
                Statement state = null;
                ResultSet result = null;
                ArrayList<String> what = new ArrayList<>();
                try
                {
                    connect = DriverManager.getConnection(DATABASE_URL, "local", "Plethora98!");       
                    state = connect.createStatement();
                    result = state.executeQuery("SELECT username, pass FROM test.User WHERE username = '" + lgin.getText() + "';");
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
                        if (pass.getText().equals(what.get(1)))
                        {
                            lg.setVisible(false);
                            suc.setVisible(true);
                            suc.setText("You have successfully logged in!");
                        }
                        else
                        {
                            lgin.clear();
                            pass.clear();
                            suc.setVisible(true);
                            suc.setText("Login failed. Please try again.");
                        }
                    }
                    else
                    {
                        lgin.clear();
                        pass.clear();
                        suc.setVisible(true);
                        suc.setText("Login failed. Please try again.");
                    }
                }
                catch (SQLException sqlexception)
                {
                    sqlexception.printStackTrace();
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
                    }
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
        GridPane reg = new GridPane();
        Button done = new Button("Register");
        Button back = new Button("Return");
        done.disableProperty().bind(regUserTF.textProperty().isEmpty());
        done.disableProperty().bind(regPassTF.textProperty().isEmpty());
        done.disableProperty().bind(regConfTF.textProperty().isEmpty());
        done.disableProperty().bind(firstNameTF.textProperty().isEmpty());
        done.disableProperty().bind(lastNameTF.textProperty().isEmpty());
        done.disableProperty().bind(phonNumTF.textProperty().isEmpty());
        done.disableProperty().bind(emailTF.textProperty().isEmpty());
        done.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                lg.setVisible(true);
                reg.setVisible(false);
                suc.setText("Please login now.");
            }
        });
        reg.addRow(0, regUser, regUserTF);
        reg.addRow(1, regPass, regPassTF);
        reg.addRow(2, regConf, regConfTF);
        reg.addRow(3, firstName, firstNameTF);
        reg.addRow(4, lastName, lastNameTF);
        reg.addRow(5, phonNum, phonNumTF);
        reg.addRow(6, email, emailTF);
        reg.addRow(7, done);
        reg.addRow(8, back);
        
        reg.setVisible(false);
        reg.setAlignment(Pos.CENTER);
        regis.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                lg.setVisible(false);
                reg.setVisible(true);
                suc.setText("Please fill the text fields.");
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                lg.setVisible(true);
                reg.setVisible(false);
            }
        });
        StackPane swtch = new StackPane();
        swtch.getChildren().addAll(lg, reg);
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
