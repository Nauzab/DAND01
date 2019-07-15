package com.example.demo.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.demo.model.Manager;
import com.example.demo.repo.ManagerRepo;

@RunWith(MockitoJUnitRunner.class)
public class TestManagerService {
	
	@Mock // simulate repository
	ManagerRepo managerRepo;
	
	ManagerImpl managerImpl;
	
	ArrayList<Manager> managersSimulation = new ArrayList<>();
	Manager manager1; 
	Manager manager2;
	
	@Before
	public void setup()
	{
		managerImpl = new ManagerImpl();
		ReflectionTestUtils.setField(managerImpl, "managerRepo", managerRepo);
		manager1 = new Manager("Peter", "Parker", "spiderman@spiderman.com", "SpiderMan19");
		manager2 = new Manager("Mary", "Jane", "mary@mary.com", "mary123");
		
		managersSimulation.add(manager1);
		managersSimulation.add(manager2);
	}
	
	@Test
	public void getManagersService() {
		when(managerRepo.findAll()).thenReturn(managersSimulation);
		
		ArrayList<Manager> retrieveManagers = managerImpl.selectAll();
		assertEquals(managersSimulation, retrieveManagers);
		}
	
	@Test
	public void testGetManagerServiceEmpty()
	{
		ArrayList<Manager> emptyManagerList = new ArrayList<Manager>();
		when(managerRepo.findAll()).thenReturn(emptyManagerList);
		ArrayList<Manager> retrieveManagers = managerImpl.selectAll();
		assertEquals(emptyManagerList, retrieveManagers);
		
	}
	

}
