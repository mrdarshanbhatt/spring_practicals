package com.mvc.service;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.factory.Design;
import com.mvc.factory.Email;
import com.mvc.factory.Keyword;
import com.mvc.repository.UserRepository;

@Service
public class SendMailService {

	@Autowired
	UserRepository userRepo;

	public void sendMail(Map<String, Object> emailMap) {

		try {
			// outgoing message information
			Properties properties = new Properties();
			properties.put("mail.smtp.host", Email.HOST);
			properties.put("mail.smtp.port", Email.PORT);
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");

			Session session = Session.getInstance(properties, null);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Email.EMAIL_ID));
			message.setRecipient(RecipientType.TO, new InternetAddress(emailMap.get(Keyword.EMAIL).toString()));

			message.setSubject(emailMap.get(Keyword.SUBJECT).toString());
			message.setText(emailMap.get(Keyword.MESSAGE).toString());
			message.setContent(Design.ACCOUNT_CREATE, "text/html");

			// Send Email
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", Email.EMAIL_ID, Email.PASSWORD);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {

		}
	}

}
