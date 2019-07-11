package com.example.demo.services;

import java.sql.Time;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.model.Result;

@Service
public class ResultServiceImp implements ResultService{

	@Override
	public ArrayList<Result> selectAll(int id_mar) {
		
		return null;
	}

	@Override
	public ArrayList<Result> selectByRunnerid(int id_r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inserNewResultByGroup(Time value, int id_g) {
		// TODO Auto-generated method stub
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
