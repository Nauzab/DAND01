package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Manager;
import com.example.demo.repo.ManagerRepo;
import com.example.demo.services.ManagerImpl;

@Controller
@RequestMapping(value="/manager")


public class ManagerController {
	@Autowired
	ManagerImpl managerImpl;
	
	@GetMapping(value="/managerview")
	public String managerview(Model model) {	
		model.addAttribute("object", managerImpl.selectAll());
		return "managerview";
	}
	
	
	
	@GetMapping(value="/addmanager") // localhost:8080/manager/addmanager
	public String addManagerGet(Manager manager) {
		// method
		return "addmanager";	
	}
	
	@GetMapping(value="/loginmanager")
	public String loginManagerGet(Manager manager) {
		return "loginmanager";
	}
	
	@GetMapping(value="/areamanager")
	public String areaManagerGet(Manager manager) {
		return "areamanager";
	}
	
	@PostMapping(value="/loginmanager")
	public String loginManagerPost(Manager manager) {
	
		if(managerImpl.authorizeManager(manager.getEmail(), manager.getPassword())) {
			return "redirect:/manager/areamanager";
		}
		
		return "loginmanager";
		}
	

	
	@PostMapping(value="/addmanager")// after submit button pressed
	public String addManagerPost(@Valid Manager manager, BindingResult result) {
	if(result.hasErrors()) {
		return "addmanager";
	}
	else
	{
		managerImpl.insertNewManager(manager);
	}
	return "redirect:/manager/loginmanager";
	}
	
	@PostMapping(value="areamanager") // 
	public String createMarathonGet(Manager manager) {
		return "areamanager";
	}
	
	@PostMapping(value="Create Marathon")// after submit button pressed
	public String CreateMarathonPost(@Valid Manager manager, BindingResult result) {
	if(result.hasErrors()) {
		return "addmanager";
	}
	else
	{
		managerImpl.insertNewManager(manager);
	}
	return "redirect:/manager/loginmanager";
	}
	@GetMapping(value="/firstpage") // localhost:8080/firstpage
	public String chooseManagerGet() {
		// method
		return "firstpage";	
	}
	
	@PostMapping(value="Manager")// after submit button pressed
	public String chooseManagerPost() {

	return "redirect:/manager/addmanager";
	}
}
