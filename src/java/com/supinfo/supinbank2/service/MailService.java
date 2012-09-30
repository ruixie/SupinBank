/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.service;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Thibault
 */
@Stateless
public class MailService {
    
    @Asynchronous
    public Future<Boolean> sendToUser(String email, String password){
        
        String host = "smtp.gmail.com";
        int port = 587;
        final String username = "javaProjectSupinbank@gmail.com";
        final String password_smtp = "javaProjectSupinbank";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);
        props.put("mail.from", "javaProjectSupinbank@gmail.com");
        
        Session session = Session.getDefaultInstance(props, 
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password_smtp);
                    }
                });
        
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom();
            msg.setRecipients(Message.RecipientType.TO, email);
            msg.setSubject("Confirmation Registration");
            msg.setSentDate(new Date());
            msg.setText("Votre compte a été créé. Vos identifiants sont : login : " + email + " mot de passe : " + password);
            
            Transport.send(msg);
            System.out.println("Send success");
            
        }catch (MessagingException mex){
            System.out.println("Send failed, exception : " + mex);
        }
        
        return new AsyncResult<Boolean>(true);
    }
}
