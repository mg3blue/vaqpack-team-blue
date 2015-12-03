/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendemail;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 *
 * @author csilva
 */
public class MailUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        SendMail mail = new SendMail();
        GridPane grid = new GridPane();
        FileChooser fileChooser = new FileChooser();
        
        //Adding Recipent Label and TextField
        Label recipentLabel = new Label("To: ");
        TextField recipentTfield = new TextField();
        grid.add(recipentLabel, 0, 1);
        grid.add(recipentTfield, 1 , 1);
        
        //Adding subject Label and TextField
        Label subjectLabel = new Label("Subject: ");
        TextField subjectTfield = new TextField("My Professional Information");
        grid.add(subjectLabel, 0, 2);
        grid.add(subjectTfield, 1, 2);
        
        //Adding Body Label and TextArea
        Label bodyLabel = new Label("Message: ");
        TextArea bodyTarea = new TextArea();
        grid.add(bodyLabel, 0, 3);
        grid.add(bodyTarea, 1, 3);
        
        //Adding Attachment Label and Button
        Label attachmentLabel = new Label("Attachment: ");
        Button attachmentButton = new Button("Attachment");
        grid.add(attachmentLabel, 0, 4);
        grid.add(attachmentButton, 1, 4);
        
        Label attachedFile = new Label();
        grid.add(attachedFile, 2, 4);
        
        attachmentButton.setOnAction(e -> {
                 File file = fileChooser.showOpenDialog(primaryStage);
                 
                 if(file != null){
                     mail.setAttachment(file.getAbsolutePath());
                     attachedFile.setText(file.getName());
                 }
                 else{
                      Alert alert = new Alert(AlertType.CONFIRMATION, "Oops, something went wrong with the file!");
                      alert.showAndWait();             
                 }           
        });
        
       
        Button send = new Button("Send");
        grid.add(send, 0, 5);
        
        send.setOnAction(e -> {
          mail.setTitle(subjectTfield.getText());
          mail.setTo(recipentTfield.getText());
          mail.setBody(bodyTarea.getText());
          
            try {
                mail.send();
            } catch (MessagingException ex) {
                Logger.getLogger(MailUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
        Scene scene = new Scene(grid, 600, 500);
        
        primaryStage.setTitle("Send Email");
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
