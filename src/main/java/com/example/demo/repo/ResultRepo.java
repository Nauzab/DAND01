package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Group;
import com.example.demo.model.Result;



public interface ResultRepo extends CrudRepository<Result, Integer>{
	
	
	//Group findGroupByID_reg(int id_reg);

}
