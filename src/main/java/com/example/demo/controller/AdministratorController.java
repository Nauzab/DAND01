package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Administrator;
import com.example.demo.model.Manager;
import com.example.demo.model.Marathon;
import com.example.demo.model.Runner;
import com.example.demo.services.AdministratorServiceImp;
import com.example.demo.services.ManagerService;
import com.example.demo.services.MarathonService;
import com.example.demo.services.RunnerService;

@Controller
@RequestMapping(value = "/admin")
public class AdministratorController {
	
	@Autowired
	AdministratorServiceImp adminService;
	
	@Autowired
	ManagerService manService;
	
	@Autowired 
	RunnerService runnerService;
	
	@Autowired
	MarathonService marathonService;
		
	@GetMapping(value = "/")
	public String test() throws ParseException  {
		
		
		Administrator ad = new Administrator("nauris", "Zablovskis", "123456", "nauris@inbox.lv");
		
	
		adminService.insertnewAdmin(ad);
		return "firstpage";
	}
	@GetMapping(value = "/authorizeAdmin")
	public String authorizeAdminGet(Administrator adminstrator) {
		
		
		return "authorizeadmin" ;
	}
	
	@PostMapping(value = "/authorizeAdmin")
	public String authorizeAdminPost(@Valid Administrator administrator, BindingResult result) {
		
		
		boolean temp = adminService.authorizeAdmin(administrator.getEmail(), administrator.getPassword());
		if(result.hasErrors()) {
			
			return "authorizeadmin";
		}
		
		if(temp) 
			return "redirect:/admin/createManager";
		
		
	
		return "authorizeadmin";
	}
	
	@GetMapping(value = "/createManager")
	public String createManagerGet(Manager manager) {
		
		
		return "createmaneger" ;
	}
	
	@PostMapping(value = "/createManager")
	public String createManegerPost(@Valid Manager manager ,BindingResult result ) {
		
		if(result.hasErrors()) {
			return "createmaneger";
		}
		
		manService.insertNewManager(manager);
		
		return "redirect:/admin/firstpage" ;
		
		
	}
	
	@GetMapping(value = "/createRunner")
	public String createRunnerGet(Runner runner) {
		
		
		return "createrunner" ;
	}
	
	@PostMapping(value = "/createRunner")
	public String createRunnerPost(@Valid Runner runner ,BindingResult result ) {
		
		if(result.hasErrors()) {
			return "createrunner";
		}
		
		runnerService.insertNewRunner(runner);
		
		return "firstpage" ;
		
	}
	
	
	@GetMapping(value = "/deleteManager/{id}")
	public String deleteManagerGet(@PathVariable(name = "id") int id) {
		
		adminService.deleteManagerById(id);
		return "redirect:/admin/createManager";
	}
	
	@GetMapping(value = "/deleteRunner/{id}")
	public String deleteRunnerGet(@PathVariable(name = "id") int id) {
		
		adminService.deleteRunnerById(id);
		return "redirect:/admin/createRunner";
	}
	
	@GetMapping(value = "/deleteMarathon/{id}")
	public String deleteMarathonGet(@PathVariable(name = "id") int id) {
		
		marathonService.deleteMarathonById(id);
		return "firstpage";
	}

}