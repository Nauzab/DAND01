package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Manager;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestManagerModel {
	
	Manager manager1; 
	Manager manager2;
	
	@Before
	public void setup()
	{
		manager1 = new Manager("Peter", "Parker", "spiderman@spiderman.com", "SpiderMan19");
		manager2 = new Manager("   12", "saf@45", "email", "");
	}
	
	@Test
	public void testManager1() {
		assertEquals("Manager's name", "Peter", manager1.getName());
		assertEquals("Manager's surname", "Parker", manager1.getSurname());
		assertEquals("Manager's e-mail", "spiderman@spiderman.com", manager1.getEmail());
		assertEquals("Manager's password", "SpiderMan19", manager1.getPassword());
	}
	@Test
	public void testManager2() {
		assertEquals("Manager's name", "", manager2.getName());
		assertEquals("Manager's surname", "", manager2.getSurname());
		assertEquals("Manager's e-mail", "", manager2.getEmail());
		assertEquals("Manager's password", "", manager2.getPassword());
	}
	
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	

}
