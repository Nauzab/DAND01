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
		runner1 = new Runner("Peter", "Parker", "male", "spiderman@spiderman.com", "SpiderMan19");
		runner2 = new Runner("   12", "saf@45", "goodguy", "email", "");
	}

	
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
