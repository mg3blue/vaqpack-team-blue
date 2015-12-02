/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writerprototype;

/**
 *
 * @author mg3Blue
 */
public class Skills extends ResumeElement{
    
    private String[] skillArray;
    
    @Override
    public void createContent()
    {
        StringBuilder finalString = new StringBuilder();
        
        finalString.append("<h2>Skills</h2>\n"+"<ul>"+"\n");
        for (int i = 0; i < skillArray.length; i++) {
            
            finalString.append("<li>");    
            finalString.append(skillArray[i]);
            finalString.append("</li>"+"\n");    
        }
        finalString.append("</ul>"+"\n");
        this.setHtmlData(finalString.toString());
}
    @Override
    public String getHtmlContent()
    {
        return this.getHtmlData();
    }

    public String[] getBulletListText() {
        return skillArray;
    }

    public void setSkills(String[] skillArray) {
        this.skillArray = skillArray;
    }
}
