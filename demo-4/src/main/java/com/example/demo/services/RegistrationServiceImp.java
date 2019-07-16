package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Group;
import com.example.demo.model.Marathon;
import com.example.demo.model.Registration;
import com.example.demo.model.Result;
import com.example.demo.model.Runner;
import com.example.demo.repo.GroupRepo;
import com.example.demo.repo.MarathonRepo;
import com.example.demo.repo.RegistrationRepo;
import com.example.demo.repo.ResultRepo;
import com.example.demo.repo.RunnerRepo;

@Service
public class RegistrationServiceImp implements RegistrationService{
	@Autowired
	RegistrationRepo regRepo;
	
	@Autowired
	GroupRepo groupRepo;
	
	@Autowired
	RunnerRepo runnerRepo;
	
	@Autowired
	MarathonRepo marathonRepo;
	
	@Autowired
	ResultRepo resultRepo;
	
	
		
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

	@Override
	public boolean insertNewRegistration(int id_r, String action, int id_mar) {
	Runner run = runnerRepo.findById(id_r).get();
	Marathon mar = marathonRepo.findById(id_mar).get();
	System.out.println(id_mar);
	System.out.println(id_r);
	System.out.println(action);
	Group gr = groupRepo.findByDistance(Double.parseDouble(action));
	Result res = new Result(Double.parseDouble(action));
	
	Registration regist = new Registration(gr, run, res);
	
	resultRepo.save(res);
	
	regRepo.save(regist);
	//Registration reg2 = regRepo.findByGroupAndRunnerAndResult(gr, run, res);
	//System.out.println(reg2.getId_reg());
	//res.set
	
	
	
	
		   /*switch(action) {
	        case "5.0":
	        	regist
	        	getGroup().setDistance(5.0);
	            // do stuff
	            break;
	        case "21.0975":
	        	registration.getGroup().setDistance(21.0975);
	            // do stuff
	            break;
	        case "42.195":
	        	registration.getGroup().setDistance(42.195);
	            // do stuff
	            break;
	        case "10.0":
	        	registration.getGroup().setDistance(10.0);
	            // do stuff
	            break; 
	            
	        default:
	        */
		
		// TODO Auto-generated method stub
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