package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Runner;

public interface RunnerRepo extends CrudRepository<Runner, Integer> {
	Runner findByEmailAndPassword(String email, String password);
	Runner findByNameAndSurname(String name,String surname);
	

}
