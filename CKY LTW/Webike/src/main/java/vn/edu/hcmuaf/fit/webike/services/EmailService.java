package vn.edu.hcmuaf.fit.webike.services;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class EmailService {
    public static void sendEmail(String to, String subject, String content) {
        final String username = "22130248@st.hcmuaf.edu.vn";
        final String password = "aeem ipir bbjr zpjv";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            System.out.println("Email gửi đến: " + to);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("gửi error: " + to);
            throw new RuntimeException(e);
        }
    }
    }
