package com.example.demo.repo;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Manager;

public interface ManagerRepo extends CrudRepository<Manager, Integer> {
		Manager findByEmailAndPassword(String email, String password);
		Manager findByEmail(String email);
}
