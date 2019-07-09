package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.Marathon;

public interface MarathonService {
	ArrayList<Marathon>selectAll();
	Marathon selectById(int id);
	boolean insertNewMarathon(Marathon marathon);
	boolean updateMarathonById(Marathon marathon, int id);
	boolean deleteMarathonById(int id);
	ArrayList<Marathon> findByPlace(String place);

}
