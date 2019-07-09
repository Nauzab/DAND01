package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Marathon;
import com.example.demo.service.MarathonServiceImpl;

@Controller
@RequestMapping(value="/marathon")
public class MarathonController {
	@Autowired
	MarathonServiceImpl marathonServiceImpl; 

	@GetMapping(value = "/marathonview")
	public String marathonview(Model model) {

		model.addAttribute("marathonlist", marathonServiceImpl.selectAll());
		return "marathonview";
	}
	
	@GetMapping(value = "/marathonview/{id}")
	public String allmarathonsviewbyid(@PathVariable(name="id") int id, Model model) {

		model.addAttribute("object", marathonServiceImpl.selectById(id));
		return "marathonview";
	}
	
	@GetMapping(value = "/addmarathon") // localhost:8080/addmarathon
	public String addmarathonGet(Marathon marathon) {

		return "addmarathon"; // addmarathon.html
	}
	
	@PostMapping(value = "/addmarathon") // after submit button pressed
	public String addmarathonPost(@Valid Marathon marathon, BindingResult result) // filled marathon object data
	{
        if (result.hasErrors())
            return "addmarathon";
        else
        {      
        	marathonServiceImpl.insertNewMarathon(marathon);
		return "redirect:/marathon/marathonview";
        }
	}
	
	@GetMapping(value = "/updatemarathon/{id}")
	public String updateMarathonGet(@PathVariable(name = "id") int id, Model model) {
		model.addAttribute("marathon", marathonServiceImpl.selectById(id));
		return "updatemarathon";
	}
	
	@PostMapping(value = "/updatemarathon/{id}")
	public String updateMarathonPost(@PathVariable(name = "id") int id, Marathon marathon) {
		marathonServiceImpl.updateMarathonById(marathon, id);
		return "redirect:/marathon/marathonview";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteMarathonGet(@PathVariable(name = "id") int id) {
		marathonServiceImpl.deleteMarathonById(id);
		return "redirect:/marathon/marathonview";
	}
}
