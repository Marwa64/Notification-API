package com.module.notification.notificationData;

import java.util.Properties;
import java.util.Random;

import javax.mail.*;

public class SendEmail implements SendNotification{
	@Override
	public boolean send(Notification notification) {
		Random rn = new Random();
		int max = 2, min = 1;
		int num = rn.nextInt(max - min + 1) + min;
		if (num == 1) {
			return true;
		}
		return false;
	}
	/*public boolean send(Notification notification) {
		Properties properties = new Properties();    
		properties.put("mail.smtp.host", "smtp.gmail.com");    
		properties.put("mail.smtp.auth", "true");    
		properties.put("mail.smtp.port", "587");    
		properties.put("mail.smtp.starttls.enable", "true");

		//Sender credentials
		String email = "notifications.system.module@gmail.com";
		String password = "notsys2020";

		//get Session   
		Session session = Session.getDefaultInstance(properties,    
				new javax.mail.Authenticator() {    
			protected PasswordAuthentication getPasswordAuthentication() {    
				return new PasswordAuthentication(email, password);  
			}    
		});    
		//compose message    
		Message msg = null;
		try {
			msg = prepareMessage(session, notification.receiver, notification);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}  
		try {
			Transport.send(msg);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
	//this will prepare the message to be send
	private static Message prepareMessage(Session session, String recipient, Notification notification) throws AddressException, MessagingException {
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Notification System <notifications.system.module@gmail.com>"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));    
			message.setSubject(notification.subject);    
			message.setText(notification.message, "utf-8", "html");    
			return message;
		} catch (Exception e) {
			System.out.println(e);
			//Logger.getLogger(JavaMailUtil.class.getName().log(Level.SEVERE, null, e));
		}
		return null;
	}*/

}