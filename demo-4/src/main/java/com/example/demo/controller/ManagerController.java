package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.email.EmailSender;
import com.example.demo.model.Manager;
import com.example.demo.model.Marathon;
import com.example.demo.model.Registration;
import com.example.demo.model.Group;
import com.example.demo.model.Runner;
import com.example.demo.repo.ManagerRepo;
import com.example.demo.services.ManagerImpl;
import com.example.demo.services.MarathonServiceImpl;
import com.example.demo.services.RegistrationServiceImp;
import com.example.demo.services.GroupServiceImp;


@Controller
@RequestMapping(value="/manager")

public class ManagerController {
	@Autowired
	ManagerImpl managerImpl;
	
	@Autowired
	MarathonServiceImpl marathonServiceImpl; 

	@Autowired
	GroupServiceImp groupServiceImpl;
	
	@Autowired
	RegistrationServiceImp registrationServiceImp;

	@Autowired
	EmailSender mailSender;
	
	

	@GetMapping(value="managermain")
	public String mainManagerGet(Manager manager) {
		return "managermain";
	}
	
	@GetMapping(value="/managerview")
	public String managerview(Model model) {	
		model.addAttribute("object", managerImpl.selectAll());
		return "managerview";
	}
	
	
	
	@GetMapping(value="/addmanager") // localhost:8080/manager/addmanager
	public String addManagerGet(Manager manager, Model model) {
		
		// method
		return "addmanager";	
	}
	
	@GetMapping(value="/loginmanager")
	public String loginManagerGet(Manager manager) {
		return "loginmanager";
	}
	
	@GetMapping(value="/areamanager/{id_m}")
	public String areaManagerGet(@PathVariable(name="id_m")int id, Model model) {
		
		try {
			Manager manager = managerImpl.findByID(id);
			model.addAttribute("name", manager.getName());
			model.addAttribute("surname", manager.getSurname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "areamanager";
	}
	
	@GetMapping(value = "/addmarathon/{id_m}")
	public String addmarathonGet(Marathon marathon, @PathVariable(name="id_m") int id_m) {

		return "addmarathon"; // addmarathon.html
	}
	
	@PostMapping(value="/addmarathon/{id_m}")// after submit button pressed
	public String CreateMarathonPost(@PathVariable(name="id_m") int id_m, Model model, @Valid Marathon marathon, BindingResult result) {
	System.out.println("vau tu nostrada");
		if(result.hasErrors()) {
		return "areamanager";
	}
	else
	{
		   
    	marathonServiceImpl.insertNewMarathon(marathon, id_m);
    	//Marathon mar = marathonServiceImpl.findByDate(marathon.getDate());
    	return "redirect:/manager/manmarathonview";//+mar.getId();
	}
	}

	@GetMapping(value = "/manmarathonview")
	public String marathonview(Model model) {

		model.addAttribute("marathonlist", marathonServiceImpl.selectAll());
		return "manmarathonview";
	}

	@PostMapping(value = "/manmarathonview")
	public String viewMarathon(Marathon marathon) {
		System.out.println(marathon.getId());
		return "redirect:/manager/areamarathon/"+marathon.getId();
	}
	
	/*@GetMapping(value = "/areamarathon/{id_mar}")
	public String allmarathonsviewbyid(@PathVariable(name="id_mar") int id_mar, Model model) {

		System.out.println(id_mar);
		model.addAttribute("marathon", marathonServiceImpl.selectById(id_mar));
		return "areamarathon";
		
	}*/
	@GetMapping(value = "/areamarathon/{id_mar}")
	public String allmarathonsviewbyid(@PathVariable(name="id_mar") int id_mar, Model model, Group group) {

		System.out.println(id_mar);
		model.addAttribute("marathon", marathonServiceImpl.selectById(id_mar));
		/*model.addAttribute("grouplist", groupServiceImpl.selectByMarathon(id_mar));*/
		model.addAttribute("grouplist", groupServiceImpl.selectAll());
		return "areamarathon";
	}

	@PostMapping(value="/areamarathon/{id_mar}")
	public String CreateRegistrationPost(@PathVariable(name="id_mar") int id_mar, Model model, @Valid Registration registration, BindingResult result) {
		if(result.hasErrors()) {
			return "areamanager/{id_m}";
		}
		else
		{
			   
	    	registrationServiceImp.insertNewRegistration(registration);
	    	//Marathon mar = marathonServiceImpl.findByDate(marathon.getDate());
	    	return "redirect:/manager/registrationsuccessful";
		}
		}
	
	@GetMapping(value="/registrationsuccessful")
	public String registrationSuccessful() {
		return "registrationsuccessful";
	}
	
	
	@PostMapping(value="/loginmanager")
	public String loginManagerPost(Manager manager) {
		if(managerImpl.authorizeManager(manager.getEmail(), manager.getPassword())) {
			return "redirect:/manager/areamanager/"+ managerImpl.findManagerId(manager.getEmail());
		}
		
		return "loginmanager";
		}


	
	@PostMapping(value="/addmanager")// after submit button pressed
	public String addManagerPost(@Valid Manager manager, BindingResult result) {
	if(result.hasErrors() && managerImpl.findByEmail(manager.getEmail()) == null) {
		return "addmanager";
	} // TODO Verify if exists this manager (managerImpl function ) 
	else
	{
		managerImpl.insertNewManager(manager);
		String email = manager.getEmail();
		managerImpl.sendRegistrationEmail(email);
	//	managerImpl.sendRegistrationEmail(manager.getEmail());
		//mailSender.sendEmail(manager);
		// call EmailSender function
	}
	return "redirect:/manager/loginmanager";
	}
	
	
	@PostMapping(value="areamanager/{id_m}") // 
	public String createMarathonGet(Manager manager) {
		return "areamanager";
	}
	
	
	@PostMapping(value="/managermain")// after submit button pressed
	public String chooseManagerPost() {

	return "redirect:/manager/managermain";
	}
	
	//@GetMapping(value="/exportdata")
	//public String exportData(Model model) {
	//	managerImpl.exportDataExcel();
		//model.addAttribute("object", );
	//return "exportdata";
	//}
	
	@GetMapping(value = "/updatemanager/{id_m}")
	public String updateMarathonGet(@PathVariable(name = "id_m") int id_m, Model model) {
		try {
			model.addAttribute("manager", managerImpl.findByID(id_m));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "updatemanager";
	}
	
	@PostMapping(value="/updatemanager/{id_m}")
	public String updateManagerPost(@PathVariable(name="id_m") int id_m, Manager manager) {
		managerImpl.updateManager(manager);
		id_m = manager.getId();
		return "redirect:/manager/areamanager/{id_m}";
	}
	


	@GetMapping(value = "/downloadrunnerdata/{id_m}")
	public String downloadDataGet(@PathVariable(name = "id_m") int id_m, Model model) {
		managerImpl.exportDataExcelRunnerList();
		Manager man;
		try {
			man = managerImpl.findByID(id_m);
			String email = man.getEmail();
			managerImpl.sendEmailWithRunList(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return areaManagerGet(id_m, model);
}

}


/* public class ManagerController {
	@Autowired
	ManagerImpl managerImpl;
	
	@Autowired
	EmailSender mailSender;
	
	@Autowired
	MarathonServiceImpl marathonServiceImpl;
	
	

	@GetMapping(value="managermain")
	public String mainManagerGet(Manager manager) {
		return "managermain";
	}
	
	@GetMapping(value="/managerview")
	public String managerview(Model model) {	
		model.addAttribute("object", managerImpl.selectAll());
		return "managerview";
	}
	
	
	
	@GetMapping(value="/addmanager") // localhost:8080/manager/addmanager
	public String addManagerGet(Manager manager, Model model) {
		
		// method
		return "addmanager";	
	}
	
	@GetMapping(value="/loginmanager")
	public String loginManagerGet(Manager manager) {
		return "loginmanager";
	}
	
	@GetMapping(value="/areamanager/{id_m}")
	public String areaManagerGet(@PathVariable(name="id_m")int id, Model model) {
		
		try {
			Manager manager = managerImpl.findByID(id);
			model.addAttribute("name", manager.getName());
			model.addAttribute("surname", manager.getSurname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "areamanager";
	}
	/*@GetMapping(value = "/addmarathon/{id_m}")
	public String addmarathonGet(Marathon marathon, @PathVariable(name="id_m") int id_m) {

	return "addmarathon"; // addmarathon.html
	}

	@PostMapping(value="/addmarathon/{id_m}")// after submit button pressed
	public String CreateMarathonPost(@PathVariable(name="id_m") int id_m, Model model, @Valid Marathon marathon, BindingResult result) {
	if(result.hasErrors()) {
	return "areamanager/{id_m}";
	}
	else
	{
	

	marathonServiceImpl.insertNewMarathon(marathon);
	//Marathon mar = marathonServiceImpl.findByDate(marathon.getDate());
	return "redirect:/manager/areamanager/{id_m}";//+mar.getId();
	}
	*/
	
	
	/*@PostMapping(value="/addmarathon/{id_m}")// after submit button pressed
	public String CreateMarathonPost(@Valid Manager manager, BindingResult result) {
	if(result.hasErrors()) {
		return "areamanager/{id_m}";
	}
	else
	{
		managerImpl.insertNewManager(manager);
	}
	return "redirect:/marathon/addmarathon/{id_m}";
	}

	
	@PostMapping(value="/loginmanager")
	public String loginManagerPost(Manager manager) {
		if(managerImpl.authorizeManager(manager.getEmail(), manager.getPassword())) {
			return "redirect:/manager/areamanager/"+ managerImpl.findManagerId(manager.getEmail());
		}
		
		return "loginmanager";
		}


	
	@PostMapping(value="/addmanager")// after submit button pressed
	public String addManagerPost(@Valid Manager manager, BindingResult result) {
	if(result.hasErrors() && managerImpl.findByEmail(manager.getEmail()) == null) {
		return "addmanager";
	} // TODO Verify if exists this manager (managerImpl function ) 
	else
	{
		managerImpl.insertNewManager(manager);
		String email = manager.getEmail();
		managerImpl.sendRegistrationEmail(email);
	//	managerImpl.sendRegistrationEmail(manager.getEmail());
		//mailSender.sendEmail(manager);
		// call EmailSender function
	}
	return "redirect:/manager/loginmanager";
	}
	
	@PostMapping(value="areamanager/{id_m}") // 
	public String createMarathonGet(Manager manager) {
		return "areamanager";
	}
	
	
	@PostMapping(value="/managermain")// after submit button pressed
	public String chooseManagerPost() {

	return "redirect:/manager/managermain";
	}
	
	@GetMapping(value="/exportdata")
	public String exportData(Model model) {
		managerImpl.exportDataExcel();
	//	model.addAttribute("object",  );
	return "exportdata";
	}
	



	@GetMapping(value = "/addmarathon/{id_m}")
	public String addmarathonGet(Marathon marathon, @PathVariable(name="id_m") int id_m) {

		return "addmarathon"; // addmarathon.html
	}

	@PostMapping(value="/addmarathon/{id_m}")// after submit button pressed
	public String CreateMarathonPost(@PathVariable(name="id_m") int id_m, Model model, @Valid Marathon marathon, BindingResult result) {
		System.out.println(id_m);
		if(result.hasErrors()) {
	return "areamanager";
		}
		else
		{
	   
	marathonServiceImpl.insertNewMarathon(marathon);
	//Marathon mar = marathonServiceImpl.findByDate(marathon.getDate());
	return "redirect:/manager/areamanager/{id_m}"; //+mar.getId();
   }
	}
	

	@GetMapping(value = "/manmarathonview")
 	public String marathonview(Model model, Marathon marathon) {

	model.addAttribute("marathonlist", marathonServiceImpl.selectAll());
	return "manmarathonview";
}

	@PostMapping(value = "/manmarathonview")
	public String viewMarathon(Marathon marathon) {
		System.out.println(marathon.getId());
		return "redirect:/manager/manmarathonview"; //+marathon.getId();
}

	@GetMapping(value = "/areamarathon/{id_mar}")
	public String allmarathonsviewbyid(@PathVariable(name="id_mar") int id_mar, Model model) {

	System.out.println(id_mar);
	model.addAttribute("marathon", marathonServiceImpl.selectById(id_mar));
	return "areamarathon";
}
}

*/
