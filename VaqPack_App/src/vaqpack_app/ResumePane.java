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
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author mg3Blue
 */
public class ResumePane {
    
    VBox main = new VBox(10);
    
    //<editor-fold desc="Experience Elements">
    
    GridPane experienceGrid = new GridPane();
    ArrayList<Experience> expList = new ArrayList<Experience>();
    ListView<String> expLV = new ListView<String>();
    ObservableList<String> expData = FXCollections.observableArrayList();
    VBox expBox = new VBox(5);
    HBox expBtnBox = new HBox();
    Label employerL = new Label("Employer:");
    Label supervisorL = new Label("Supervisor");
    Label cityExpL = new Label("City:");
    Label stateExpL = new Label("State:");
    Label descriptionL = new Label("Description:");
    Label yearExpL = new Label("Years:");
    TextField employerTF = new TextField();
    TextField supervisorTF = new TextField();
    TextField cityExpTF = new TextField();
    TextField stateExpTF = new TextField();
    TextField descriptionTF = new TextField();
    TextField yearExpTF = new TextField();
    int expIndex = 1;
    //</editor-fold>
    
    //<editor-fold desc="Education Elements">
    GridPane edGrid = new GridPane();
    ArrayList<Education> eduList = new ArrayList<>();
    ListView<String> eduLV = new ListView<>();
    ObservableList<String> eduData = FXCollections.observableArrayList();
    VBox eduBox = new VBox(5);
    HBox eduBtnBox = new HBox();
    Label schoolL = new Label("School:");
    Label cityEduL = new Label("City:");
    Label stateEduL = new Label("State:");
    Label yearEduL = new Label("Years:");
    TextField schoolTF = new TextField();
    TextField cityEduTF = new TextField();
    TextField stateEduTF = new TextField();
    TextField yearEduTF = new TextField();
    int eduIndex = 1;
    //</editor-fold>

    //<editor-fold desc="Skill Elements">
    GridPane skillGrid = new GridPane();
    ArrayList<String> skillList = new ArrayList<>();
    ListView<String> skLV = new ListView<>();
    ObservableList<String> skData = FXCollections.observableArrayList();
    VBox skBox = new VBox(5);
    HBox skBtnBox = new HBox();
    Label skillL = new Label("Skill:");
    TextField skillTF = new TextField();
    //</editor-fold>
    
    
    
    ResumePane() {
        
        //<editor-fold desc="Experience Pane">
        expLV.setMaxSize(100, 50);
        stateExpTF.setPrefWidth(50);
        stateExpTF.setMinWidth(50);
        yearExpTF.setPrefWidth(50);
        yearExpTF.setMinWidth(50);
        
        experienceGrid.setHgap(5);
        //col // row
        experienceGrid.add(employerL, 0, 0);
        experienceGrid.add(supervisorL, 1, 0);
        experienceGrid.add(cityExpL, 2, 0);
        experienceGrid.add(stateExpL, 3, 0);
        experienceGrid.add(descriptionL, 4, 0);
        experienceGrid.add(yearExpL, 5, 0);
        experienceGrid.add(employerTF, 0, 1);
        experienceGrid.add(supervisorTF, 1, 1);
        experienceGrid.add(cityExpTF, 2, 1);
        experienceGrid.add(stateExpTF, 3, 1);
        experienceGrid.add(descriptionTF, 4, 1);
        experienceGrid.add(yearExpTF, 5, 1);
        
        Button addWork = new Button("Add");
        Button delWork = new Button("Delete");
        Button modWork = new Button("Modify");
        addWork.setOnAction((ActionEvent event) -> {
            
            Experience e = new Experience();
            e.setEname(employerTF.getText());
            e.setSupervisor(supervisorTF.getText());
            e.setCity(cityExpTF.getText());
            e.setState(stateExpTF.getText());
            e.setDescription(descriptionTF.getText());
            e.setYears(yearExpTF.getText());
            expList.add(e);
            expData.add("Job " + expIndex);
            expIndex++;

        });
         delWork.setOnAction((ActionEvent event) -> {
            if(!expList.isEmpty() && !expLV.getSelectionModel().isEmpty()){
            int x;
            x = expLV.getSelectionModel().getSelectedIndex();
            expData.remove(x);
            expList.remove(x);
            expLV.getSelectionModel().clearSelection();
            }
            
        });
         modWork.setOnAction((ActionEvent event) -> {
            if(!expList.isEmpty() && !expLV.getSelectionModel().isEmpty()){
            int x = expLV.getSelectionModel().getSelectedIndex();
            expList.get(x).setEname(employerTF.getText());
            expList.get(x).setSupervisor(supervisorTF.getText());
            expList.get(x).setCity(cityExpTF.getText());
            expList.get(x).setState(stateExpTF.getText());
            expList.get(x).setDescription(descriptionTF.getText());
            expList.get(x).setYears(yearExpTF.getText());
            
            }
            
        });

        expLV.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    if (!expList.isEmpty() && !expLV.getSelectionModel().isEmpty()) {
                        int x = expLV.getSelectionModel().getSelectedIndex();
                        employerTF.setText(expList.get(x).getEname());
                        supervisorTF.setText(expList.get(x).getSupervisor());
                        cityExpTF.setText(expList.get(x).getCity());
                        stateExpTF.setText(expList.get(x).getState());
                        descriptionTF.setText(expList.get(x).getDescription());
                        yearExpTF.setText(expList.get(x).getYears());
                    }
                    
        });
        //</editor-fold>
        
        //<editor-fold desc="Education Pane">
        eduLV.setMaxSize(100, 50);
        stateEduTF.setPrefWidth(50);
        stateEduTF.setMinWidth(50);
        yearEduTF.setPrefWidth(50);
        yearEduTF.setMinWidth(50);
        
        edGrid.setHgap(5);
        
        //col // row
        edGrid.add(schoolL, 0, 0);
        edGrid.add(cityEduL, 1, 0);
        edGrid.add(stateEduL, 2, 0);
        edGrid.add(yearEduL, 3, 0);
        edGrid.add(schoolTF, 0, 1);
        edGrid.add(cityEduTF, 1, 1);
        edGrid.add(stateEduTF, 2, 1);
        edGrid.add(yearEduTF, 3, 1);
        
        Button addSchool = new Button("Add");
        Button delSchool = new Button("Delete");
        Button modSchool = new Button("Modify");
        
        addSchool.setOnAction((ActionEvent event) -> {
            Education e = new Education();
            e.setSname(schoolTF.getText());
            e.setCity(cityEduTF.getText());
            e.setState(stateEduTF.getText());
            e.setYears(yearEduTF.getText());
            eduList.add(e);
            eduData.add("School " + eduIndex);
            eduIndex++;
        });
         delSchool.setOnAction((ActionEvent event) -> {
            if(!eduList.isEmpty() && !eduLV.getSelectionModel().isEmpty()){
            int x;
            x = eduLV.getSelectionModel().getSelectedIndex();
            eduData.remove(x);
            eduList.remove(x);
            eduLV.getSelectionModel().clearSelection();
            }
            
        });
         modSchool.setOnAction((ActionEvent event) -> {
            if(!eduList.isEmpty() && !eduLV.getSelectionModel().isEmpty()){
            int x = eduLV.getSelectionModel().getSelectedIndex();
            eduList.get(x).setSname(schoolTF.getText());
            eduList.get(x).setCity(cityEduTF.getText());
            eduList.get(x).setState(stateEduTF.getText());
            eduList.get(x).setYears(yearEduTF.getText());
            }
            
        });

        eduLV.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    if (!eduList.isEmpty() && !eduLV.getSelectionModel().isEmpty()) {
                        int x = eduLV.getSelectionModel().getSelectedIndex();
                        schoolTF.setText(eduList.get(x).getSname());
                        cityEduTF.setText(eduList.get(x).getCity());
                        stateEduTF.setText(eduList.get(x).getState());
                        yearEduTF.setText(eduList.get(x).getYears());
                    }
                    
        });  
        //</editor-fold>
        
        //<editor-fold desc="Skill Pane">
        skLV.setMaxSize(100, 50);
        
        //col // row
        skillGrid.add(skillL, 0, 0);
        skillGrid.add(skillTF, 0, 1);
        
        Button addSkill = new Button("Add");
        Button delSkill = new Button("Delete");
        Button modSkill = new Button("Modify");
        
        addSkill.setOnAction((ActionEvent event) -> {
            String skill = skillTF.getText();
            skillList.add(skill);
            skData.add(skill);
            //skIndex++;
        });
         delSkill.setOnAction((ActionEvent event) -> {
            if(!skillList.isEmpty() && !skLV.getSelectionModel().isEmpty()){
            int x = skLV.getSelectionModel().getSelectedIndex();
            skData.remove(x);
            skillList.remove(x);
            skLV.getSelectionModel().clearSelection();
            }
            
        });
         modSkill.setOnAction((ActionEvent event) -> {
            if(!skillList.isEmpty() && !skLV.getSelectionModel().isEmpty()){
            int x = skLV.getSelectionModel().getSelectedIndex();
            skData.set(x, skillTF.getText());
            skillList.set(x, skillTF.getText());
            }
            
        });

        skLV.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    if(!skillList.isEmpty() && !skLV.getSelectionModel().isEmpty()) {
                        System.out.println("Test");
                        int x = skLV.getSelectionModel().getSelectedIndex();
                        skillTF.setText(skillList.get(x));
                    }
                    
        }); 
        //</editor-fold>
        
        
        expLV.setItems(expData);
        expBtnBox.getChildren().addAll(addWork,delWork,modWork);
        expBox.getChildren().add(experienceGrid);
        expBox.getChildren().add(expLV);
        
        eduLV.setItems(eduData);
        eduBtnBox.getChildren().addAll(addSchool,delSchool,modSchool); 
        eduBox.getChildren().add(edGrid);
        eduBox.getChildren().add(eduLV);
        
        skLV.setItems(skData);
        skBtnBox.getChildren().addAll(addSkill,delSkill,modSkill);
        skBox.getChildren().add(skillGrid);
        skBox.getChildren().add(skLV);
        
        
        main.getChildren().add(expBox);
        main.getChildren().add(expBtnBox);
        main.getChildren().addAll(eduBox, eduBtnBox);
        main.getChildren().addAll(skBox, skBtnBox);
       


    }
    
    public VBox getMain(){
        return main;
    }
    
}
  
