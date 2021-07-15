package com.fedex.weightbalance.batch.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	private final String FROM = "WB_Scheduler@fedex.com";
	
	
	public void sendMessage(String hostname, String recipients, String msg, String subject){
		try{
			String host = (hostname == null) ? "localhost" : hostname;
			
			String[] recToken = recipients.split(",");
			
			Properties props = System.getProperties();
			props.setProperty("mail.smtp.host", host);
			Session session = Session.getDefaultInstance(props);
		
			MimeMessage email = new MimeMessage(session);
			email.setFrom(new InternetAddress(FROM));
			for (String to : recToken){
				email.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			}
			
			email.setSubject(subject);
			email.setText(msg);
			
			Transport.send(email);
			System.out.println("Email sent");
		}catch (Exception e1){
			e1.printStackTrace();
		}
	}
}
