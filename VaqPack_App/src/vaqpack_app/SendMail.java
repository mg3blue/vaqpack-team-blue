package vaqpack_app;


import java.io.File;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail{
    
    //Do Not modify the following variables --------------------------
    final protected String email =  "vaqpackblue@gmail.com";
    final protected String username = "vaqpackblue@gmail.com";
    final protected String password = "v4qp4ckb1u3";
    final protected String host = "smtp.gmail.com";
    final protected String port  = "465";
    //-----------------------------------------------------------------
    
    
    //User Defined Variables
    private String to;
    private String title;
    private String body;
    private File attachment = new File("");
    
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }


    //DO NOT modify the following Function--------------------------------------------
    private static class SMTPAuthenticator extends Authenticator
    {
    
     public PasswordAuthentication getPasswordAuthentication()
        {
         return new PasswordAuthentication("vaqpackblue@gmail.com", "v4qp4ckb1u3");
        }
    }
    //------------------------------------------------------------------------------

    public void send() throws MessagingException{


        Properties properties = new Properties();
        properties.put("mail.smtp.user", email);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.debug", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", port);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        
        //Initiating Session with Google SNMP
        SMTPAuthenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(properties, auth);
        session.setDebug(true);

        //Instantiating the message object
        MimeMessage msg = new MimeMessage(session);
        msg.setSubject(title);
        msg.setFrom(new InternetAddress(email));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(body);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        if (attachment.exists()) {
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(getAttachment().getAbsolutePath());
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(getAttachment().getName());
            multipart.addBodyPart(messageBodyPart);
        }
        
        msg.setContent(multipart);
         
        Transport transport = session.getTransport("smtps");
        transport.connect(host, 465, username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    }
}