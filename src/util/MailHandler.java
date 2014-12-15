/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author orcl
 */
public class MailHandler {

    private void sendVerificationCodeToEmail(String email) throws Exception {
        try {
            final String emailusername = "mohamed.ibrahim.iti@gmail.com";
            final String emailpassword = "mcit123456";

            Properties props = new Properties();

            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.imap.ssl.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            /*
             props.put("mail.smtp.host", "smtp.gmail.com");
             props.put("mail.smtp.socketFactory.port", "465");
             props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
             props.put("mail.smtp.auth", "true");
             props.put("mail.smtp.port", "465");*/

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(emailusername, emailpassword);
                        }
                    });

            Message message = new MimeMessage(session);

            //message.setFrom(new InternetAddress("mohamed.ibrahim.iti@gmail.com"));
            message.setFrom(new InternetAddress("mohamed.ibrahim.iti@gmail.com", "NoReply"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Verification Code");
            message.setText("Verification Code Email: "
                    + "\n\n No spam to my email, please!"
                    + "\nYour verification code is 5555555555");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {

           // new EmailWay().sendVerificationCodeToEmail("mibrahim.iti@gmail.com");
            /*
             System.out.println("SimpleEmail Start");
	         
             //String smtpHostServer = "smtp.journaldev.com";smtp.gmail.com
             //String emailID = "pankaj@journaldev.com";
             String smtpHostServer = "smtp.gmail.com";
             String emailID = "mibrahim.iti@gmail.com";
	         
             Properties props = System.getProperties();
	 
             props.put("mail.smtp.host", smtpHostServer);
	 
             Session session = Session.getInstance(props, null);
	         
             EmailWay.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");*/
            /*
             final String fromEmail = "mohamed.ibrahim.iti@gmail.com"; //requires valid gmail id
             final String password = "mcit123456"; // correct password for gmail id
             final String toEmail = "mibrahim.iti@gmail.com"; // can be any email id
	         
             System.out.println("TLSEmail Start");
             Properties props = new Properties();
             props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
             props.put("mail.smtp.port", "587"); //TLS Port
             props.put("mail.smtp.auth", "true"); //enable authentication
             props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
	         
             //create Authenticator object to pass in Session.getInstance argument
             Authenticator auth = new Authenticator() {
             //override the getPasswordAuthentication method
             protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(fromEmail, password);
             }
             };
             Session session = Session.getInstance(props, auth);
	         
             EmailWay.sendEmail(session, toEmail,"Sending Email Test", "Verification Code Email: "
             + "\n\n No spam to my email, please!"
             + "\nYour verification code is 5555555555");*/

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void sendEmail(Session session, String toEmail, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("mohamed.ibrahim.iti@gmail.com", "NoReply"));

            msg.setReplyTo(InternetAddress.parse("mohamed.ibrahim.iti@gmail.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
