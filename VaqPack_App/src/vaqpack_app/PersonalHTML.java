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
public class PersonalHTML extends ResumeElement{
    
    private Personal per;
    
    @Override
    public void createContent()
    {
        StringBuilder finalString = new StringBuilder();
        finalString.append("<h1> "+ getPer().getFname() + " " + getPer().getLname() + "</h1>"+ "\r\n");
        finalString.append("<h3> "+ getPer().getPhone() + "</h3>"+ "\r\n");
        finalString.append("<h3> "+ getPer().getEmail() + "</h3>"+ "\r\n");
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
