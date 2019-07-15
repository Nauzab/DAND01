package com.example.demo.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Manager;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestManagerRepo {

	@Autowired
	ManagerRepo managerRepo;
	
	Manager manager1; 
	Manager manager2; 
	
	@Before
	public void setup()
	{
		manager1 = new Manager("Peter", "Parker", "spiderman@spiderman.com", "SpiderMan19");
		manager2 = new Manager("Mary", "Jane", "mary@mary.com", "Mary19");
	}
	
	/*@Test
	public void testIdGenerator() {
		managerRepo.save(manager1);
		for (Manager manager : managerRepo.findAll()) {
			if(manager.getName().equals(manager1.getName()) && 
			manager.getSurname().equals(manager1.getSurname()) && 
			manager.getEmail().equals(manager1.getEmail()) && 
			manager.getPassword().equals(manager1.getPassword())) 
			{
				assertEquals(1, manager.getId());
			}
		
		}
	}
	
	@Test
	public void testManagerInsert() {
		managerRepo.save(manager1);
		for (Manager manager : managerRepo.findAll()) {
			if(manager.getName().equals(manager1.getName()) && 
			manager.getSurname().equals(manager1.getSurname()) && 
			manager.getEmail().equals(manager1.getEmail()) && 
			manager.getPassword().equals(manager1.getPassword())) 
			{
				assertEquals(manager1.getName(), manager.getName());
				assertEquals(manager1.getSurname(), manager.getSurname());
				assertEquals(manager1.getEmail(), manager.getEmail());
				assertEquals(manager1.getPassword(), manager.getPassword());
			}
		}
	}
	
	
	
	
	@Test
	public void testManagerUpdate() {
		managerRepo.save(manager2); // save new manager Mary Jane
		Manager retrieveManager = managerRepo.findById(1).get();
		// change manager to Gwen Stacy
		retrieveManager.setName("Gwen");
		retrieveManager.setSurname("Stacy");
		managerRepo.save(retrieveManager);
		Manager retrieveManagerAfterUpdate = managerRepo.findById(1).get();
		assertEquals("Gwen", retrieveManagerAfterUpdate.getName());
		assertEquals("Gwen", retrieveManagerAfterUpdate.getSurname());
		
	}
	*/
	
	
	@Test
	public void testManagerDelete() 
	{
		managerRepo.save(manager2);
		long count = managerRepo.count();
		
		managerRepo.delete(manager2);
		long countAfterDelete = managerRepo.count();
		assertEquals("delta after removing one subject must be 1", 1, count-countAfterDelete);
		
		
	}
	

}
