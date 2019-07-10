package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Manager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerClassTest {
	Manager manager1 = new Manager(null, null, null, null);
	Manager manager2 = new Manager("Peter", "Parker", "spiderman@spiderman.com", "SpiderMan19");
	@Test	
	public void testManagerName() {
		assertEquals(null, manager1.getName());
	}
		
	@Test
	public void testManagerSurname() {
		assertEquals(null, manager1.getName());
	}
	
	@Test
	public void testManagerEmail() {
		assertEquals(null, manager1.getEmail());
	}
	
	@Test
	public void testManagerPassword() {
		assertEquals(null, manager1.getPassword());
		
		
	}
	@Test	
	public void testManagerName2() {
		assertEquals("Peter", manager2.getName());
	}
		
	@Test
	public void testManagerSurname2() {
		assertEquals("Parker", manager2.getName());
	}
	
	@Test
	public void testManagerEmail2() {
		assertEquals("spiderman@spiderman.com", manager2.getEmail());
	}
	
	@Test
	public void testManagerPassword2() {
		assertEquals("SpiderMan19", manager2.getPassword());
		
	}
	
	

}