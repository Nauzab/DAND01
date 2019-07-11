package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FirstPageController {
	@GetMapping(value="/firstpage") // localhost:8080/firstpage
		public String firstPage() {
		// method
		return "firstpage";	
	}
}
