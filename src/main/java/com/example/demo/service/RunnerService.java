package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.Runner;

public interface RunnerService {
	
	ArrayList<Runner>selectAll();
	boolean insertNewRunner(Runner runner);		
	boolean autorizeRunner(String email, String password);		
	Runner selectById(int id);				
	boolean updateRunnerById(Runner runner, int id);	
	Runner findByNameAndSurname(String name, String surname);			
				

}
