package cn.cxnxs.test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailDemo {
    public static void main(String[] args) {
        final String username = "782399171@qq.com";
        final String password = "ayhvpzwmgtjjbgah";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("782399171@qq.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("782399171@qq.com"));
            message.setSubject("Test Email");
            message.setText("This is a test email sent from Java.");
            Transport.send(message);
            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
