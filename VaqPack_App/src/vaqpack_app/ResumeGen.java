/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author mg3Blue
 */
public class ResumeGen {
    private String webTitle;
    private String webHeader;

    public ResumeGen(String myTitle,String myHeader) {
        webTitle =myTitle; 
        webHeader=myHeader;
    }

    PrintWriter outputStream = null;
    ArrayList<ResumeElement> list = new ArrayList<>();
    public void appendResumeElement(ResumeElement e)
    {
        list.add(e);
    }

    public void generateHTMLPage(String fname, ArrayList<Experience> exp, ArrayList<Education> edu, ArrayList<String> skill) throws IOException {
        outputStream = new PrintWriter(new FileWriter(fname));
        ResumeElement begin = new ResumeElement();
        ResumeElement style = new ResumeElement();
        ResumeElement end = new ResumeElement();

        begin.setData("<!DOCTYPE html>\n"
                + "<html>\n" + "<head>\n" + "<title>" +webTitle+ "</title>\n");
        style.setData("<style></stlye>" + "</head>\n" + "<body>\n" + "<h1>" +webHeader+ "</h1>");
        end.setData("</body>\n" + "</html>");

        list.add(0, begin);
        list.add(end);
        
        
        
        
        
        
        

        for (int i = 0; i < list.size(); i++) {
            list.get(i).createContent();
            String data = list.get(i).getHtmlContent();
            outputStream.println(data);
        }

        if (outputStream != null) {
            outputStream.close();
        }
    }
}
