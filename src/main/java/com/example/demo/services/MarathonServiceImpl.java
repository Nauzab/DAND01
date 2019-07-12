package com.example.demo.services;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Marathon;
import com.example.demo.repo.ManagerRepo;
import com.example.demo.repo.MarathonRepo;
import com.example.demo.repo.RunnerRepo;

@Service
public class MarathonServiceImpl implements MarathonService /**this is an interface*/ {
	@Autowired
	MarathonRepo marathonRepo;
	
	@Autowired
	ManagerRepo managerRepo;
	
	@Autowired
	RunnerRepo runnerRepo;
	
	@Override
	public boolean insertNewMarathon(Marathon marathon) {
		if(marathon==null && marathonRepo.existsById(marathon.getId()))
			return false;
		if(marathonRepo.existsById(marathon.getId()))
			return false;
		else
		{
			marathonRepo.save(marathon);
			return true;
		}
	}

	@Override
	public boolean updateMarathonById(Marathon marathon, int id) {
		if(marathonRepo.existsById(id) && marathon!=null)
		{
			marathonRepo.save(marathon);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean deleteMarathonById(int id) {
		if(marathonRepo.existsById(id))
		{
			Marathon marathonTemp = marathonRepo.findById(id).get();
			marathonRepo.delete(marathonTemp);
			
			return true;
		}
		
		return false;
	}

	@Override
	public ArrayList<Marathon> selectAll() {
		ArrayList<Marathon>tempList = new ArrayList<Marathon>();
		for(Marathon s:marathonRepo.findAll())
		{
			tempList.add(s);
		}
		return tempList;
	}

	@Override
	public Marathon selectById(int id) {
		Marathon marathonTemp=marathonRepo.findById(id).get();
		if(marathonTemp!=null)
			return marathonTemp;
		return null;
	}

	@Override
	public ArrayList<Marathon> findByPlace(String place) {
		return marathonRepo.findByPlace(place);
	}

	@Override
	public Marathon findByDate(String date) {
		Marathon mar = marathonRepo.findByDate(date);
		if(mar!= null) {
			return mar;
		}
		// TODO Auto-generated method stub
		return null;
	}
	
}