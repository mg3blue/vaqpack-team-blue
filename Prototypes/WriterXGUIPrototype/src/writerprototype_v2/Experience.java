/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writerprototype_v2;

/**
 *
 * @author mg3Blue
 */
public class Experience extends ResumeElement{

    private String[][] experienceElements;

    @Override
    public void createContent() {
        StringBuilder finalString = new StringBuilder();
        String quote = "\"";

        finalString.append("<h2>Experience</h2>\n"+"<table style=\"width:50%\">");
        for (int i = 0; i < getExperienceElements().length; i++) {
            finalString.append("<tr>" + "\n");
            for (int j = 0; j < getExperienceElements()[0].length; j++) {
                if (i == 0) {
                    finalString.append("<td><b>" + getExperienceElements()[i][j] + "</b></td>" + "\n");
                } else {
                    finalString.append("<td>" + getExperienceElements()[i][j] + "</td>" + "\n");
                }
            }
            finalString.append("</tr>" + "\n");
        }
        finalString.append("</table>" + "\n" + "<br>" + "\n");

        this.setHtmlData(finalString.toString());
    }
//
    @Override
    public String getHtmlContent() {
        return this.getHtmlData();
    }

    public String[][] getExperienceElements() {
        return experienceElements;
    }

    public void setExperienceElements(String[][] experienceElements) {
        this.experienceElements = experienceElements;
    }  
}
