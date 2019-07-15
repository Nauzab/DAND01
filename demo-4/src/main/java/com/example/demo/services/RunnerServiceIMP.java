package com.example.demo.services;

import java.util.ArrayList;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.email.EmailSender;
import com.example.demo.model.Runner;
import com.example.demo.repo.RunnerRepo;

@Service
public class RunnerServiceIMP implements RunnerService {
	

	@Autowired
	RunnerRepo runnerrepo;
	
	@Autowired
    private EmailSender notificationService;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public ArrayList<Runner> selectAll() {
		ArrayList<Runner> run = new ArrayList<Runner>();
		for (Runner r : runnerrepo.findAll()) {
			run.add(r);
		}

		return run;
	}

	@Override
	public boolean insertNewRunner(Runner runner) {

		if (runner.getId_r() != 0 || runnerrepo.existsById(runner.getId_r())) {
			return false;
		} else {
       runnerrepo.save(runner);
			return true;
		}
	}

	@Override
	public boolean autorizeRunner(String email, String password) {

		Runner runner = runnerrepo.findByEmailAndPassword(email, password);
		if (runner != null) {
			return true;

		} else {

			return false;
		}
	}

	@Override
	public Runner selectById(int id) {
		Runner runner = runnerrepo.findById(id).get();

		if (runner == null) {
			return null;
		} else {
			return runner;
		}

	}

	@Override
	public boolean updateRunnerById(Runner runner, int id) {
		System.out.println("INCOMING ----" + id);

		if (runner != null && runnerrepo.existsById(id)) {
			Runner runnerTemp = runnerrepo.findById(id).get();
			System.out.println("TEMP----" + runnerTemp.getId_r());
			runnerTemp.setName(runner.getName());
			runnerTemp.setSurname(runner.getSurname());
			runnerTemp.setSex(runner.getSex());

			return true;
		} else
			return false;

	}

	@Override
	public Runner findByNameAndSurname(String name, String surname) {
		Runner runner = runnerrepo.findByNameAndSurname(name, surname);
		
		if(runner!=null) {
			return runner;
		}else {
		
		
		return null;
	}

}
	
@Override
	public Runner findByEmail(String email) {
		Runner runner = runnerrepo.findByEmail(email);
		
		if(runner!=null) {
			return runner;
		}else {
			return null;
		}
		
	}

	@Override
	public void sendRegistrationEmail(String email) {
		EmailSender sendEmailToSender = new EmailSender(javaMailSender);
		try {
			sendEmailToSender.sendEmail(email);
		} catch (MailException e) {
			e.printStackTrace();
		}
	}
			
			
		
	@Override
		public void sendEmailWithAttachment(String email) {
			EmailSender sendEmailToSender = new EmailSender(javaMailSender);
			try {
				sendEmailToSender.sendEmailWithAttachment(email);
			} catch (MailException e) {
				e.printStackTrace();
			} catch (MessagingException m) {
				m.printStackTrace();
		}
}
}