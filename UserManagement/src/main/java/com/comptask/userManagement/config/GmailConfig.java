package com.comptask.userManagement.config;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;

import jakarta.mail.Authenticator;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Configuration
public class GmailConfig {

	public boolean sendMail(String to, String from, String subject, String text) {
		
		boolean mailStatus = false;
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		
		String userName= "maheshtawade2308";
		String Password= "srrm motz npkb dvmy";
		
		Session instance = Session.getInstance(properties, new Authenticator() {
			
			protected jakarta.mail.PasswordAuthentication getPasswordAuthentication(){
				
				return new jakarta.mail.PasswordAuthentication(userName, Password);
			}
			
		});
		
		try {
			MimeMessage mimeMessage = new MimeMessage(instance);
			
			mimeMessage.setRecipient(RecipientType.TO, new InternetAddress(to));
			// RecipientType.TO means mail will be sent to only the reciepent
			// cc means one copy to the team lead
			// BCC means sender doesnt know that to whome the message is being sent
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(text);
			
			Transport.send(mimeMessage);
			mailStatus = true;	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mailStatus;
	}
}
