/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.AccessibleAttribute;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mg3Blue
 */
public class VaqPack_App extends Application {
    Button loginScnBtn = new Button("Login");
    //Button registerBtn = new Button("Register");
    Button resumeBtn = new Button("Resume");
    BorderPane main = new BorderPane();
    ResumePane resumepane = new ResumePane();
    LoginPane loginpane = new LoginPane();
    VBox btnBox = new VBox(5);
    
    
    @Override
    public void start(Stage primaryStage) {
        loginScnBtn.setMaxWidth(Double.MAX_VALUE);
        resumeBtn.setMaxWidth(Double.MAX_VALUE);
        btnBox.getChildren().addAll(loginScnBtn, resumeBtn);
        btnBox.setPadding(new Insets(10, 50, 0, 10));
        
        resumeBtn.setOnAction((ActionEvent event) -> {
            main.setCenter(resumepane.getMain());
        });
        loginScnBtn.setOnAction((ActionEvent event) -> {
            main.setCenter(loginpane.getMain());
        });
        main.setLeft(btnBox);
        
        
        //Scene scene = new Scene(loginpane.getMain(), 600, 600);
        Scene scene = new Scene(main, 600, 300);
        
        primaryStage.setTitle("VaqPack");
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
