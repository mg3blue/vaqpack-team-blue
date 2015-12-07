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
public class Personal extends ResumeElement{
    
    private String name;
    private String email;
    private String phone;
    
    @Override
    public void createContent()
    {
        StringBuilder finalString = new StringBuilder();
        finalString.append("<h3> "+ this.getName() + "</h3>"+ "\n");
        finalString.append("<h3> "+ this.getPhone() + "</h3>"+ "\n");
        finalString.append("<h3> "+ this.getEmail() + "</h3>"+ "\n");
        this.setHtmlData(finalString.toString());
    }
    @Override
    public String getHtmlContent()
    {
        return this.getHtmlData();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
