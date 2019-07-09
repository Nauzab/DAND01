package com.example.demo.services;

<<<<<<< HEAD

=======
>>>>>>> 3b9cc1a8bce2e1769de7298300ad102e2a9dff7c
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manager;
<<<<<<< HEAD
import com.example.demo.model.Marathon;
import com.example.demo.repo.ManagerRepo;
import com.example.demo.repo.MarathonRepo;
import com.example.demo.repo.RunnerRepo;
=======
import com.example.demo.repo.ManagerRepo;
>>>>>>> 3b9cc1a8bce2e1769de7298300ad102e2a9dff7c


@Service
public class ManagerImpl implements ManagerService{
	
	
	@Autowired
	ManagerRepo managerRepo;
<<<<<<< HEAD
	
	@Autowired
	RunnerRepo runnerRepo;
	
	@Autowired
	MarathonRepo marathonRepo;
	
=======
>>>>>>> 3b9cc1a8bce2e1769de7298300ad102e2a9dff7c

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
<<<<<<< HEAD
		if(id_r > -1 && runnerRepo.existsById(id_r)) {
=======
		if(id > -1 && runnerRepo.existsById(id_r)) {
>>>>>>> 3b9cc1a8bce2e1769de7298300ad102e2a9dff7c
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
