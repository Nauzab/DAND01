package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.model.Administrator;

public interface AdministratorService {

	ArrayList<Administrator> selectAll();
	boolean authorizeAdmin(String email, String password);
	boolean deleteAdminById(int id);
	boolean deleteManagerById(int id);
	boolean deleteRunnerById(int id);

	boolean insertnewAdmin(Administrator administrator); 

	
}
