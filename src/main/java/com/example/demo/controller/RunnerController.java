package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Runner;
import com.example.demo.services.RunnerServiceIMP;

import ch.qos.logback.core.joran.conditional.ElseAction;

@Controller
@RequestMapping(value="/runner")
public class RunnerController {
	
	@Autowired
	RunnerServiceIMP runnerserviceimp;
	
	@GetMapping(value="/main")
	public String main(Runner runner) {
		return "main";
		
	}
	
	
	@GetMapping(value = "/runnerregister") //localhost:8080/RunnerRegister
	public String RunnerRegister(Runner runner) { 
		
		

		
		return "runnerregister";
	}
	@PostMapping(value = "/runnerregister") //localhost:8080/RunnerRegister
	public String RunnerRegisterPost(@Valid Runner runner,BindingResult result) { 
		
		
		if(result.hasErrors())
			return "runnerregister";
		
		else 
		
		runnerserviceimp.insertNewRunner(runner);
		return "redirect:/runner/runnerlogin";
	}
	
	

	
	@GetMapping(value = "/runnerlogin")
	public String RunnerLogin(Runner runner)
	{
	
	
	return "runnerlogin";
	
}

	@PostMapping(value = "/runnerlogin")
	public String RunnerLoginpost(@Valid Runner runner, BindingResult result)
	{
		if(result.hasErrors()) {
			System.out.println("Pareizi");
			return "runnerlogin";
			
	}else{
		runnerserviceimp.autorizeRunner(runner.getEmail(),runner.getPassword());
		System.out.println("Nepareizi");
		return "main";
	}
	}
		
	@GetMapping(value="/firstpage") // localhost:8080/firstpage
	public String chooseRunnerGet() {
			// method
			return "firstpage";	
		}
		
	@PostMapping(value="Runner")// after submit button pressed
	public String chooseRunnerPost() {

		return "redirect:/runner/runnerregister";
		}

	}
	
	
