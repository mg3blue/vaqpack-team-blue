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
public class ResumeElement {
    
    private String data;
    private String htmlData;
    private String beginTag;
    private String endTag;
    public void createContent()
    {
    }
    public String getHtmlContent()
    {
        return getData();
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the beginTag
     */
    public String getBeginTag() {
        return beginTag;
    }

    /**
     * @param beginTag the beginTag to set
     */
    public void setBeginTag(String beginTag) {
        this.beginTag = beginTag;
    }

    /**
     * @return the endTag
     */
    public String getEndTag() {
        return endTag;
    }

    /**
     * @param endTag the endTag to set
     */
    public void setEndTag(String endTag) {
        this.endTag = endTag;
    }

    /**
     * @return the htmlData
     */
    public String getHtmlData() {
        return htmlData;
    }

    /**
     * @param htmlData the htmlData to set
     */
    public void setHtmlData(String htmlData) {
        this.htmlData = htmlData;
    }
    
}
