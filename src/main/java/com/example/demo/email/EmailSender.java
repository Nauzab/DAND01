package com.example.demo.email;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manager;


@Service
public class EmailSender {

    private JavaMailSender JavaMailSender;
    	
    	public void sendEmail(Manager manager)  {
    		 
    		//send email
    	 
    		SimpleMailMessage mail = new SimpleMailMessage();
    		mail.setTo(manager.getEmail());
    	
    		mail.setFrom("dandboot@gmail.com");
    		mail.setSubject("test");
    		mail.setText("test");
     
    	 
    		
    		JavaMailSender jsd =getJavaMailSender();
    		jsd.send(mail);
    	}
    	 
    	public JavaMailSender getJavaMailSender() {
    	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	    mailSender.setHost("smtp.gmail.com");
    	    mailSender.setPort(587);

    	    mailSender.setUsername("dandboot@gmail.com");
    	    mailSender.setPassword("bootdand");

    	    Properties props = mailSender.getJavaMailProperties();
    	    props.put("mail.transport.protocol", "smtp");
    	    props.put("mail.smtp.auth", "true");
    	    props.put("mail.smtp.starttls.enable", "true");
    	    props.put("mail.debug", "true");

    	    return mailSender;
    	}
    }
