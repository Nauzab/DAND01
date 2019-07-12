package com.example.demo.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Administrator;
import com.example.demo.model.ExportData;
import com.example.demo.model.Manager;
import com.example.demo.model.Marathon;
import com.example.demo.model.Runner;
import com.example.demo.services.AdministratorServiceImp;
import com.example.demo.services.ManagerImpl;
import com.example.demo.services.MarathonServiceImpl;
import com.example.demo.services.RunnerServiceIMP;

@Controller


public class FirstPageController {
	
	@Autowired 
	AdministratorServiceImp adminService;
	@Autowired
	MarathonServiceImpl marService;
	@Autowired
	ManagerImpl manService;
	@Autowired
	RunnerServiceIMP runnerServiceImp;
	
	//@GetMapping(value="/firstpage")
	public String roleview(Model model) throws ParseException {	
		Administrator ad = new Administrator("nauris", "Zablovskis", "123456", "nauris@inbox.lv");
		
		Manager men = new Manager( "Janis", "Krauls", "123456", "Janis@krauls.com");
		
		Marathon mar = new Marathon ("Ventspils Maratons" , "Ventspils", men, "12/08/19");
		Runner run = new Runner("Dand", "Runner", "male", "dandrunner", "runnerdand@gmail.com");
		ExportData data = new ExportData();
		
		adminService.insertnewAdmin(ad);
		manService.insertNewManager(men);
		marService.insertNewMarathon(mar);
		runnerServiceImp.insertNewRunner(run);
		
		return "firstpage";
	}
}