package com.example.demo.services;

import com.example.demo.model.Administrator;

public interface AdministratorService {

	
	boolean authorizeAdmin(String email, String password);
}
