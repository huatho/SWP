/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {
    //generate vrification code
    public String getRandom(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    //send email to the user email
    public boolean sendEmail(Email email) {
        boolean test = false;
                                


        String toEmail = email.getEmail();
        String code = email.getCode();
        String fromEmail = "nguyenhuatho123@gmail.com";
        String password = "czgn fdwm kccy pcxf";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
//            pr.put("mail.smtp.host", "smtp.gmail.com");
//            pr.put("mail.smtp.port", "587");
//            pr.put("mail.smtp.auth", "true");
//            pr.put("mail.smtp.starttls.enable", "true");
//            pr.put("mail.smtp.socketFactory.port", "587");
//            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "465");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.ssl.protocols", "TLSv1.2");
            pr.put("mail.smtp.socketFactory.port", "465");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
            

 
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
       
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            
                    

            //set email message details
            Message mess = new MimeMessage(session);

                                                
    		//set from email address
            mess.setFrom(new InternetAddress(fromEmail));
    		//set to email address or destination email address
            mess.setRecipient(RecipientType.TO, new InternetAddress(toEmail));
            mess.setSubject("Verify Email");
            mess.setContent("This is verify code: "+code,"text/plain");
                        
            System.out.println(fromEmail + " " + toEmail+ " " + code);
            Transport.send(mess);
            System.out.println("7777777777777777");
            
            test=true;
            
            
        } catch (MessagingException e) {
            System.out.println(e);
        }
        return test;
    }
}

    