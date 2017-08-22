// { autofold
package com.example;

// import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Main {

public static void main(String[] args) throws Exception {

// }

String from = "sender@gmail.com";
String password = "sender's password";
String to = "recipient@gmail.com";

Properties properties = new Properties();
properties.put("mail.smtp.host", "smtp.gmail.com");
properties.put("mail.smtp.port", 587);
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.starttls.enable", "true");

Session session = Session.getInstance(properties, new Authenticator() {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(from, password);
    }
});

MimeMessage message = new MimeMessage(session);
message.setFrom(new InternetAddress(from));
message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
message.setSubject("Mail subject");
message.setText("Content of the mail");

Transport.send(message);

//{ autofold

}

}
//}
