/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mg3Blue
 */
public class VaqPack_App extends Application {
    Button loginScnBtn = new Button("Login");
    Button userInfoBtn = new Button("Personal");
    Button resumeBtn = new Button("Resume");
    Button coverBtn = new Button("Cover Letter");
    Button generateBtn = new Button("Generate Docs");
    Button emailBtn = new Button("E-mail");
    BorderPane main = new BorderPane();
    ResumePane resumepane = new ResumePane();
    LoginPane loginpane = new LoginPane();
    UserInfoPane userpane = new UserInfoPane();
    MakeDocsPane makepane = new MakeDocsPane();
    VBox btnBox = new VBox(5);
    
    
    @Override
    public void start(Stage primaryStage) {
        loginScnBtn.setMaxWidth(Double.MAX_VALUE);
        userInfoBtn.setMaxWidth(Double.MAX_VALUE);
        resumeBtn.setMaxWidth(Double.MAX_VALUE);
        coverBtn.setMaxWidth(Double.MAX_VALUE);
        generateBtn.setMaxWidth(Double.MAX_VALUE);
        emailBtn.setMaxWidth(Double.MAX_VALUE);
        btnBox.getChildren().addAll(loginScnBtn, userInfoBtn, resumeBtn, coverBtn, generateBtn, emailBtn);
        btnBox.setPadding(new Insets(10, 50, 0, 10));
        
        
        resumeBtn.setOnAction((ActionEvent event) -> {
            main.setCenter(resumepane.getMain());
        });
        loginScnBtn.setOnAction((ActionEvent event) -> {
            main.setCenter(loginpane.getMain());
        });
        userInfoBtn.setOnAction((ActionEvent event) -> {
            main.setCenter(userpane.getMain());
        });
//        generateBtn.setOnAction((ActionEvent event) -> {
//            ResumeGen rgen = new ResumeGen("Some","some");
//            try {
//                rgen.generateHTMLPage(userpane.getPer(), resumepane.getExpList(), resumepane.getEduList(), resumepane.getSkillList());
//            } catch (IOException ex) {
//                Logger.getLogger(VaqPack_App.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        });
        generateBtn.setOnAction((ActionEvent event) -> {
            makepane.setData(userpane.getPer(), resumepane.getExpList(), resumepane.getEduList(), resumepane.getSkillList());
            main.setCenter(makepane.getMain());
            
            
        });
        
        
        
        main.setLeft(btnBox);
        
        main.setCenter(loginpane.getMain());
        
        //Scene scene = new Scene(loginpane.getMain(), 600, 600);
        Scene scene = new Scene(main, 600, 400);
        
        primaryStage.setTitle("VaqPack");
        primaryStage.getIcons().add(new Image("file:vq.png"));
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
