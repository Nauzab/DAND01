package com.example.demo.services;


import java.util.ArrayList;

import com.example.demo.model.Manager;
<<<<<<< HEAD
import com.example.demo.model.Marathon;
=======
>>>>>>> 3b9cc1a8bce2e1769de7298300ad102e2a9dff7c

public interface ManagerService {
	ArrayList<Manager> selectAll();
	boolean updateManager(Manager manager);
	boolean deleteRunnerById(int id);
	boolean authorizeManager(String email, String password);
	boolean createNewMarathon(Marathon marathon);
	boolean insertNewManager(Manager manager);
}
