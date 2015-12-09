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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mg3Blue
 */
public class ResumePane {
    
    VBox main = new VBox();
    
    VBox vb = new VBox();
    VBox vb2 = new VBox();
    HBox hb = new HBox();
    Label employerL = new Label("Employer:");
    Label supervisorL = new Label("Supervisor");
    Label cityL = new Label("City:");
    Label stateL = new Label("State:");
    Label descriptionL = new Label("Description:");
    Label yearL = new Label("Years:");
    TextField employerTF = new TextField();
    TextField supervisorTF = new TextField();
    TextField cityTF = new TextField();
    TextField stateTF = new TextField();
    TextField descriptionTF = new TextField();
    TextField yearTF = new TextField();
    
    int i = 1;
    GridPane experienceGrid = new GridPane();
    
    ArrayList<Exp> alist = new ArrayList<Exp>();
    ListView<String> list = new ListView<String>();
    ObservableList<String> data = FXCollections.observableArrayList();
    
    ResumePane() {
        //list.setPrefSize(20, 20);
        list.setMaxSize(100, 50);
        
        //col // row
        experienceGrid.add(employerL, 0, 0);
        experienceGrid.add(supervisorL, 1, 0);
        experienceGrid.add(cityL, 2, 0);
        experienceGrid.add(stateL, 3, 0);
        experienceGrid.add(descriptionL, 4, 0);
        experienceGrid.add(yearL, 5, 0);
        experienceGrid.add(employerTF, 0, 1);
        experienceGrid.add(supervisorTF, 1, 1);
        experienceGrid.add(cityTF, 2, 1);
        experienceGrid.add(stateTF, 3, 1);
        experienceGrid.add(descriptionTF, 4, 1);
        experienceGrid.add(yearTF, 5, 1);
        
        Button addWork = new Button("ADD");
        Button addWork1 = new Button("WOk");
        Button delWork = new Button("DELETE");
        Button modWork = new Button("MODIFY");
        addWork.setOnAction((ActionEvent event) -> {
            
            Exp e = new Exp();
            e.setEname(employerTF.getText());
            e.setState(supervisorTF.getText());
            e.setCity(cityTF.getText());
            e.setState(stateTF.getText());
            e.setDescription(descriptionTF.getText());
            e.setYears(yearTF.getText());
            alist.add(e);
            data.add("Job "+i);
            i++;

        });
         delWork.setOnAction((ActionEvent event) -> {
            if(!alist.isEmpty() && !list.getSelectionModel().isEmpty()){
            int x;
            x = list.getSelectionModel().getSelectedIndex();
            data.remove(x);
            alist.remove(x);
            list.getSelectionModel().clearSelection();
            }
            
        });
         modWork.setOnAction((ActionEvent event) -> {
            if(!alist.isEmpty() && !list.getSelectionModel().isEmpty()){
            int x = list.getSelectionModel().getSelectedIndex();
            alist.get(x).setEname(employerTF.getText());
            alist.get(x).setSupervisor(supervisorTF.getText());
            alist.get(x).setCity(cityTF.getText());
            alist.get(x).setState(stateTF.getText());
            alist.get(x).setDescription(descriptionTF.getText());
            alist.get(x).setYears(yearTF.getText());
            
            }
            
        });

        list.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    if (!alist.isEmpty() && !list.getSelectionModel().isEmpty()) {
                        int x = list.getSelectionModel().getSelectedIndex();
                        employerTF.setText(alist.get(x).getEname());
                        supervisorTF.setText(alist.get(x).getSupervisor());
                        cityTF.setText(alist.get(x).getCity());
                        stateTF.setText(alist.get(x).getState());
                        descriptionTF.setText(alist.get(x).getDescription());
                        yearTF.setText(alist.get(x).getYears());
                    }
                    
        });
        
        list.setItems(data);
        hb.getChildren().addAll(addWork,delWork,modWork);
        vb.getChildren().add(experienceGrid);
        vb.getChildren().add(list);
        main.getChildren().add(vb);
        main.getChildren().add(hb);
        
//        root.setCenter(vb);
//        root.setBottom(hb);


    }
    
    public VBox getMain(){
        return main;
    }
    
    
    class Exp{
    
        private String ename;
        private String Supervisor;
        private String city;
        private String state;
        private String Description;
        private String years;

        /**
         * @return the ename
         */
        public String getEname() {
            return ename;
        }

        /**
         * @param ename the ename to set
         */
        public void setEname(String ename) {
            this.ename = ename;
        }

        /**
         * @return the state
         */
        public String getState() {
            return state;
        }

        /**
         * @param state the state to set
         */
        public void setState(String state) {
            this.state = state;
        }

        /**
         * @return the years
         */
        public String getYears() {
            return years;
        }

        /**
         * @param years the years to set
         */
        public void setYears(String years) {
            this.years = years;
        }

        /**
         * @return the Supervisor
         */
        public String getSupervisor() {
            return Supervisor;
        }

        /**
         * @param Supervisor the Supervisor to set
         */
        public void setSupervisor(String Supervisor) {
            this.Supervisor = Supervisor;
        }

        /**
         * @return the city
         */
        public String getCity() {
            return city;
        }

        /**
         * @param city the city to set
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         * @return the Description
         */
        public String getDescription() {
            return Description;
        }

        /**
         * @param Description the Description to set
         */
        public void setDescription(String Description) {
            this.Description = Description;
        }
        
        
        
        
    }

}
  
