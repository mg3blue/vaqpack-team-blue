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
public class BusinessCardGen {

    PrintWriter outputStream = null;
    ArrayList<ResumeElement> list = new ArrayList<>();

    public void generateHTMLPage(Personal per, String theme) throws IOException {
        outputStream = new PrintWriter(new FileWriter(per.getFname()+"BusinessCard.html"));
        ResumeElement begin = new ResumeElement();
        ResumeElement style = new ResumeElement();
        ResumeElement end = new ResumeElement();
        Themes th = new Themes();
        
        BusinessCardHTML bushtml = new BusinessCardHTML();

        begin.setData("<!DOCTYPE html>\n"
                + "<html>\n" + "<head>\n" + "<title>" + per.getFname() +"'s Buisness Card"+ "</title>\n");
        
        if("Theme 1".equals(theme)){
            style.setData(th.bcTheme1());
        }
        if("Theme 2".equals(theme)){
            style.setData(th.bcTheme2());
        }
        
        end.setData("</body>\n" + "</html>");
        
        list.add(begin);
        list.add(style);
        
        
        bushtml.setPer(per);
        list.add(bushtml);

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
