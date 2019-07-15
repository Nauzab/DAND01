package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Manager;
import com.example.demo.model.Runner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRunnerModel {
	
	Runner runner1;
	Runner runner2;
	
	@Before
	public void setup()
	{
		runner1 = new Runner("Peter", "Parker", "male", "SpiderMan19", "spiderman@spiderman.com");
		runner2 = new Runner("   12", "saf@45", "goodguy", "email", "");
	}

	@Test
	public void testRunner1() {
		assertEquals("Runner's name", "Peter", runner1.getName());
		assertEquals("Runner's surname", "Parker", runner1.getSurname());
		assertEquals("Runner's e-mail", "spiderman@spiderman.com", runner1.getEmail());
		assertEquals("Runner's password", "SpiderMan19", runner1.getPassword());
	}
}
