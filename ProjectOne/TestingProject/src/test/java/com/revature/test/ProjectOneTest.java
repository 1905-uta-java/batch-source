package com.revature.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class ProjectOneTest {
	
	private static final EmployeeDaoImpl edmpDao = new EmployeeDaoImpl();

	@Test
	public void testGetEmployees() {
		   
		assertEquals(Arrays.asList(0, "Customer1", "Customer2",0,"Customer3","Customer4"), edmpDao.getEmployees());

	}

	@Test
	public void testGetEmployeesByStatus() {
		
		assertEquals(Arrays.asList(0, "Customer1", "Customer2",0,"Customer3","Customer4"), edmpDao.getEmployeesByStatus());
		
	}

	@Test
	public void testAuthenticatedUser() {
		
		assertTrue(edmpDao.AuthenticatedUser("John@example.com","Password"));
		
	}

	@Test
	public void testAuthenticatedPosition() {
		
		assertTrue(edmpDao.AuthenticatedUser("John@example.com","Password"));
	}

	@Test
	public void testCreateEmployee() {
		
		Employee emp = new Employee();
		
		assertEquals(1, edmpDao.CreateEmployee(emp));
		
	}

	@Test
	public void testUpdateEmployee() {
		
		
		assertEquals(1, edmpDao.updateEmployee("John@example.com"));
	}

	@Test
	public void testUpdateReimburstment() {
		
		assertEquals(1, edmpDao.updateReimburstment(100, "Pending","John@example.com"));
		
	}

	@Test
	@Ignore
	public void testUpdateEmployee2() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		
		assertEquals(1, edmpDao.deleteEmployee("Jack@example.com"));
		
	}

}
