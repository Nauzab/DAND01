package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Runner;
import com.example.demo.service.RunnerServiceIMP;

@Controller
@RequestMapping(value="/Runner")
public class RunnerController {
	
	@Autowired
	RunnerServiceIMP runnerserviceimp;
	
	@GetMapping(value = "/Runner/RunnerRegister") //localhost:8080/RunnerRegister
	public String RunnerRegister(Runner runner) { 
		
		runnerserviceimp.insertNewRunner(runner);
		
		
		
		return "RunnerRegister";
	}
	
	

}
