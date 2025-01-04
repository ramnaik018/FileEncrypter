//package service;
//
//public class sendOTPService {
//    public static void sendOTP(String email,)
//}

package service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendOTPService {

    public static void sendOTP(String email, String otp) {
        // SMTP server configuration
        final String senderEmail = "bobbilikrishna993@gmail.com";  // Replace with your email
        final String senderPassword = "lxemismzxgvkefsp";  // Replace with your email password
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");  // For Gmail
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Your OTP Code");
            message.setText("Your One-Time Password (OTP) is: " + otp);

            // Send the email
            Transport.send(message);
            System.out.println("OTP sent successfully to " + email);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}