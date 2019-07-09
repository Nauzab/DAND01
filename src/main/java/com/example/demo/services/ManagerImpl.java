package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manager;
import com.example.demo.repo.ManagerRepo;


@Service
public class ManagerImpl implements ManagerService{
	
	
	@Autowired
	ManagerRepo managerRepo;

	@Override
	public ArrayList<Manager> selectAll() {
		ArrayList<Manager> tempList = new ArrayList<Manager>();
		for(Manager m: managerRepo.findAll()) {
			tempList.add(m);
		}
		return tempList;
	}
	

	@Override
	public boolean updateManager(Manager manager) {
		if(manager != null && managerRepo.existsById(manager.getId())) {
			Manager manTemp = managerRepo.findById(manager.getId()).get();
			manTemp.setName(manager.getName());
			manTemp.setSurname(manager.getSurname());
			manTemp.setEmail(manager.getEmail());
			manTemp.setPassword(manager.getPassword());
			return true;
		}
		else
		return false;
	}

	

	@Override
	public boolean deleteRunnerById(int id_r) {
		if(id > -1 && runnerRepo.existsById(id_r)) {
			runnerRepo.deleteById(id_r);
			return true;
		} else
		return false;
	}


	@Override
	public boolean authorizeManager(String email, String password) {
		Manager man = managerRepo.findByEmailAndPassword(email, password);
		if (man != null) {
			return true;
		}
		else {
			return false;
		}
	}
	

	@Override
	public boolean createNewMarathon(Marathon marathon) {
		if(marathon == null && marathonRepo.existsById(marathon.getId()))
			return false;
		else {
			marathonRepo.save(marathon);
			return true;
		}
	}
	
	@Override
	public boolean insertNewManager(Manager manager) {
		if (manager == null || managerRepo.existsById(manager.getId()))
			return false;
		else {
			managerRepo.save(manager);
		}
		return true;
	}
	
	

}
