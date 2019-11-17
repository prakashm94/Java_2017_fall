/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author sonal
 */
public class Validator {
    public static String generateHash(String password) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(password.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (byte a :hashedBytes) 
                        {
				byte b = a;
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}
    public static void sendMessage(String emailId) throws SendFailedException {
       // Recipient's email ID needs to be mentioned.
       String to = emailId;
        System.out.println(emailId);
       String from = "poojapingle16";
       String pass = "16july1992";
       // Assuming you are sending email from localhost
       // String host = "192.168.0.16";

      // Get system properties
       Properties properties = System.getProperties();
       String host = "smtp.gmail.com";

      properties.put("mail.smtp.starttls.enable", "true");

      properties.put("mail.smtp.ssl.trust", host);
       properties.put("mail.smtp.user", from);
       // properties.put("mail.smtp.password", pass);
       properties.put("mail.smtp.port", "587");
       properties.put("mail.smtp.auth", "true");

      // Setup mail server
       // properties.setProperty("mail.smtp.host", host);
       //  properties.put("mail.smtp.starttls.enable", "true");
       // Get the default Session object.
       Session session = Session.getDefaultInstance(properties);
//       final PasswordAuthentication auth = new PasswordAuthentication(from, pass);
//Session session = Session.getDefaultInstance(properties, new Authenticator() {
//    @Override
//    protected PasswordAuthentication getPasswordAuthentication() { return auth; }
//});
       //Session session = Session.getInstance(properties);
      try {
           // Create a default MimeMessage object.
           MimeMessage message = new MimeMessage(session);

          // Set From: header field of the header.
           message.setFrom(new InternetAddress(from));

          // Set To: header field of the header.
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

          // Set Subject: header field
           message.setSubject("Opioid Managesmtpment");
           message.setText("qeqwe");
           // Send message
           Transport transport = session.getTransport("smtp");
           transport.connect(host, from, pass);
           transport.sendMessage(message, message.getAllRecipients());
           transport.close();
           System.out.println("Sent message successfully....");
       } catch (MessagingException mex) {
           mex.printStackTrace();
           JOptionPane.showMessageDialog(null, "Invalid email id");
       } 
   }
    public static void senMessage(String contact) throws SendFailedException {
       // Recipient's email ID needs to be mentioned.
       String to = contact;
       System.out.println(contact);
       String from = "poojapingle16";
       String pass = "16july1992";
       // Assuming you are sending email from localhost
       // String host = "192.168.0.16";

      // Get system properties
       Properties properties = System.getProperties();
       String host = "smtp.gmail.com";

      properties.put("mail.smtp.starttls.enable", "true");

      properties.put("mail.smtp.ssl.trust", host);
       properties.put("mail.smtp.user", from);
       // properties.put("mail.smtp.password", pass);
       properties.put("mail.smtp.port", "587");
       properties.put("mail.smtp.auth", "true");

      // Setup mail server
       // properties.setProperty("mail.smtp.host", host);
       //  properties.put("mail.smtp.starttls.enable", "true");
       // Get the default Session object.
       Session session = Session.getDefaultInstance(properties);
//       final PasswordAuthentication auth = new PasswordAuthentication(from, pass);
//Session session = Session.getDefaultInstance(properties, new Authenticator() {
//    @Override
//    protected PasswordAuthentication getPasswordAuthentication() { return auth; }
//});
       //Session session = Session.getInstance(properties);
      try {
           // Create a default MimeMessage object.
           MimeMessage message = new MimeMessage(session);

          // Set From: header field of the header.
           message.setFrom(new InternetAddress(from));

          // Set To: header field of the header.
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

          // Set Subject: header field
           message.setSubject("Opioid Managesmtpment");
           message.setText("qeqwe");
           // Send message
           Transport transport = session.getTransport("smtp");
           transport.connect(host, from, pass);
           transport.sendMessage(message, message.getAllRecipients());
           transport.close();
           System.out.println("Sent message successfully....");
       } catch (MessagingException mex) {
           mex.printStackTrace();
           JOptionPane.showMessageDialog(null, "Invalid email id");
       } 
   }
    
     public static void onlyString(KeyEvent evt, JTextField field) {
          char c = evt.getKeyChar();
        if (!((c >= 'A') && (c <= 'Z') || (c >= 'a') && (c <= 'z') || (c==evt.VK_SPACE) || (c==evt.VK_CAPS_LOCK) || (c==evt.VK_SHIFT)||
            (c == evt.VK_BACK_SPACE) ||
            (c == evt.VK_DELETE))) {

        JOptionPane.showMessageDialog(null, "Enter Alphabets only");
       field.setText("");
        }
     }
     public static void onlyInteger(KeyEvent evt, JTextField field) {
          char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')||
            (c == evt.VK_BACK_SPACE) ||
            (c == evt.VK_DELETE))) {

        JOptionPane.showMessageDialog(null, "Enter Integers only");
       field.setText("");
        }
     }
     
     public static Boolean chkPass(JTextField pass,JLabel label)
     {
         String password = pass.getText();
         label.setForeground(Color.red);
         boolean valid = true;
         
             if(pass.getText().equals(""))
                {
                    label.setText("Please enter a password.");
                        pass.setBorder(new LineBorder(Color.red));
                        valid = false;
                    
                }
                if (password.length() > 15 || password.length() < 6)
                {
                        label.setText("Password should be less than 15 and more than 6 characters in length.");
                        pass.setBorder(new LineBorder(Color.red));
                        valid = false;
                }
                
            
                
                String upperCaseChars = "(.*[A-Z].*)";
                if (!password.matches(upperCaseChars ))
                {
                        label.setText("Password should contain atleast one upper case alphabet");
                        pass.setBorder(new LineBorder(Color.red));
                        valid = false;
                }
                String lowerCaseChars = "(.*[a-z].*)";
                if (!password.matches(lowerCaseChars ))
                {
                        label.setText("Password should contain atleast one lower case alphabet");
                        pass.setBorder(new LineBorder(Color.red));
                        valid = false;
                }
                String numbers = "(.*[0-9].*)";
                if (!password.matches(numbers ))
                {
                        label.setText("Password should contain atleast one number.");
                        pass.setBorder(new LineBorder(Color.red));
                        valid = false;
                }
                String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
                if (!password.matches(specialChars ))
                {
                        label.setText("Password should contain atleast one special character");
                        pass.setBorder(new LineBorder(Color.red));
                        valid = false;
                }
                if (valid)
                {       
                        label.setText("Password is valid.");
                        label.setForeground(Color.green);
                        pass.setBorder(new LineBorder(Color.black));
                }
                return valid;
        }

    
}
