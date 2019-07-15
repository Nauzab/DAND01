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
		manager1 = new Manager("Peter", "Parker", "SpiderMan19", "spiderman@spiderman.com");
	}
	
	@Test
	public void testManager1() {
		assertEquals("Manager's name", "Peter", manager1.getName());
		assertEquals("Manager's surname", "Parker", manager1.getSurname());
		assertEquals("Manager's e-mail", "spiderman@spiderman.com", manager1.getEmail());
		assertEquals("Manager's password", "SpiderMan19", manager1.getPassword());
	}

	
	

}
