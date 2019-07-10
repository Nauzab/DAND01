package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Group;
import com.example.demo.services.GroupServiceImp;

@Controller
public class GroupController {

	@Autowired
	GroupServiceImp groupService;
	
	
	
	@GetMapping(value = "updategroup/{id}")
	public String updateGroupGet(@PathVariable(name = "id") int id,Model model) {
		
		model.addAttribute("group", groupService.selectById(id));
		
		return "updategroup";
		
	}
	
	@PostMapping(value = "updategroup/{id}")
	public String updateGroupPost(@PathVariable(name = "id") int id,Group group) {
		
		groupService.updateGroupById(group, id);
		
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
		
		groupService.insertNewGroup(group);
		return "firstpage";
		
	}
	
}
