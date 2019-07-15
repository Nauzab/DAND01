package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Group;
import com.example.demo.model.Marathon;
import com.example.demo.model.Registration;
import com.example.demo.model.Runner;
import com.example.demo.repo.GroupRepo;
import com.example.demo.repo.RegistrationRepo;
import com.example.demo.repo.RunnerRepo;

@Service
public class RegistrationServiceImp implements RegistrationService{
	@Autowired
	RegistrationRepo regRepo;
	
	@Autowired
	GroupRepo groupRepo;
	
	@Autowired
	RunnerRepo runnerRepo;
		
	@Override
	public ArrayList<Registration> selectAll() {
		
		return (ArrayList<Registration>) regRepo.findAll();
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
	public boolean deleteRegistration(Registration reg) {
		if(regRepo.existsById(reg.getId_reg())) {
			regRepo.deleteById(reg.getId_reg());
			return true;
		}
		return false;
	}

/*	public ArrayList<Group> findByRunnerid(int id_r) {
		Runner runner = runnerRepo.findById(id_r).get();
		if(runner!=null) {
			return (ArrayList<Group>) runnerRepo.findByRunner(runner);
		}
		else
			return new ArrayList<Group>();
	}

		return null;
	}*/
}