package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.model.Group;
import com.example.demo.model.Registration;

public interface RegistrationService {
	
		ArrayList<Registration> selectAll();
		boolean insertNewRegistration(Registration reg);
		boolean deleteRegistration(Registration reg);
		//ArrayList<Group> findByRunnerid(int id_r);
		boolean insertNewRegistration(int id_r, String action, int id_mar);
}