package com.revature.tests;
import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.businesslogic.AuthenticationService;
import com.revature.businesslogic.CreateRequestService;
import com.revature.businesslogic.SelectEmployeeService;
import com.revature.businesslogic.SelectRequestService;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.RequestDAOImpl;

public class GetReqsForSingleEmpTests
{
	static CreateRequestService requestServiceTool = new CreateRequestService();
	static EmployeeDAOImpl empDaoObject = new EmployeeDAOImpl();
	static RequestDAOImpl reqDaoObject = new RequestDAOImpl();
	static AuthenticationService as = new AuthenticationService();
	static SelectRequestService selectReqTool = new SelectRequestService();
	static SelectEmployeeService selectEmpService = new SelectEmployeeService();
	
	@Test
	public void testIdEnteredIsNumber()
	{
		String id = "q";
		assertTrue(selectReqTool.enteredIdIsNonNumber(id));
	
	}
	
	@Test
	public void testIdNotAboveMaxId()
	{
		String enteredId = "5";
		int maxId = 4;
		assertTrue(selectReqTool.enteredIdAboveMaxId(enteredId));
	}

}
