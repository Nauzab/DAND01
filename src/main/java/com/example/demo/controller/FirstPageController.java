package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


public class FirstPageController {
	
	@GetMapping(value="/firstpage")
	public String roleview(Model model) {	
		
		return "firstpage";
	}

}
