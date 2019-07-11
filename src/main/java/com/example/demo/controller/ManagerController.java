package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.email.EmailSender;
import com.example.demo.model.Manager;
import com.example.demo.model.Runner;
import com.example.demo.repo.ManagerRepo;
import com.example.demo.services.ManagerImpl;

@Controller
@RequestMapping(value="/manager")


public class ManagerController {
	@Autowired
	ManagerImpl managerImpl;
	
	@Autowired
	EmailSender mailSender;
	
	

	@GetMapping(value="managermain")
	public String mainManagerGet(Manager manager) {
		return "managermain";
	}
	
	@GetMapping(value="/managerview")
	public String managerview(Model model) {	
		model.addAttribute("object", managerImpl.selectAll());
		return "managerview";
	}
	
	
	
	@GetMapping(value="/addmanager") // localhost:8080/manager/addmanager
	public String addManagerGet(Manager manager, Model model) {
		
		// method
		return "addmanager";	
	}
	
	@GetMapping(value="/loginmanager")
	public String loginManagerGet(Manager manager) {
		return "loginmanager";
	}
	
	@GetMapping(value="/areamanager/{id_m}")
	public String areaManagerGet(@PathVariable(name="id_m")int id, Model model) {
		
		try {
			Manager manager = managerImpl.findByID(id);
			model.addAttribute("name", manager.getName());
			model.addAttribute("surname", manager.getSurname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "areamanager";
	}
	
	
	@PostMapping(value="/addmarathon/{id_m}")// after submit button pressed
	public String CreateMarathonPost(@Valid Manager manager, BindingResult result) {
	if(result.hasErrors()) {
		return "areamanager/{id_m}";
	}
	else
	{
		managerImpl.insertNewManager(manager);
	}
	return "redirect:/marathon/addmarathon/{id_m}";
	}
	
	
	@PostMapping(value="/loginmanager")
	public String loginManagerPost(Manager manager) {
		if(managerImpl.authorizeManager(manager.getEmail(), manager.getPassword())) {
			return "redirect:/manager/areamanager/"+ managerImpl.findManagerId(manager.getEmail());
		}
		
		return "loginmanager";
		}


	
	@PostMapping(value="/addmanager")// after submit button pressed
	public String addManagerPost(@Valid Manager manager, BindingResult result) {
	if(result.hasErrors() && managerImpl.findByEmail(manager.getEmail()) == null) {
		return "addmanager";
	} // TODO Verify if exists this manager (managerImpl function ) 
	else
	{
		managerImpl.insertNewManager(manager);
		//mailSender.sendEmail(manager);
		// call EmailSender function
	}
	return "redirect:/manager/loginmanager";
	}
	
	@PostMapping(value="areamanager/{id_m}") // 
	public String createMarathonGet(Manager manager) {
		return "areamanager";
	}
	
	
	@PostMapping(value="/managermain")// after submit button pressed
	public String chooseManagerPost() {

	return "redirect:/manager/managermain";
	}
	
	@GetMapping(value="/exportdata")
	public String exportData(Model model) {
		managerImpl.exportDataExcel();
		//model.addAttribute("object", );
	return "exportdata";
	}
	
	}
