/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

import java.util.ArrayList;

/**
 *
 * @author mg3Blue
 */
public class EducationHTML extends ResumeElement{

    private ArrayList<Education> educationElements;

    @Override
    public void createContent() {
        StringBuilder finalString = new StringBuilder();
        String quote = "\"";
        

        finalString.append("<h2>Education</h2>\n"+"<table style=\"width:50%\">");
        finalString.append("<tr>" + "\n"); // start new row
        finalString.append("<td><b>" + "School" + "</b></td>" + "\n");
        finalString.append("<td><b>" + "City" + "</b></td>" + "\n");
        finalString.append("<td><b>" + "State" + "</b></td>" + "\n");
        finalString.append("<td><b>" + "Years" + "</b></td>" + "\n");
        finalString.append("</tr>" + "\n"); // end row
        
        
        for(int i = 0; i < getEducationElements().size(); i++){
            finalString.append("<tr>" + "\n"); // start new row
            finalString.append("<td>" + getEducationElements().get(i).getSname() + "</td>" + "\n");
            finalString.append("<td>" + getEducationElements().get(i).getCity() + "</td>" + "\n");
            finalString.append("<td>" + getEducationElements().get(i).getState() + "</td>" + "\n");
            finalString.append("<td>" + getEducationElements().get(i).getYears() + "</td>" + "\n");
            finalString.append("</tr>" + "\n"); // end row
        }
        finalString.append("</table>" + "\n" + "<br>" + "\n");
        this.setHtmlData(finalString.toString());
}
//
    @Override
    public String getHtmlContent() {
        return this.getHtmlData();
    }

    /**
     * @return the educationElements
     */
    public ArrayList<Education> getEducationElements() {
        return educationElements;
    }

    /**
     * @param educationElements the educationElements to set
     */
    public void setEducationElements(ArrayList<Education> educationElements) {
        this.educationElements = educationElements;
    }
}