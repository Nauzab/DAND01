package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Registration;

public interface RegistrationRepo extends CrudRepository<Registration, Integer>{

		ArrayList<Registration> selectAll();
		Registration selectById(int id);
		
		
}
