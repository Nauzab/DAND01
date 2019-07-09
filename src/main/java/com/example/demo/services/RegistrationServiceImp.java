package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Group;
import com.example.demo.model.Registration;
import com.example.demo.repo.RegistrationRepo;

@Service
public class RegistrationServiceImp implements RegistrationService{
	@Autowired
	RegistrationRepo regRepo;
	
	@Override
	public ArrayList<Registration> selectAll() {
		
		return regRepo.selectAll();
	}

	@Override
	public boolean insertNewRegistration(Registration reg) {
		if(reg == null)
			return false;
		
		if(regRepo.existsById(reg.getId_reg())) {
		return false;
		}
		else {
			regRepo.save(reg);
			return true;
		}
		
		
	}

	@Override
	public boolean updateRegistration(Registration reg, int id_reg) {
		//INFO NEEDED
		return false;
	}

	@Override
	public boolean deleteRegistration(Registration reg) {
		if(regRepo.existsById(reg.getId_reg())) {
			regRepo.deleteById(reg.getId_reg());
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Group> findByRunnerid(int id_r) {
		// TODO Auto-generated method stub
		return null;
	}

}
