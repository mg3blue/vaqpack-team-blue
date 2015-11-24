package sendemail;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMailSSL{
    
    private static class SMTPAuthenticator extends Authenticator
    {
    
     public PasswordAuthentication getPasswordAuthentication()
        {
         return new PasswordAuthentication("<email>", "<password>");
        }
    }

    public static void main(String[] args) throws MessagingException{
        String email = "<email>";
        String username = "<email";
        String password = "<password>";
        String host = "smtp.gmail.com";
        String port  = "465";
        String to = "<recipent>";
        String title = "Testing";
        String body = "Testing Email.";

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

        SMTPAuthenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(properties, auth);
        session.setDebug(true);

        MimeMessage msg = new MimeMessage(session);
        msg.setText(body);
        msg.setSubject(title);
        msg.setFrom(new InternetAddress(email));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        Transport transport = session.getTransport("smtps");
        transport.connect(host, 465, username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
        }
}