package com.revature.businesslogic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.Employee;

public class UpdateEmployeeService
{
	EmployeeDAOImpl empDaoObject = new EmployeeDAOImpl();
	public UpdateEmployeeService()
	{
		super();
	}
	
	public void updateEmployeeInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		// get request body and split it into array
		System.out.println(request);
		System.out.println("REQUEST LENGTH: " + request.getContentLength());
		String fullBody = request.getReader().readLine();
		System.out.println("Full request body is: " + fullBody);
		String[] splitBodyAmp = fullBody.split("&");
//		for (String string : splitBodyAmp)
//		{
//			System.out.println(string);
//		}
		
		// isolate username and password from request body and put the full declaration into an array
		String fullBodyUsername = splitBodyAmp[0];
		String fullBodyPassword = splitBodyAmp[1];
		String fullBodyId = splitBodyAmp[2];
		
//		System.out.println("FULL BODY USERNAME " + fullBodyUsername);
//		System.out.println("FULL BODY PASSWORD " + fullBodyPassword);
//		System.out.println("FULL BODY ID " + fullBodyId);
		
		// split username, password and ID arrays to obtain JUST the username, password, and ID
		String[]splitUsername = fullBodyUsername.split("=");
		String[]splitPassword = fullBodyPassword.split("=");
		String[]splitId = fullBodyId.split("=");
		
		String username = splitUsername[1];
		String password = splitPassword[1];
		String stringId = splitId[1];
		
		// verify fields are correct and parse stringID to an int
		System.out.println("USERNAME IS: " + username);
		System.out.println("PASSWORD IS: " + password);
		System.out.println("ID IS: " + stringId);
		int id = Integer.parseInt(stringId);
//				
//		
//		// use int ID to determine which employee to update
		Employee empToUpdate = empDaoObject.getEmployeeByID(id);
		System.out.println("Employee we are updating: " + empToUpdate.toString());
		empToUpdate.setUsername(username);
		empToUpdate.setPassword(password);
		
		// send updatedEmp off to update DAO
		empDaoObject.updateEmployee(empToUpdate);
		
	}
	
	public boolean updatedUsernameNotNull(String username)
	{
		if (username == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean updatedPasswordNotNull(String password)
	{
		if (password == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean updatedUsernameNotEmpty(String username)
	{
		if (username == "")
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean updatedPasswordNotEmpty(String password)
	{
		if (password == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
}
