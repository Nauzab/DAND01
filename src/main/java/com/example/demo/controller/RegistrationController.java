package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.services.RegistrationServiceImp;

@Controller
public class RegistrationController {

	
		@Autowired
		RegistrationServiceImp regitrationService;	
		
		
		@GetMapping(value = "/register/{id}")
		public String register(@PathVariable(name = "id") int id) {
			
		
			return "register";
		}
		
}
