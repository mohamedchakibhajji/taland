/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Chekib
 */
  import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   


public class mail {
  

   
         public static void main(String mailFrom, String password, String mailTo, String subject, String message) throws Exception
    {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
  // LocalDateTime now = LocalDateTime.now();  
 //  System.out.println(dtf.format(now));  
   //String time = dtf.format(now);
  
     
   //char heure =  time.charAt(0);
   //char heure1 =  time.charAt(1);
   // int wa9t = Character.getNumericValue(heure)+Character.getNumericValue(heure1);
   //{
     //  if ((wa9t < 07 ) || (wa9t > 18))
      // {
          new Email(mailFrom, password, mailTo, subject, message);
       //}
       //else 
        //   new Email("mohamedamine.mbarki@esprit.tn", "amine20132013", "mohamedchakib.hajji@esprit.tn", "Vous Etes Abonné A Une Nouvelle Compétition", "<h1> Bonjour, \n </h1> <h1>Vous Etes Abonné A Une Nouvelle Compétition , Vous Recevrez Un SMS Pour Vous Rappeler du compétition avant d'un jour du lancement\n </h1> <h1> ,Bonne Chance et Bon Courage </h1>"); // Send a message

   }
        
        
    
}

class Email
{
    private String host, port = "587";

    Email(String mailFrom, String password, String mailTo, String subject, String message) throws Exception
    {
       
            this.host = "smtp.gmail.com";
       

        sendEmail(host, port, mailFrom, password, mailTo, subject, message, null);
    }

    private void sendEmail(String host, String port, final String userName, final String password, String toAddress, String subject, String message, String[] attachFiles) throws Exception
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);

        Authenticator auth = new Authenticator()
        {
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        if (attachFiles != null && attachFiles.length > 0)
        {
            for (String filePath : attachFiles)
            {
                MimeBodyPart attachPart = new MimeBodyPart();

                try
                {
                    attachPart.attachFile(filePath);
                }
                finally
                {
                    multipart.addBodyPart(attachPart);
                }
            }
        }
        msg.setContent(multipart);

        Transport.send(msg);
    }

}
