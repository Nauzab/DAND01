package com.example.demo.services;

import java.sql.Time;
import java.util.ArrayList;

import com.example.demo.model.Result;

public interface ResultService {
	
	ArrayList<Result> selectAll(int id_reg);
	ArrayList<Result> selectByRunnerid(int id_r);
	boolean inserNewResultByGroup(Time value, int id_reg);
	Result findByEmail(String email);
	Result findByRegistration(int id_reg);
	
	
	

}
