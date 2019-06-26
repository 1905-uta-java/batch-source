package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.businesslogic.AuthenticationService;
import com.revature.businesslogic.CreateRequestService;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.RequestDAOImpl;


public class CreateRequestInputTests
{

	static CreateRequestService requestServiceTool = new CreateRequestService();
	static EmployeeDAOImpl empDaoObject = new EmployeeDAOImpl();
	static RequestDAOImpl reqDaoObject = new RequestDAOImpl();
	static AuthenticationService as = new AuthenticationService();
	
	@Test
	public void testOnlyNumbersInAmmount()
	{
		String ammount = "1a234";
		assertTrue(requestServiceTool.nonNumbersInAmmount(ammount));
	}
	
	@Test
	public void testNoNumbersInReason()
	{
		String reason = "bec1ause";
		assertTrue(requestServiceTool.numbersInReason(reason));
	}
}