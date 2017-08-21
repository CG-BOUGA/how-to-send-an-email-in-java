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
String to = "recipient@gmail.com";

String host = "smtp.gmail.com";

Properties properties = new Properties();
properties.put("mail.smtp.host", host);
// TODO: port? TLS?
properties.put("mail.smtp.auth", "true");
properties.put("mail.user", "my-username");
properties.put("mail.password", "my-password");

Session session = Session.getInstance(properties);

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
