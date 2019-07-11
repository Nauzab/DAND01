package com.example.demo.services;

import java.sql.Time;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Result;
import com.example.demo.repo.ResultRepo;
import com.example.demo.repo.RunnerRepo;

@Service
public class ResultServiceImp implements ResultService{

	
		@Autowired
		ResultRepo resultRepo;
		
		
	@Override
	public ArrayList<Result> selectAll() {
		
		return (ArrayList<Result>) resultRepo.findAll();
	}

	@Override
	public ArrayList<Result> selectByRegId(int id_reg) {
		
		
		return null;
	}

	@Override
	public boolean inserNewResultByGroup(Time value, int id_reg) {
				
		return false;
	}

	@Override
	public Result findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findByRegistration(int id_reg) {
		// TODO Auto-generated method stub
		return null;
	}

}