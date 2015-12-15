/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

import java.io.File;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 *
 * @author csilva
 */
public class MailPane{
    
    private Pane main = new Pane();
    private ArrayList<Employer> emp = new ArrayList<Employer>();
    SendMail mail = new SendMail();
    GridPane grid = new GridPane();
    FileChooser fileChooser = new FileChooser();
    Label recipentLabel = new Label("To: ");
    Label setRecipientLabel = new Label();
    Label subjectLabel = new Label("Subject: ");
    Label setSubjectL = new Label("Resume Submission");
    Label bodyLabel = new Label("Message: ");
    TextArea bodyTarea = new TextArea("Attached is a cover letter and resume."
            +" Please take time to consider my application.");
    
    Label attachmentLabel = new Label("Attachment: ");
    Button attachmentButton = new Button("Attachment");
    Label attachedFile = new Label();
    
    Button send = new Button("Send");
    
    MailPane(Stage primaryStage){

        grid.setPadding(new Insets(10,0,0,0));

        //Adding Recipent Label and TextField
        grid.add(recipentLabel, 0, 1);
        grid.add(setRecipientLabel, 1 , 1);  
        //Adding subject Label and TextField
        grid.add(subjectLabel, 0, 2);
        grid.add(setSubjectL, 1, 2);
        
        //Adding Body Label and TextArea

        bodyTarea.setPrefSize(300, 100);
        bodyTarea.setWrapText(true);
        bodyTarea.disableProperty().set(true);
        grid.add(bodyLabel, 0, 3);
        grid.add(bodyTarea, 1, 3);
        //Adding Send Button
        grid.add(send, 0, 4);
    
        
        send.setOnAction(e -> {
            for (int i = 0; i < emp.size(); i++) {

                mail.setTitle(setSubjectL.getText());
                mail.setTo(emp.get(i).getEmail());
                mail.setBody(bodyTarea.getText());
                File file = new File(emp.get(i).getEmployrName() + "Submit.pdf");
                if (file.exists()) {
                    mail.setAttachment(file);
                    try {
                        mail.send();
                    } catch (MessagingException ex) {
                        System.out.println("Mail Error");
                    }
                } else {
                    System.out.println("File doesn't exist");
                }
            }
        });
        
        main = grid;
    }

    /**
     * checks if employer list is empty disables
     * send if it is
     * @return the mail pane
     */
    public Pane getMain() {
        send.disableProperty().set(emp.isEmpty());
        if(!emp.isEmpty()){
            String s = "";
            for(int i = 0; i < emp.size(); i++){
                s += emp.get(i).getEmployrName() +", ";
            }
            setRecipientLabel.setText(s);
        }
        
        return main;
    }

    /**
     * @param emp the emp to set
     */
    public void setEmp(ArrayList<Employer> emp) {
        this.emp = emp;
    }

}
