package com.example.demo.services;

import java.sql.Time;
import java.util.ArrayList;

import com.example.demo.model.Result;

public interface ResultService {
	
	ArrayList<Result> selectAll();
	ArrayList<Result> selectByRegId(int id_reg);
	boolean inserNewResultByGroup(Time value, int id_reg);
	Result findByEmail(String email);
	Result findByRegistration(int id_reg);
	
	
	

}
