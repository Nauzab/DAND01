package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Administrator;
import com.example.demo.repo.AdministratorRepo;
import com.example.demo.repo.ManagerRepo;
import com.example.demo.repo.RunnerRepo;

@Service
public class AdministratorServiceImp implements AdministratorService {
	
	@Autowired 
	AdministratorRepo adminRepo;
	
	@Autowired
	ManagerRepo managerRepo;
	
	@Autowired
	RunnerRepo runnerRepo;

	@Override
	public boolean authorizeAdmin(String email, String password) {
		if(email != null && password != null) {
			Administrator tempadmin = adminRepo.findAdministratorByEmailAndPassword(email, password);
			if(tempadmin != null)
			return true;
			
		}
		return false;
	}

	public boolean insertnewAdmin(Administrator administrator) {
		if(administrator == null) {
			return false;
		}
		if(adminRepo.existsById(administrator.getId_a()) || adminRepo.findAdministratorByEmail(administrator.getEmail()) != null) {
			return false;
		
		}else {
			adminRepo.save(administrator);
			return true;		
		}
		

	}

	
	public boolean deleteManagerById(int id) {
		if(managerRepo.existsById(id)) {
			managerRepo.deleteById(id);
			return true;
		}
		return false;
	}

	public boolean deleteRunnerById(int id) {
		if(runnerRepo.existsById(id)) {
			runnerRepo.deleteById(id);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteAdminById(int id) {
		if(adminRepo.existsById(id)) {
			adminRepo.deleteById(id);
			return true;
		}
		return false;
	}

	public ArrayList<Administrator> selectAll() {
		
		return (ArrayList<Administrator>) adminRepo.findAll();
	}
	
	
	




}
