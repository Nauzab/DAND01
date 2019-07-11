package com.example.demo.services;


import java.util.ArrayList;

import com.example.demo.model.Manager;
import com.example.demo.model.Marathon;


public interface ManagerService {
	ArrayList<Manager> selectAll();
	boolean updateManager(Manager manager);
	boolean deleteRunnerById(int id);
	boolean authorizeManager(String email, String password);
	boolean createNewMarathon(Marathon marathon);
	boolean insertNewManager(Manager manager);
	boolean exportDataExcel();
	int findManagerId(String email);
	Manager findByID(int id)  throws Exception;
	Manager findByEmail(String email);
	
	
}