package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Group;
import com.example.demo.model.Marathon;

public interface GroupRepo extends CrudRepository<Group, Integer> {

	Group findByDistance(double distance);
	ArrayList<Group>findByMarathon(Marathon marathon);
}
