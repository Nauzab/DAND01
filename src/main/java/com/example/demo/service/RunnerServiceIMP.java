package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Runner;
import com.example.demo.repo.RunnerRepo;

@Service
public class RunnerServiceIMP implements RunnerService {

	@Autowired
	RunnerRepo runnerrepo;

	@Override
	public ArrayList<Runner> selectAll() {
		ArrayList<Runner> run = new ArrayList<Runner>();
		for (Runner r : runnerrepo.findAll()) {
			run.add(r);
		}

		return run;
	}

	@Override
	public boolean insertNewRunner(Runner runner) {

		if (runner.getID_r() != 0 || runnerrepo.existsById(runner.getID_r())) {
			return false;
		} else {

			return true;
		}
	}

	@Override
	public boolean autorizeRunner(String email, String password) {

		Runner runner = runnerrepo.findByEmailAndPassword(email, password);
		if (runner != null) {
			return true;

		} else {

			return false;
		}
	}

	@Override
	public Runner selectById(int id) {
		Runner runner = runnerrepo.findById(id).get();

		if (runner == null) {
			return null;
		} else {
			return runner;
		}

	}

	@Override
	public boolean updateRunnerById(Runner runner, int id) {
		System.out.println("INCOMING ----" + id);

		if (runner != null && runnerrepo.existsById(id)) {
			Runner runnerTemp = runnerrepo.findById(id).get();
			System.out.println("TEMP----" + runnerTemp.getID_r());
			runnerTemp.setName(runner.getName());
			runnerTemp.setSurname(runner.getSurname());
			runnerTemp.setSex(runner.getSex());

			return true;
		} else
			return false;

	}

	@Override
	public Runner findByNameAndSurname(String name, String surname) {
		Runner runner = runnerrepo.findByNameAndSurname(name, surname);
		
		if(runner!=null) {
			return runner;
		}else {
		
		
		return null;
	}

}
}
