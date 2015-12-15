/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

/**
 *
 * @author mg3Blue
 */
public class BusinessCardHTML extends ResumeElement{
    
    private Personal per;
    
    @Override
    public void createContent()
    {
        StringBuilder finalString = new StringBuilder();
        finalString.append("<table>\r\n<tr>\r\n<td>\r\n");
        finalString.append("<img src=\"https://portal.utpa.edu/utpa_main/daa_home/ogs_home/ogs_web/UTRGV-FullColor-Med.png\""
                +" alt=\"UTRGV\" style=\"width:150px;height:40px;\">\r\n");
        finalString.append("</td><td>");
        finalString.append("<h2 style = \"padding: 10px;\" align = \"right\">"+per.getFname()+" "+ per.getLname() +"</h2>");
//        finalString.append("<h3 align = \"right\">"+"Degree Title" +"</h3>");
//        finalString.append("<h2>Year Graduating</h3>");
        finalString.append("</td></tr><tr><td>");
        finalString.append("<p>Email: "+per.getEmail()+"<br>");
//        finalString.append("Adress: 123 asdf Dr <br>");
//        finalString.append("City, State, Zip <br>");
        finalString.append(per.getPhone() + "</p>\r\n");
        finalString.append("</td></tr></table>");
        this.setHtmlData(finalString.toString());
    }
    @Override
    public String getHtmlContent()
    {
        return this.getHtmlData();
    }

    /**
     * @return the per
     */
    public Personal getPer() {
        return per;
    }

    /**
     * @param per the per to set
     */
    public void setPer(Personal per) {
        this.per = per;
    }


}