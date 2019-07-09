package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Group;
import com.example.demo.repo.GroupRepo;

@Service
public class GroupServiceImp implements GroupService{
	@Autowired
	GroupRepo groupRepo;
	@Override
	public boolean insertNewGroup(Group group) {
		if(group == null) {
			return false;
		}
			
		if (groupRepo.existsById(group.getId_g())) {
			return false;
		}else {
			groupRepo.save(group);
			return true;
		}
		
	}

	@Override
	public Group selectById(int id) {
		Group tempGroup = groupRepo.findById(id).get();
		
		if(tempGroup != null)
			return tempGroup;
		
		return null;
	}

	@Override
	public boolean updateGroupById(Group group, int id) {
		if(groupRepo.existsById(id)) {
			Group tempGroup = groupRepo.findById(id).get();
			
			tempGroup.setDistance(group.getDistance());
			
		}
		return false;
	}

	@Override
	public boolean deleteGroupById(int id) {
		if(groupRepo.existsById(id)) {
			groupRepo.deleteById(id);
			return true;
		}
		return false;
	}


	@Override
	public ArrayList<Group> selectAll() {
		
		return (ArrayList<Group>) groupRepo.findAll();
	}

}
