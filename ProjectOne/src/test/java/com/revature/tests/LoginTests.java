package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.businesslogic.AuthenticationService;
import com.revature.businesslogic.CreateRequestService;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.RequestDAOImpl;


public class LoginTests
{

	static CreateRequestService requestServiceTool = new CreateRequestService();
	static EmployeeDAOImpl empDaoObject = new EmployeeDAOImpl();
	static RequestDAOImpl reqDaoObject = new RequestDAOImpl();
	static AuthenticationService as = new AuthenticationService();	

	@Test
	public void testUsernameIsNotNull1()
	{
		String username = "username";
		assertTrue(as.usernameIsNotNull(username));
	}
	
	@Test
	public void testUsernameIsNotNull2()
	{
		String username = null;
		assertFalse(as.usernameIsNotNull(username));
	}
	
	@Test
	public void testPasswordIsNotNull1()
	{
		String password = "password";
		assertTrue(as.passwordIsNotNull(password));
	}
	
	@Test
	public void testPasswordIsNotNull2()
	{
		String password = null;
		assertFalse(as.passwordIsNotNull(password));
	}
	
	
}
