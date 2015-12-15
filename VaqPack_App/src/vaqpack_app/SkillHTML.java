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
public class SkillHTML extends ResumeElement{
    
    private ArrayList<String> skillElements = new ArrayList<>();
    
    @Override
    public void createContent()
    {
        StringBuilder finalString = new StringBuilder();
        
        finalString.append("<h2>Skills</h2>\r\n"+"<ul>"+"\r\n");
        for (int i = 0; i < getSkillElements().size(); i++) {
            
            finalString.append("<li>");    
            finalString.append(skillElements.get(i));
            finalString.append("</li>"+"\r\n");    
        }
        finalString.append("</ul>"+"\r\n");
        this.setHtmlData(finalString.toString());
}
    @Override
    public String getHtmlContent()
    {
        return this.getHtmlData();
    }
    /**
     * @return the skillElements
     */
    public ArrayList<String> getSkillElements() {
        return skillElements;
    }

    /**
     * @param skillElements the skillElements to set
     */
    public void setSkillElements(ArrayList<String> skillElements) {
        this.skillElements = skillElements;
    }
}
