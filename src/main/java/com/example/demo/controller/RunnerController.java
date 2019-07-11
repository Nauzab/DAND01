package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping(value="/viewrunner/{id}")
	public String viewrunner(@PathVariable(name = "id") int id,Runner runner) {
		return "viewrunner";
		
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
			System.out.println("Nepareizi");
	
			return "runnerlogin";
			
	}else{
	}
		if(runnerserviceimp.autorizeRunner(runner.getEmail(),runner.getPassword()))
		{
		Runner runnertemp = runnerserviceimp.findByEmail(runner.getEmail());	
		System.out.println("Pareizi");
		return "redirect:/runner/viewrunner/"+runnertemp.getID_r();
		}else {
			System.out.println("Nepareizi");
		return "runnerlogin";
	
	}
	}

@GetMapping(value="/allrunners")
public String AllRunners(Model model) {
	
	
model.addAttribute("Runners", runnerserviceimp.selectAll());
return "allrunners"	;
}

	@GetMapping(value="/firstpage") // localhost:8080/firstpage
	public String chooseRunnerGet() {
			// method
			return "firstpage";	
		}
		
	@PostMapping(value="Runner")// after submit button pressed
	public String chooseRunnerPost() {

		return "/runner/main";
		}
	
	@GetMapping(value = "/runnerupdate/{id}")
	public String updateRunnerGet(@PathVariable(name = "id") int id, Model model) {
		model.addAttribute("Runner", runnerserviceimp.selectById(id));
		return "update";
	}
	
	@PostMapping(value = "/runnerupdate/{id}")
	public String updateRunnerPost(@PathVariable(name = "id") int id, Runner runner) {
		runnerserviceimp.updateRunnerById(runner, id);
		return "redirect:/runner/viewrunner";
	}
	
	
	

	}
	
	
