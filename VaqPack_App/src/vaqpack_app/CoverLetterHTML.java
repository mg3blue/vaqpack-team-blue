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
public class CoverLetterHTML extends ResumeElement{
    
    private Personal per;
    private Employer emp;
    
    @Override
    public void createContent()
    {
        StringBuilder finalString = new StringBuilder();
        finalString.append("<p>" + per.getFname() + " " + per.getLname()+"<br></br>\r\n");
        finalString.append(per.getPhone() + "<br></br>\r\n");
        finalString.append(per.getEmail() + "<br></br></p>\r\n");
        
        finalString.append("<p>Employer " + emp.getEmployrName()+",<br></br>\r\n");
        finalString.append("I am writing in response to the opening for the position " 
                + emp.getPositionname() + " at " + emp.getCompanyName() 
                + ". I am currently a senior studying at the University of Texas Rio Grande Valley" 
                + " and I will be graduating soon. </p>\r\n");
        finalString.append("<p></p><p>The Resume provided along with this document gives a detailed" 
                + " overview of the skills that I've acquired through my years of education " 
                + "and work experience.</p>\r\n");
        finalString.append("<p>I look forward to meeting you as I believe I can be a great "
                + "contribution to your company. I can be contacted via the E-mail provided "
                + "to arrange an interview at your earliest convenience. " 
                + "Thank you for taking the time to consider me.</p><p></p>");
        finalString.append("<p>Sincerely,</p>\r\n");
        finalString.append("<p>" + per.getFname() + " " + per.getLname() + "</p>");
        
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

    /**
     * @return the emp
     */
    public Employer getEmp() {
        return emp;
    }

    /**
     * @param emp the emp to set
     */
    public void setEmp(Employer emp) {
        this.emp = emp;
    }


}