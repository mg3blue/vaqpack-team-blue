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
        TextField lgin = new TextField();
        TextField pass = new TextField();
        Label log = new Label("Username: ");
        Label pss = new Label("Password: ");
        Label suc = new Label("You have successfully logged in!");
        GridPane lg = new GridPane();        
        lg.addRow(0, log, lgin);
        lg.addRow(1, pss, pass);
        lg.addRow(2, btn);
        lg.setAlignment(Pos.CENTER);
        suc.setVisible(false);
        suc.setAlignment(Pos.CENTER);
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
        
        BorderPane root = new BorderPane();
        root.setCenter(lg);
        root.setBottom(suc);
        
        Scene scene = new Scene(root, 300, 250);
        
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
