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
public class CoveLetterGen {

    PrintWriter outputStream = null;
    ArrayList<ResumeElement> list = new ArrayList<>();

    public void generateHTMLPage(Employer emp, Personal per) throws IOException {
        PrintWriter outputStream = new PrintWriter(new FileWriter(emp.getEmployrName()+"Cover.html"));
        list = new ArrayList<>();
        ResumeElement begin = new ResumeElement();
        ResumeElement end = new ResumeElement();

        CoverLetterHTML coverhtml = new CoverLetterHTML();

        begin.setData("<!DOCTYPE html>\n"
                + "<html>\n" + "<head>\n" + "<title>" + per.getFname() +"'s Buisness Card"+ "</title>\n"
                +"<style></style>" + "</head>\n" + "<body>\n");
        
        end.setData("</body>\n" + "</html>");
        
        list.add(begin);
        
        coverhtml.setPer(per);
        coverhtml.setEmp(emp);
        list.add(coverhtml);

        list.add(end);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).createContent();
            String data = list.get(i).getHtmlContent();
            outputStream.println(data);
        }

        if (outputStream != null) {
            outputStream.close();
        }
      
        HTML2PDF test = new HTML2PDF(emp.getEmployrName()+"Cover.html", emp.getEmployrName()+"Cover.pdf");
        test.convert2Pdf(test.getHtmlFileName(), test.getPdfFileName());
        
    }
}
