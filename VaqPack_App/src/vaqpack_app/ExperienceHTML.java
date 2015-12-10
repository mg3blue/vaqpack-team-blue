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
public class ExperienceHTML extends ResumeElement{

    private ArrayList<Experience> experienceElements;

    @Override
    public void createContent() {
        StringBuilder finalString = new StringBuilder();
        String quote = "\"";
        

        finalString.append("<h2>Experience</h2>\n"+"<table style=\"width:50%\">");
        finalString.append("<tr>" + "\n"); // start new row
        finalString.append("<td><b>" + "Employer" + "</b></td>" + "\n");
        finalString.append("<td><b>" + "Supervisor" + "</b></td>" + "\n");
        finalString.append("<td><b>" + "City" + "</b></td>" + "\n");
        finalString.append("<td><b>" + "State" + "</b></td>" + "\n");
        finalString.append("<td><b>" + "Description" + "</b></td>" + "\n");
        finalString.append("<td><b>" + "Years" + "</b></td>" + "\n");
        finalString.append("</tr>" + "\n"); // end row
        
        
        for(int i = 0; i < getExperienceElements().size(); i++){
            finalString.append("<tr>" + "\n"); // start new row
            finalString.append("<td>" + getExperienceElements().get(i).getEname() + "</td>" + "\n");
            finalString.append("<td>" + getExperienceElements().get(i).getSupervisor() + "</td>" + "\n");
            finalString.append("<td>" + getExperienceElements().get(i).getCity() + "</td>" + "\n");
            finalString.append("<td>" + getExperienceElements().get(i).getState() + "</td>" + "\n");
            finalString.append("<td>" + getExperienceElements().get(i).getDescription() + "</td>" + "\n");
            finalString.append("<td>" + getExperienceElements().get(i).getYears() + "</td>" + "\n");
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
     * @return the experienceElements
     */
    public ArrayList<Experience> getExperienceElements() {
        return experienceElements;
    }

    /**
     * @param experienceElements the experienceElements to set
     */
    public void setExperienceElements(ArrayList<Experience> experienceElements) {
        this.experienceElements = experienceElements;
    }
}