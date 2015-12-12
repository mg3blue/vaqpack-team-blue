/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author mg3Blue
 */
public class MakeDocsPane {
    
    private Personal per;
    private ArrayList<Experience> exp;
    private ArrayList<Education> edu;
    private ArrayList<String> sk;
    
    VBox vb = new VBox(40);
    VBox r = new VBox(10);
    VBox bc = new VBox(10);
    
    
    Button generateBtn = new Button("Create Documents");
    
    HBox rthemes = new HBox(5);
    HBox bcthemes = new HBox(5);
    
    Label resumeL = new Label("Select Resume Theme");
    Label bCardL = new Label("Slect Business Card Theme");
    
    RadioButton rt1 = new RadioButton("Theme 1");
    RadioButton rt2 = new RadioButton("Theme 2");
    RadioButton rt3 = new RadioButton("Theme 3");
    RadioButton rt4 = new RadioButton("Theme 4");
    
    RadioButton bct1 = new RadioButton("Theme 1");
    RadioButton bct2 = new RadioButton("Theme 2");
    
    ToggleGroup rtg = new ToggleGroup();
    ToggleGroup bctg = new ToggleGroup();
    
    private Pane main = new Pane();
    
    MakeDocsPane(){
        
        vb.setAlignment(Pos.CENTER);
        r.setAlignment(Pos.CENTER);
        bc.setAlignment(Pos.CENTER);
        rthemes.setAlignment(Pos.CENTER);
        bcthemes.setAlignment(Pos.CENTER);
        
        rt1.setToggleGroup(rtg);
        rt2.setToggleGroup(rtg);
        rt3.setToggleGroup(rtg);
        rt4.setToggleGroup(rtg);
        rt1.setSelected(true);
        rthemes.getChildren().addAll(rt1,rt2,rt3,rt4);
        
        bct1.setToggleGroup(bctg);
        bct2.setToggleGroup(bctg);
        bct1.setSelected(true);
        bcthemes.getChildren().addAll(bct1,bct2);
        
        generateBtn.setOnAction((ActionEvent event) -> {
            ResumeGen rgen = new ResumeGen();
            BusinessCardGen bgen = new BusinessCardGen();
            
            RadioButton rrb = (RadioButton) rtg.getSelectedToggle();
            try {
                rgen.generateHTMLPage(per, exp, edu, sk, rrb.getText());
            } catch (IOException ex) {
                Logger.getLogger(MakeDocsPane.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RadioButton bcrb = (RadioButton) bctg.getSelectedToggle();
            try {
                bgen.generateHTMLPage(per, bcrb.getText());
            } catch (IOException ex) {
                Logger.getLogger(MakeDocsPane.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        });
        
        r.getChildren().addAll(resumeL, rthemes);
        bc.getChildren().addAll(bCardL, bcthemes);
        
        vb.getChildren().addAll(r,bc, generateBtn);
        
        main = vb;
        
    }
    
    /**
     *
     * @param per
     * @param exp
     * @param edu
     * @param sk
     */
    public void setData(Personal per, ArrayList<Experience> exp, ArrayList<Education> edu, ArrayList<String> sk ){
        this.per = per;
        this.exp = exp;
        this.edu = edu;
        this.sk = sk;
    }
    

    /**
     * @return the main
     */
    public Pane getMain() {
        return main;
    }

    /**
     * @param main the main to set
     */
    public void setMain(Pane main) {
        this.main = main;
    }
    
}
