package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.model.Administrator;

public class AdminClassTest {
	Administrator administrator1 = new Administrator(null, null, null, null);
	Administrator administrator2 = new Administrator("Peter", "Parker", "spiderman@spiderman.com", "SpiderMan19");
	@Test	
	public void testManagerName() {
		assertEquals(null, administrator1.getName());
	}
		
	@Test
	public void testManagerSurname() {
		assertEquals(null, administrator1.getName());
	}
	
	@Test
	public void testManagerEmail() {
		assertEquals(null, administrator1.getEmail());
	}
	
	@Test
	public void testManagerPassword() {
		assertEquals(null, administrator1.getPassword());
		
		
	}
	@Test	
	public void testManagerName2() {
		assertEquals("Peter", administrator2.getName());
	}
		
	@Test
	public void testManagerSurname2() {
		assertEquals("Parker", administrator2.getName());
	}
	
	@Test
	public void testManagerEmail2() {
		assertEquals("spiderman@spiderman.com", administrator2.getEmail());
	}
	
	@Test
	public void testManagerPassword2() {
		assertEquals("SpiderMan19", administrator2.getPassword());
		
	}
	

}