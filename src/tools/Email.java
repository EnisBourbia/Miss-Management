package tools;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

public class Email {
    private String emailLogin = "miss.management.meetings@gmail.com";
    private String emailPassword = "123321H!";

     public String getEmailLogin(){
         return this.emailLogin;
     }

     public String getEmailPassword(){
         return this.emailPassword;
     }

    public void sendFromGMail(String email, String password, ArrayList<String> recipient, String subject, String message) {

        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", email);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage mail = new MimeMessage(session);

        try {
            for(int i = 0; i < recipient.size(); i++) {
                mail.addRecipient(RecipientType.BCC, new InternetAddress(recipient.get(i)));
            }
            mail.setSubject(subject);
            mail.setText(message);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, email, password);
            transport.sendMessage(mail, mail.getAllRecipients());
            transport.close();

        } catch(Exception e) {
            System.out.println(e);
        }

    }
}



