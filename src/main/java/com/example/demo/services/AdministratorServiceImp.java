package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Administrator;
import com.example.demo.repo.AdministratorRepo;

@Service
public class AdministratorServiceImp implements AdministratorService {
	
	@Autowired 
	AdministratorRepo adminRepo;

	@Override
	public boolean authorizeAdmin(String email, String password) {
		if(email != null && password != null) {
			Administrator tempadmin = adminRepo.findAdministratorByEmailAndPassword(email, password);
			if(tempadmin != null)
			return true;
			
		}
		return false;
	}




}
