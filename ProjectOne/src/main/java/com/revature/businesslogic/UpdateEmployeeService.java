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
	
	public void updateEmployeeInfo(HttpServletRequest request, HttpServletResponse response, String username, String password, String stringId) throws IOException, ServletException
	{
		
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
			System.out.println("Username is null!");
			return false;
		}
		else
		{
			System.out.println("Username is not null!");
			return true;
		}
	}
	
	public boolean updatedPasswordNotNull(String password)
	{
		if (password == null)
		{
			System.out.println("Password is null!");
			return false;
		}
		else
		{
			System.out.println("Password is not null");
			return true;
		}
	}
	
	public boolean updatedUsernameNotEmpty(String username)
	{
		if (username == "")
		{
			System.out.println("Username is empty!");
			return false;
		}
		else
		{
			System.out.println("Username is not empty!");
			return true;
		}
	}
	
	public boolean updatedPasswordNotEmpty(String password)
	{
		if (password == "")
		{
			System.out.println("Password is empty!");
			return false;
		}
		else
		{
			System.out.println("Password is not empty!");
			return true;
		}
	}
	
	
}
