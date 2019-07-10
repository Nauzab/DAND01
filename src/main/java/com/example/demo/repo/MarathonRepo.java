package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Marathon;

public interface MarathonRepo extends CrudRepository<Marathon, Integer>{
	ArrayList<Marathon>findByName(String name);
	
	ArrayList<Marathon>findByPlace(String place);

}
