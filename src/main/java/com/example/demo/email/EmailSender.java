package com.example.demo.email;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manager;


@Service
public class EmailSender {


    private JavaMailSender javaMailSender;
    /**
	 * 
	 * @param javaMailSender
	 */
    
    //@param javaMailSender
    
    @Autowired
	public EmailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
    /**
	 * This function is used to send mail without attachment.
	 * @param manager
	 * @throws MailException
	 */
    
    
    	
    public void sendEmail(String email) throws MailException  {
    		 
    		//send email
    	 
    	SimpleMailMessage mail = new SimpleMailMessage();
    	mail.setTo(email);
    	mail.setSubject("Registration to Marathon Tool");
    	mail.setText("Your registration to Marathon Tool completed succesfully.");
    	javaMailSender.send(mail);
    	 
    	}
    

	/**
	 * This fucntion is used to send mail that contains a attachment.
	 * 
	 * @param user
	 * @throws MailException
	 * @throws MessagingException
	 */
 
    public void sendEmailWithAttachment(String email) throws MailException, MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(email);
		helper.setSubject("Testing Mail API with Attachment");
		helper.setText("Please find the attached document below.");

		ClassPathResource classPathResource = new ClassPathResource("/images/website.jpg");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(mimeMessage);
	}
}


