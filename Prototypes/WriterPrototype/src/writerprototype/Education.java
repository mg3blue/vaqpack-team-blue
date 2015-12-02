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
public class Education extends ResumeElement {

    private String[][] educationElements;

    @Override
    public void createContent() {
        StringBuilder finalString = new StringBuilder();
        String quote = "\"";

        finalString.append("<h2>Education</h2>\n"+"<table style=\"width:50%\">");
        for (int i = 0; i < getEducationElements().length; i++) {
            finalString.append("<tr>" + "\n");
            for (int j = 0; j < getEducationElements()[0].length; j++) {
                if (i == 0) {
                    finalString.append("<td><b>" + getEducationElements()[i][j] + "</b></td>" + "\n");
                } else {
                    finalString.append("<td>" + getEducationElements()[i][j] + "</td>" + "\n");
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

    public String[][] getEducationElements() {
        return educationElements;
    }

    public void setEducationElements(String[][] educationElements) {
        this.educationElements = educationElements;
    }  
}
