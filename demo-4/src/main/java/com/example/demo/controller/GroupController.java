package com.example.demo.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Group;
import com.example.demo.model.Manager;
import com.example.demo.model.Marathon;
import com.example.demo.services.GroupServiceImp;
import com.example.demo.services.ManagerImpl;
import com.example.demo.services.MarathonServiceImpl;

@Controller
@RequestMapping(value="/group")
public class GroupController {

	@Autowired
	GroupServiceImp groupServiceImpl;
	
	@Autowired
	MarathonServiceImpl marathonServiceImpl; 

	@Autowired
	ManagerImpl managerServiceImpl; 

	@GetMapping(value = "/")
	public String test() throws ParseException{
		Manager m1 = new Manager("Nauris", "Uzvards", "passwords", " emails");
		Manager m2 = new Manager("Daniels", "Uzvards", "passwords", " emails");
		
		
		Marathon ad = new Marathon("Ventspils maratons", "Ventspils", m1, "24/07/2019");
		Marathon ad1 =new Marathon("Kuldigas maratons", "Kuldiga", m2, "31/07/2019");
		Marathon ad2 =new Marathon("Saldus maratons", "Saldus", m2, "06/08/2019");
		Marathon ad3 =new Marathon("Talsu maratons", "Talsi", m1, "13/08/2019");
		
		managerServiceImpl.insertNewManager(m1);
		managerServiceImpl.insertNewManager(m2);
		marathonServiceImpl.insertNewMarathon(ad, 2);
		marathonServiceImpl.insertNewMarathon(ad1, 2);
		marathonServiceImpl.insertNewMarathon(ad2, 2);
		marathonServiceImpl.insertNewMarathon(ad3, 2);
		
		
		Group gr = new Group(5.0, ad);
		Group gr1 =new Group(10.0, ad2);
		Group gr2 =new Group(21.0975, ad3);
		Group gr3 =new Group(42.195, ad1);
		groupServiceImpl.insertNewGroup(gr);
		groupServiceImpl.insertNewGroup(gr2);
		groupServiceImpl.insertNewGroup(gr3);
		groupServiceImpl.insertNewGroup(gr1);
		
		return "groupview";
	}
	
	
	@GetMapping(value = "updategroup/{id}")
	public String updateGroupGet(@PathVariable(name = "id") int id,Model model) {
		
		model.addAttribute("group", groupServiceImpl.selectById(id));
		
		return "updategroup";
		
	}
	
	@PostMapping(value = "updategroup/{id}")
	public String updateGroupPost(@PathVariable(name = "id") int id,Group group) {
		
		groupServiceImpl.updateGroupById(group, id);
		
		return "firstpage";
		
	}
	
	@GetMapping(value = "insertnewgroup")
	public String insertNewGroupGet(Group group) {
		
		return "insertnewgroup";
		
	}
	
	@PostMapping(value = "insertnewgroup")
	public String insertNewGroupPost(@Valid Group group, BindingResult result) {
		if(result.hasErrors()) {
			return "insertnewgroup";
		}
		
		groupServiceImpl.insertNewGroup(group);
		return "firstpage";
		
	}
	
}