package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.model.Runner;

public interface RunnerService {
	
	ArrayList<Runner>selectAll();
	boolean insertNewRunner(Runner runner);		
	boolean autorizeRunner(String email, String password);		
	Runner selectById(int id);				
	boolean updateRunnerById(Runner runner, int id);	
	Runner findByNameAndSurname(String name, String surname);		
	Runner findByEmail(String email);
	void sendRegistrationEmail(String email);
	public void sendEmailWithAttachment(String email);
	
}
