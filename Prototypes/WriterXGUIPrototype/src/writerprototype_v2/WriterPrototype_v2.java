/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writerprototype_v2;

import java.util.ArrayList;
import javafx.application.Application;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import writerprototype_v2.WriterPrototype_v2.Exp;

/**
 *
 * @author mg3Blue
 */
public class WriterPrototype_v2 extends Application {
    
    VBox vb = new VBox();
    HBox hb = new HBox();
    Label empL = new Label("Employer:");
    Label stL = new Label("State:");
    Label yrL = new Label("Years:");
    
    TextField empT = new TextField();
    TextField stT = new TextField();
    TextField yrT = new TextField();
    
    int i = 1;
    GridPane gpane = new GridPane();
    
    ArrayList<Exp> alist = new ArrayList<Exp>();
    
    
    ListView<String> list = new ListView<String>();
    ObservableList<String> data = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage primaryStage) {
        //list.setPrefSize(20, 20);
        list.setMaxSize(100, 50);
        
        //col // row
        gpane.add(empL, 0, 0);
        gpane.add(stL, 1, 0);
        gpane.add(yrL, 2, 0);
        gpane.add(empT, 0, 1);
        gpane.add(stT, 1, 1);
        gpane.add(yrT, 2, 1);
        
        
        Button addWork = new Button("ADD");
        Button delWork = new Button("DELETE");
        Button modWork = new Button("MODIFY");
        addWork.setOnAction((ActionEvent event) -> {
            
            Exp e = new Exp();
            e.setEname(empT.getText());
            e.setState(stT.getText());
            e.setYears(yrT.getText());
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
            }
            
        });
         modWork.setOnAction((ActionEvent event) -> {
            if(!alist.isEmpty() && !list.getSelectionModel().isEmpty()){
            int x = list.getSelectionModel().getSelectedIndex();
            alist.get(x).setEname(empT.getText());
            alist.get(x).setState(stT.getText());
            alist.get(x).setYears(yrT.getText());
            
            }
            
        });

        list.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    int x = list.getSelectionModel().getSelectedIndex();
                    empT.setText(alist.get(x).getEname());
                    stT.setText(alist.get(x).getState());
                    yrT.setText(alist.get(x).getYears());
                    
        });
        
        
        list.setItems(data);
        hb.getChildren().addAll(addWork,delWork,modWork);
        vb.getChildren().add(gpane);
        vb.getChildren().add(list);
        
        BorderPane root = new BorderPane();
        root.setCenter(vb);
        root.setBottom(hb);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    class Exp{
    
        private String ename;
        private String state;
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
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
