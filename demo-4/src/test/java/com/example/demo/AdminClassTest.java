package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.model.Administrator;

public class AdminClassTest {
	Administrator administrator1 = new Administrator(null, null, null, null);
	Administrator administrator2 = new Administrator("Peter", "Parker", "SpiderMan19", "spiderman@spiderman.com");
	@Test	
	public void testAdminName() {
		assertEquals(null, administrator1.getName());
	}
		
	@Test
	public void testAdminSurname() {
		assertEquals(null, administrator1.getName());
	}
	
	@Test
	public void testAdminEmail() {
		assertEquals(null, administrator1.getEmail());
	}
	
	@Test
	public void testManagerPassword() {
		assertEquals(null, administrator1.getPassword());
		
		
	}
	@Test	
	public void testAdminName2() {
		assertEquals("Peter", administrator2.getName());
	}
		
	@Test
	public void testAdminSurname2() {
		assertEquals("Parker", administrator2.getSurname());
	}
	
	@Test
	public void testAdminEmail2() {
		assertEquals("spiderman@spiderman.com", administrator2.getEmail());
	}
	
	@Test
	public void testAdminPassword2() {
		assertEquals("SpiderMan19", administrator2.getPassword());
		
	}
	

}