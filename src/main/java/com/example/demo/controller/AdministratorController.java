package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Administrator;
import com.example.demo.model.Manager;
import com.example.demo.model.Marathon;
import com.example.demo.model.Runner;
import com.example.demo.services.AdministratorServiceImp;
import com.example.demo.services.ManagerService;
import com.example.demo.services.MarathonService;
import com.example.demo.services.RunnerService;

@Controller
@RequestMapping(value = "/admin")
public class AdministratorController {
	
	@Autowired
	AdministratorServiceImp adminService;
	
	@Autowired
	ManagerService manService;
	
	@Autowired 
	RunnerService runnerService;
	
	@Autowired
	MarathonService marathonService;

	
	@GetMapping(value = "/authorizeAdmin")
	public String authorizeAdminGet(Administrator adminstrator) {
		
		
		return "authorizeadmin" ;
	}
	
	@PostMapping(value = "/authorizeAdmin")
	public String authorizeAdminPost(@Valid Administrator administrator, BindingResult result) {
		
		
		boolean temp = adminService.authorizeAdmin(administrator.getEmail(), administrator.getPassword());
		if(result.hasErrors()) {
			
			return "authorizeadmin";
		}
		
		if(temp) 
			return "redirect:/admin/adminmain";
		
		
	
		return "authorizeadmin";
	}
	
	@GetMapping(value = "/adminmain")
	public String adminmain() {
		
		return "adminmain";
	}
	//----------------End of Autorize admin--------------//
	
	//----------------Admin logout----------------------//
	
	@GetMapping(value = "adminlogout")
	public String adminlogout() {
		
		return "redirect:/firstpage";
	}
	//----------------end of admin logout---------------//
	
	//---------------Create new Admin-------------------//
	@GetMapping(value = "/createadmin")
	public String createAdminGet(Administrator administrator) { 
		
		
		return "createadmin" ;
	}
	
	@PostMapping(value = "/createadmin")
	public String createAdminPost(@Valid Administrator administrator ,BindingResult result ) {
		
		if(result.hasErrors()) {
			return "createadmin";
		}
		
		adminService.insertnewAdmin(administrator);
		
		return "redirect:/admin/adminmain" ;
		
		
	}
	//---------------End of new Admin creation---------// 
	
	
	
	
	
	//---------------Delete Admin---------------------//
	@GetMapping(value = "/adminview")
	public String adminview(Model model) {

		model.addAttribute("adminlist", adminService.selectAll());
		return "adminview";
	}
	
	@GetMapping(value = "/deleteadmin")
	public String deleteadminviewGet(Model model, Administrator administrator) {

		model.addAttribute("alist", adminService.selectAll());
		return "deleteadmin";
	}
	
	@PostMapping(value = "/deleteadmin")
	public String deleteadminviewPost(Administrator administrator) {
		
		
		return "redirect:/admin/deleteAdmin/"+ administrator.getId_a();
	}
	
	@GetMapping(value = "/deleteAdmin/{id}")
	public String deleteAdminGet(@PathVariable(name = "id") int id) {
		
		adminService.deleteAdminById(id);
		return "redirect:/admin/deleteadmin";
	}
	//---------------End of admin deletion-----------//
	
	
	
	///----------------DELETE MARATHON---------------------//
	@GetMapping(value = "/adminmarathonview")
	public String marathonview(Model model) {

		model.addAttribute("marathonlist", marathonService.selectAll());
		return "adminmarathonview";
	}
	
	@GetMapping(value = "/deletemarathon")
	public String deletemarathonviewGet(Model model, Marathon marathon) {

		model.addAttribute("mar", marathonService.selectAll());
		return "deletemarathon";
	}
	
	@PostMapping(value = "/deletemarathon")
	public String deletemarathonviewPost(Marathon marathon) {
		
		
		return "redirect:/admin/deleteMarathon/"+ marathon.getId();
	}
	
	@GetMapping(value = "/deleteMarathon/{id}")
	public String deleteMarathonGet(@PathVariable(name = "id") int id) {
		
		marathonService.deleteMarathonById(id);
		return "redirect:/admin/deletemarathon";
	}
	///---------------------END OF DELETE MARATHON-------------------------///
	
	
	
	//-------------------------CREATE/DELETE MANAGER------------------------///

	@GetMapping(value = "/createManager")
	public String createManagerGet(Manager manager) { 
		
		
		return "createmaneger" ;
	}
	
	@PostMapping(value = "/createManager")
	public String createManegerPost(@Valid Manager manager ,BindingResult result ) {
		
		if(result.hasErrors()) {
			return "createmaneger";
		}
		
		manService.insertNewManager(manager);
		
		return "redirect:/admin/adminmain" ;
		
		
	}
	
	@GetMapping(value = "/adminmanagerview")
	public String managerview(Model model) {

		model.addAttribute("manager", manService.selectAll());
		return "adminmanagerview";
	}
	
	
	@GetMapping(value = "/admindeletemanager")
	public String deletemanagerviewGet(Model model, Manager manager) {

		model.addAttribute("mar", manService.selectAll());
		return "admindeletemanager";
	}
	
	@PostMapping(value = "/admindeletemanager")
	public String deletemanagerviewPost(Manager manager) {
		
		
		return "redirect:/admin/deleteManager/"+ manager.getId();
	}
	
	@GetMapping(value = "/deleteManager/{id}")
	public String deleteManagerGet(@PathVariable(name = "id") int id) {
		
		adminService.deleteManagerById(id);
		return "redirect:/admin/admindeletemanager";
	}
	
	///-------------------------END OF CREATE/DELETE MANAGER------------\\\
	
	///-------------------------------CREATE/DELETE RUNNER--------------////
	@GetMapping(value = "/createRunner")
	public String createRunnerGet(Runner runner) {
		
		
		return "createrunner" ;
	}
	
	@PostMapping(value = "/createRunner")
	public String createRunnerPost(@Valid Runner runner ,BindingResult result ) {
		
		if(result.hasErrors()) {
			return "createrunner";
		}
		
		runnerService.insertNewRunner(runner);
		
		return "redirect:/admin/adminmain" ;
		
	}
	
	
	@GetMapping(value = "/adminrunnerview")
	public String deleterunnerviewGet(Model model) {

		model.addAttribute("run", runnerService.selectAll());
		return "adminrunnerview";
	}
	
	@GetMapping(value = "/admindeleterunner")
	public String deleterunnerviewGet(Model model, Runner runner) {

		model.addAttribute("nun", runnerService.selectAll());
		return "admindeleterunner";
	}
	
	@PostMapping(value = "/admindeleterunner")
	public String deleterunnerviewPost(Runner runner) {
		System.out.println(runner.getId_r());
		
		return "redirect:/admin/deleteRunner/"+ runner.getId_r();
	}
	
	
	@GetMapping(value = "/deleteRunner/{id}")
	public String deleteRunnerGet(@PathVariable(name = "id") int id) {
		
		adminService.deleteRunnerById(id);
		return "redirect:/admin/admindeleterunner";
	}
	//----------------------END OF CREATE/DELETE RUNNER------------------///
	

}
