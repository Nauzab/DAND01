package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Group;
import com.example.demo.model.Registration;
import com.example.demo.model.Result;
import com.example.demo.model.Runner;

public interface RegistrationRepo extends CrudRepository<Registration, Integer>{
	Registration findByGroupAndRunnerAndResult(Group gr, Runner run, Result res);

}
