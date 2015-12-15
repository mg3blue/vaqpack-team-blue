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
        

        finalString.append("<h2>Experience</h2>\r\n"+"<table style=\"width:50%\">");
        finalString.append("<tr>" + "\r\n"); // start new row
        finalString.append("<th><b>" + "Employer" + "</b></th>" + "\r\n");
        finalString.append("<th><b>" + "Supervisor" + "</b></th>" + "\r\n");
        finalString.append("<th><b>" + "City" + "</b></th>" + "\r\n");
        finalString.append("<th><b>" + "State" + "</b></th>" + "\r\n");
        finalString.append("<th><b>" + "Description" + "</b></th>" + "\r\n");
        finalString.append("<th><b>" + "Years" + "</b></th>" + "\r\n");
        finalString.append("</tr>" + "\r\n"); // end row
        
        
        for(int i = 0; i < getExperienceElements().size(); i++){
            finalString.append("<tr>" + "\r\n"); // start new row
            finalString.append("<td>" + getExperienceElements().get(i).getEname() + "</td>" + "\r\n");
            finalString.append("<td>" + getExperienceElements().get(i).getSupervisor() + "</td>" + "\r\n");
            finalString.append("<td>" + getExperienceElements().get(i).getCity() + "</td>" + "\r\n");
            finalString.append("<td>" + getExperienceElements().get(i).getState() + "</td>" + "\r\n");
            finalString.append("<td>" + getExperienceElements().get(i).getDescription() + "</td>" + "\r\n");
            finalString.append("<td>" + getExperienceElements().get(i).getYears() + "</td>" + "\r\n");
            finalString.append("</tr>" + "\r\n"); // end row
        }
        finalString.append("</table>" + "\r\n" + "<br></br>" + "\r\n");
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