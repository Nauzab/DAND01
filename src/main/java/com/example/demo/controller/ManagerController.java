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
	@GetMapping(value="/addmanager") // 
	public String addManager(Manager manager) {
		// method
		return "manager";	
	}
	
	@PostMapping(value="/addmanager")// after submit button pressed
	public String addcarPost(@Valid Manager manager, BindingResult result) {
	if(result.hasErrors()) {
		return "addmanager";
	}
	else
	{
	managerImpl.insertNewManager(manager);
	}
	return "redirect:/manager";
	}
}
