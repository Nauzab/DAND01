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

import com.example.demo.model.Manager;
import com.example.demo.model.Marathon;
import com.example.demo.services.ManagerImpl;
import com.example.demo.services.MarathonServiceImpl;

@Controller
@RequestMapping(value="/marathon")
public class MarathonController {
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
		
		return "marathonview";
	}
	@GetMapping(value = "/marathonview")
	public String marathonview(Model model) {

		model.addAttribute("marathonlist", marathonServiceImpl.selectAll());
		return "marathonview";
	}
	
	@GetMapping(value = "/areamarathon/{id_mar}")
	public String allmarathonsviewbyid(@PathVariable(name="id_mar") int id_mar, Model model) {

		System.out.println(id_mar);
		model.addAttribute("marathon", marathonServiceImpl.selectById(id_mar));
		return "areamarathon";
	}
	
	@GetMapping(value = "/addmarathon/{id_m}") // localhost:8080/addmarathon
	public String addmarathonGet(Marathon marathon) {

		return "addmarathon"; // addmarathon.html
	}
	
	//@PostMapping(value = "/addmarathon") // after submit button pressed
//	public String addmarathonPost(Marathon marathon, BindingResult result) // filled marathon object data
	//{
      //  if (result.hasErrors()) {
      //  	System.out.println("yes");
      //      return "addmarathon";
      //  }
        
      //  else
       // {      
        //	marathonServiceImpl.insertNewMarathon(marathon);
        	
        	
	//	return "redirect:/marathon/areamarathon/"+marathon.getId();
     //  }
	//}
	
	@PostMapping(value = "/updatemarathon")
	public String updateMarathon(Marathon marathon) {
		System.out.println(marathon.getId());
		return "redirect:/marathon/updatemarathon/"+marathon.getId();
	}
	
	@PostMapping(value = "/marathonview")
	public String viewMarathon(Marathon marathon) {
		System.out.println(marathon.getId());
		return "redirect:/marathon/areamarathon/"+marathon.getId();
	}
	@GetMapping(value = "/updatemarathon/{id_mar}")
	public String updateMarathonGet(@PathVariable(name = "id_mar") int id_mar, Model model) {
		model.addAttribute("marathon", marathonServiceImpl.selectById(id_mar));
		return "updatemarathon";
	}
	
	@PostMapping(value = "/updatemarathon/{id_mar}")
	public String updateMarathonPost(@PathVariable(name = "id_mar") int id_mar, Marathon marathon) {
		marathonServiceImpl.updateMarathonById(marathon, id_mar);
		return "redirect:/marathon/updatemarathon/"+marathon.getId();
	}
	
	@PostMapping(value = "/delete")
	public String deleteMarathonPost(Marathon marathon) {
		marathonServiceImpl.deleteMarathonById(marathon.getId());
		return "redirect:/marathon/marathonview";
	}

	
	@PostMapping(value = "/addmarathon/{id_m}") // after submit button pressed
	public String addmarathonPost(@PathVariable(name="id_m") int id_m, Model model, @Valid Marathon marathon, BindingResult result) // filled marathon object data
	{
        if (result.hasErrors()) {
        	System.out.println("yes");
            return "addmarathon";
        }
        
        else
        {      
        	marathonServiceImpl.insertNewMarathon(marathon, id_m);
        	Marathon mar = marathonServiceImpl.findByDate(marathon.getDate());
        	try {
				mar.setId(id_m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
		return "redirect:/marathon/addmarathon/{id_m}";
        }
	}
	/*
	@PostMapping(value = "/addmarathon/{id_m}") // after submit button pressed
	public String addmarathonPost2(@PathVariable(name="id_m") int id_m, Model model, @Valid Marathon marathon, BindingResult result) // filled marathon object data
	{
        if (result.hasErrors()) {
        	System.out.println("yes");
            return "addmarathon";
        }
        
        else
        {      
        	marathonServiceImpl.insertNewMarathon(marathon);
        	Marathon mar = marathonServiceImpl.findByDate(marathon.getDate());
        	
     	
        	
		return "redirect:/marathon/aremarathon/" + mar.getId();
        }
       
	}
	*/
	
} 
