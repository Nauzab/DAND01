package com.example.demo.email;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Manager;

@SpringBootApplication
@ComponentScan ({"com.example"})
@Controller
public class SimpleEmailExampleController {
	
	@Autowired
    private EmailSender notificationService;
 
   // @Autowired(required=true)
  //  private Manager manager;
    
    /**
	 * 
	 * @return
	 */
    
    @GetMapping("/send-mail")
    public String sendSimpleEmail() {
    	Manager manager = new Manager("Dand", "Boot", "bootdand", "dandboot@gmail.com");
 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
         
        message.setTo(manager.getEmail()) ;
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");
        
        try {
        	notificationService.sendEmail(manager.getEmail());
        } catch (MailException m) {
        	System.out.println(m);
        }
 
 
        return "send-mail";
    }
    /**
	 * 
	 * @return
	 * @throws MessagingException
	 */
    @GetMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException {

		/*
		 * Creating a User with the help of User class that we have declared and setting
		 * Email address of the sender.
		 */
		Manager manager = new Manager("Dand", "Boot", "bootdand", "dandboot@gmail.com"); //Receiver's email address

		/*
		 * Here we will call sendEmailWithAttachment() for Sending mail to the sender
		 * that contains a attachment.
		 */
		try {
			notificationService.sendEmailWithAttachment(manager.getEmail());
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "send-mail-attachment";
	}
}


