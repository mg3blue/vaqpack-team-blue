/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author mg3Blue
 */
public class CoverLetterPane {
    //static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/test";
    
    private ArrayList<Employer> empList = new ArrayList<Employer>();
    ListView<String> empLV = new ListView<String>();
    ObservableList<String> empData = FXCollections.observableArrayList();
    
    //Register Pane nodes
    VBox pane = new VBox(5);
    HBox btnBox = new HBox(5);
    GridPane employrInfoPane = new GridPane();
    Button addEmployer = new Button("Add");
    Button delEmployer = new Button("Delete");
    Button modEmployer = new Button("Modify");
    TextField employrNameTF = new TextField("");
    TextField compNameTF = new TextField("");
    TextField positionNameTF = new TextField("");
    TextField emailTF = new TextField("");
    Label employrName = new Label("Employer Name: ");
    Label compName = new Label("Company Name: ");
    Label positionName = new Label("Position Applying For: ");
    Label email = new Label("E-mail address: ");

    //Pane to return;
    Pane main = new Pane();
    
    CoverLetterPane() {
        pane.setAlignment(Pos.CENTER);
        empLV.setMaxSize(200, 100);
        employrInfoPane.setVgap(5);
        empLV.setItems(empData);
        
        employrInfoPane.addRow(0, employrName, employrNameTF);
        employrInfoPane.addRow(1, compName, compNameTF);
        employrInfoPane.addRow(2, positionName, positionNameTF);
        employrInfoPane.addRow(3, email, emailTF);
        //employrInfoPane.setAlignment(Pos.CENTER);
        
        btnBox.getChildren().addAll(addEmployer,delEmployer, modEmployer);
        btnBox.setAlignment(Pos.CENTER);
        
        pane.getChildren().addAll(employrInfoPane, empLV, btnBox);
        
        
        //Register Pane settings and setup
//        rpRegisterButton.disableProperty().bind(regConfTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(firstNameTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(lastNameTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(phonNumTF.textProperty().isEmpty());
//        rpRegisterButton.disableProperty().bind(emailTF.textProperty().isEmpty());
        
        addEmployer.disableProperty().bind(employrNameTF.textProperty().isEmpty());
        addEmployer.disableProperty().bind(compNameTF.textProperty().isEmpty());
        addEmployer.disableProperty().bind(positionNameTF.textProperty().isEmpty());
        addEmployer.disableProperty().bind(emailTF.textProperty().isEmpty());


        
        addEmployer.setOnAction((ActionEvent event) -> {
            Employer emp = new Employer();
            emp.setEmployrName(employrNameTF.getText());
            emp.setCompanyName(compNameTF.getText());
            emp.setPositionname(positionNameTF.getText());
            emp.setEmail(emailTF.getText());
            empData.add(emp.getEmployrName());
            empList.add(emp);
        });
        delEmployer.setOnAction((ActionEvent event) -> {
            if(!empList.isEmpty() && !empLV.getSelectionModel().isEmpty()){
            int x;
            x = empLV.getSelectionModel().getSelectedIndex();
            empData.remove(x);
            empList.remove(x);
            empLV.getSelectionModel().clearSelection();
            }
        });
         modEmployer.setOnAction((ActionEvent event) -> {
            if(!empList.isEmpty() && !empLV.getSelectionModel().isEmpty()){
            int x = empLV.getSelectionModel().getSelectedIndex();
            empList.get(x).setEmployrName(employrNameTF.getText());
            empList.get(x).setCompanyName(compNameTF.getText());
            empList.get(x).setPositionname(positionNameTF.getText());
            empList.get(x).setEmail(emailTF.getText());
            empData.set(x, employrNameTF.getText());
            }
            
        });
        
        
        empLV.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    if (!empList.isEmpty() && !empLV.getSelectionModel().isEmpty()) {
                        int x = empLV.getSelectionModel().getSelectedIndex();
                        employrNameTF.setText(empList.get(x).getEmployrName());
                        compNameTF.setText(empList.get(x).getCompanyName());
                        positionNameTF.setText(empList.get(x).getPositionname());
                        emailTF.setText(empList.get(x).getEmail());
                    }
                    
        });
        
        main = pane;
        

    }
    
    public Pane getMain(){
        return this.main;
    }

    /**
     * @return the empList
     */
    public ArrayList<Employer> getEmpList() {
        return empList;
    }

    
}