package jsmSystem;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class Reports {

    public static void main(String[] args) {

        final String username = "jewelleryshopmanagement07@gmail.com";
        final String password = "JsmSystem@07";

        final String from = "jewelleryshopmanagement07@gmail.com";
        final String to = "19eucb033@skcet.ac.in";

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Authenticator a =new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        Session session = Session.getInstance(props, a);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject("Test mail");
            message.setText("Hi this is Test mail from JAVA mail");

            Transport.send(message);

            System.out.println("Done");

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}