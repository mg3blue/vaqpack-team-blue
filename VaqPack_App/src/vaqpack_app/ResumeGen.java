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

    PrintWriter outputStream = null;
    ArrayList<ResumeElement> list = new ArrayList<>();

    public void generateHTMLPage(Personal per,  ArrayList<Experience> exp, ArrayList<Education> edu, ArrayList<String> skill, String theme) throws IOException {
        String filename = per.getFname()+"Resume.html";
        outputStream = new PrintWriter(new FileWriter(filename));
        ResumeElement begin = new ResumeElement();
        ResumeElement style = new ResumeElement();
        ResumeElement end = new ResumeElement();
        Themes th = new Themes();
        
        PersonalHTML perhtml = new PersonalHTML();
        ExperienceHTML exphtml = new ExperienceHTML();
        EducationHTML eduhtml = new EducationHTML();
        SkillHTML skillhtml = new SkillHTML();

        begin.setData("<!DOCTYPE html>\r\n"
                + "<html>\r\n" + "<head>\r\n" + "<title>" + per.getFname() +"'s Resume"+ "</title>\r\n");
        
        if("Theme 1".equals(theme)){
            style.setData(th.rTheme1());
        }
        if("Theme 2".equals(theme)){
            style.setData(th.rTheme2());
        }
        if("Theme 3".equals(theme)){
            style.setData(th.rTheme3());
        }
        if("Theme 4".equals(theme)){
            style.setData(th.rTheme4());
        } 
        
        end.setData("</body>\r\n" + "</html>");

//        list.add(0, begin);
//        list.add(end);
        
        list.add(begin);
        list.add(style);
        
        if(per.getLname().isEmpty()){
        } else {
            perhtml.setPer(per);
            list.add(perhtml);
        }
        
        if(!exp.isEmpty()){
            exphtml.setExperienceElements(exp);
            list.add(exphtml);
        }
        
        if(!edu.isEmpty()){
            eduhtml.setEducationElements(edu);
            list.add(eduhtml);
        }
        
        if(!skill.isEmpty()){
            skillhtml.setSkillElements(skill);
            list.add(skillhtml);
        }
        
        list.add(end);
             
        

        for (int i = 0; i < list.size(); i++) {
            list.get(i).createContent();
            String data = list.get(i).getHtmlContent();
            outputStream.println(data);
        }

        if (outputStream != null) {
            outputStream.close();
        }
        
        HTML2PDF test = new HTML2PDF(filename, per.getFname()+"Resume.pdf");
        test.convert2Pdf(test.getHtmlFileName(), test.getPdfFileName());
        
        
    }
}
