package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Manager;
import com.example.demo.services.ManagerImpl;

@Controller

public class FirstPageController {
	
	@Autowired
	ManagerImpl managerImpl;
	@GetMapping(value="/firstpage") // localhost:8080/firstpage
		public String firstPage() {
		
			Manager man = new Manager("Darija", "Sokolova" ,"darija123" ,"darija@darija.com" );
			managerImpl.insertNewManager(man);
			
		return "firstpage";	
	}
}
