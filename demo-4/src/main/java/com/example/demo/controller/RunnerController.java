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

import com.example.demo.email.EmailSender;
import com.example.demo.model.Group;
import com.example.demo.model.Marathon;
import com.example.demo.model.Registration;
import com.example.demo.model.Runner;
import com.example.demo.services.GroupServiceImp;
import com.example.demo.services.ManagerImpl;
import com.example.demo.services.MarathonServiceImpl;
import com.example.demo.services.RegistrationServiceImp;
import com.example.demo.services.RunnerServiceIMP;

import ch.qos.logback.core.joran.conditional.ElseAction;

@Controller
@RequestMapping(value="/runner")
public class RunnerController {
	
	@Autowired
	RunnerServiceIMP runnerserviceimp;
	
	@Autowired
	EmailSender mailSender;
	
	@Autowired
	ManagerImpl managerImpl;
	
	@Autowired
	MarathonServiceImpl marathonServiceImpl;

	@Autowired
	GroupServiceImp groupServiceImp;
	
	@Autowired
	RegistrationServiceImp registrationServiceImp;

	@GetMapping(value="/main")
	public String main(Runner runner) {
		return "main";
	
		
	}
	@GetMapping(value="/runnerview/{id_r}")
		public String runnerview(@PathVariable(name="id_r") int id, Runner runner,Model model) {
		try{
		Runner run = runnerserviceimp.selectById(id);
		
		model.addAttribute("name", run.getName());
		model.addAttribute("surname", run.getSurname());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "runnerview";
	}
	
	
	@GetMapping(value = "/runnerregister") //localhost:8080/RunnerRegister
	public String RunnerRegister(Runner runner) { 
		
		return "runnerregister";
	}
	
	@PostMapping(value = "/runnerregister") //localhost:8080/RunnerRegister
	public String RunnerRegisterPost(@Valid Runner runner,BindingResult result) { 
		
		if(result.hasErrors() && runnerserviceimp.findByEmail(runner.getEmail()) == null)
			return "runnerregister";
		
		else 
		runnerserviceimp.insertNewRunner(runner);
		String email = runner.getEmail();
		runnerserviceimp.sendRegistrationEmail(runner.getEmail());
		return "redirect:/runner/runnerlogin";
	}
	
	

	
	@GetMapping(value = "/runnerlogin")
	public String RunnerLogin(Runner runner) {
		
	return "runnerlogin";	
	}

	@PostMapping(value = "/runnerlogin")
	public String RunnerLoginpost(@Valid Runner runner, BindingResult result)
	{
		if(result.hasErrors()){
			System.out.println("Nepareizi");
			return "runnerlogin";
		}

		boolean isInSystem= runnerserviceimp.autorizeRunner(runner.getEmail(),runner.getPassword());
		if(isInSystem) {
				System.out.println("Pareizi");
				Runner runnertemp= runnerserviceimp.findByEmail(runner.getEmail());
				managerImpl.exportDataExcel();
				String email = runner.getEmail();
				runnerserviceimp.sendEmailWithAttachment(email);
				return "redirect:/runner/runnerview/"+runnertemp.getId_r();
				
			}else{
		return "runnerlogin";
	}
}
		
/*	@GetMapping(value="/firstpage") // localhost:8080/firstpage
	public String chooseRunnerGet() {
			// method
			return "firstpage";	
		}
		*/
	
	@PostMapping(value="/main")// after submit button pressed
	public String chooseRunnerPost() {

	return "redirect:/runner/main";
	}
		
	//@PostMapping(value="Runner")// after submit button pressed
	//public String chooseRunnerPost() {

		//return "redirect:/runner/runnerregister";
		//}
	@GetMapping(value="/updaterunner/{id_r}")
		public String updaterunner(@PathVariable(name = "id_r") int id_r, Model model) {
			model.addAttribute("runner", runnerserviceimp.selectById(id_r));

		
		return "updaterunner";

	}
	@PostMapping(value = "/updaterunner/{id_r}")
	public String runnerpost(@PathVariable(name = "id_r") int id_r, Runner runner) {
		runnerserviceimp.updateRunnerById(runner, id_r);
	
		return "redirect:/runner/runnerview/{id_r}";
	}
	@GetMapping(value = "/allrunners")
	public String allcarsview(Model model) {

		model.addAttribute("runnerslist", runnerserviceimp.selectAll());
		return "allrunners";
	}
	
	@GetMapping(value = "/searchrunner")
		public String searchrunner(Runner runner) {
			
		
		return "searchrunner";
		}
	@GetMapping(value = "/manmarathonview/{id_r}")
	public String marathonview(@PathVariable(name = "id_r") int id_r, Model model) {

		model.addAttribute("marathonlist", marathonServiceImpl.selectAll());
		return "manmarathonview";
	}

	@PostMapping(value = "/manmarathonview/{id_r}")
	public void viewMarathon(@PathVariable(name = "id_r") int id_r,Marathon marathon) {
		System.out.println(marathon.getId());
		//return "redirect:/runner/manmarathonview/"+ id_r;
	}

	@GetMapping(value = "/areamarathon/{id_r}/{id_mar}")
	public String allmarathonsviewbyid(@PathVariable(name="id_r") int id_r,@PathVariable(name="id_mar") int id_mar, Model model, Group group) {

		//System.out.println(id_mar);
		model.addAttribute("marathon", marathonServiceImpl.selectById(id_mar));
		/*model.addAttribute("grouplist", groupServiceImpl.selectByMarathon(id_mar));*/
		model.addAttribute("grouplist", groupServiceImp.selectAll());
		return "areamarathon";
	}

	@PostMapping(value="/areamarathon/{id_r}/{id_mar}")
	public String CreateRegistrationPost(@PathVariable(name="id_r") int id_r, @PathVariable(name="id_mar") int id_mar, Model model, @Valid Registration registration, BindingResult result) {
		
		
		if(result.hasErrors()) {
			return "areamanager/{id_m}";
		}
		else
		{
			   
	    registrationServiceImp.insertNewRegistration(registration);
	    	//Marathon mar = marathonServiceImpl.findByDate(marathon.getDate());
	    	return "redirect:/runner/registrationsuccessful/"+id_r;
		}
		}

	@GetMapping(value="/registrationsuccessful/{id_r}")
	public String registrationSuccessful(@PathVariable(name="id_r") int id_r) {
		return "registrationsuccessful";
	}

	
	
	
}
