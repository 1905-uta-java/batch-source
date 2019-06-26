package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.businesslogic.AuthenticationService;
import com.revature.businesslogic.CreateRequestService;
import com.revature.businesslogic.UpdateEmployeeService;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.RequestDAOImpl;




public class UpdateUsernameTests
{
	static UpdateEmployeeService updateEmpService = new UpdateEmployeeService();
	
	@Test
	public void testUpdatedUsernameNotNull()
	{
		String username = null;
		updateEmpService.updatedUsernameNotEmpty(username);
		assertFalse(updateEmpService.updatedPasswordNotNull(username));
	}
	
	@Test
	public void testUpdatedPasswordNotNull()
	{
		String password = null;
		updateEmpService.updatedPasswordNotEmpty(password);
		assertFalse(updateEmpService.updatedPasswordNotNull(password));
	}
	
	
	@Test
	public void testUpdatedUsernameNotEmpty()
	{
		String username = "";
		updateEmpService.updatedUsernameNotEmpty(username);
		assertFalse(updateEmpService.updatedUsernameNotEmpty(username));
	}
	
	@Test
	public void testUpdatedPasswordNotEmpty()
	{
		String password = "";
		updateEmpService.updatedUsernameNotEmpty(password);
		assertFalse(updateEmpService.updatedPasswordNotEmpty(password));
	}
}
