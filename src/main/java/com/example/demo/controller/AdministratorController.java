package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.AdministratorServiceImp;

@Controller
@RequestMapping(value = "/admin")
public class AdministratorController {
	
	@Autowired
	AdministratorServiceImp adminService;
	
	@GetMapping(value = "/authorizeAdmin")
	public String authorizeAdminGet(String email, String password) {
		
		
		return "authorizeadmin" ;
	}
	
	@PostMapping(value = "/authorizeAdmin")
	public String authorizeAdminPost(String email, String password) {
		
		
		return "authorizeadmin" ;
	}

}
