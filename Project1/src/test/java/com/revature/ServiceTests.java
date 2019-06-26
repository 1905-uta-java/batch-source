package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.revature.service.EmployeeService;
import com.revature.service.ProfileService;
import com.revature.service.ReimbursementService;

public class ServiceTests {
	
	private static final ProfileService pServ = new ProfileService();
	private static final EmployeeService eServ = new EmployeeService();
	private static final ReimbursementService rServ = new ReimbursementService();
	
	@Test
	public void invalidUser() {
		assertNull(pServ.getUserByUserName("invalid", "userandpassword"));
	}
	
	@Test
	public void emptyUsername() {
		assertNull(pServ.getUserByUserName("", "highnoon12"));
	}
	
	@Test
	public void emptyPassword() {
		assertNull(pServ.getUserByUserName("sickshooter", ""));
	}
	
	@Test
	public void validUser() {
		assertNotNull(pServ.getUserByUserName("sickshooter", "highnoon12"));
	}
	
	@Test
	public void invalidId() {
		assertNull(pServ.getUserById(0));
	}
	
	@Test
	public void negativeId() {
		assertNull(pServ.getUserById(-2));
	}
	
	@Test
	public void normalNumberInvalidId() {
		assertNull(pServ.getUserById(89));
	}
	
	@Test
	public void validId() {
		assertNotNull(pServ.getUserById(100));
	}
	
	@Test
	public void invalidPasswordLength() {
		assertEquals(0, pServ.setPassword("short", 100));
	}
	
	@Test
	public void emptyStringPassword() {
		assertEquals(0, pServ.setPassword("", 100));
	}
	
	@Test 
	public void nullStringPassword() {
		assertEquals(0, pServ.setPassword(null, 100));
	}
	
	@Test 
	public void emptyStringUsername() {
		assertEquals(0, pServ.setUsername("", 100));
	}
	
	@Test
	public void nullStringUsername() {
		assertEquals(0, pServ.setUsername(null,  100));
	}
	
	@Test
	public void noUserById() {
		assertEquals(0, pServ.setPassword("somepassword", 101));
	}
	
	@Test
	public void nullEmpId() {
		assertEquals(0, pServ.setPassword("somepassword", 0));
	}
	
	@Test
	public void negativeEmpId() {
		assertEquals(0, pServ.setPassword("somepassword", -32));
	}
	
	@Test
	public void successPasswordChange() {
		assertEquals(1,pServ.setPassword("trialacc6", 2));
	}
	
	@Test
	public void successUsernameChange() {
		assertEquals(1, pServ.setUsername("trial", 2));
	}
	
	
}
