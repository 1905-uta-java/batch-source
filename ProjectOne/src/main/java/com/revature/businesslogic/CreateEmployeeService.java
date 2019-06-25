package com.revature.businesslogic;

import java.util.Scanner;

import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.Employee;

public class CreateEmployeeService
{
	
	public CreateEmployeeService()
	{
		super();
	}
	
	public Employee makeEmployee(EmployeeDAOImpl empDaoObject)
	{
		// make employee object, scanner object, and empty fields
		Employee testEmployee = new Employee();
		Scanner readInput = new Scanner(System.in); 
		int empID = empDaoObject.getMaxEmpID() + 1; 
		String firstname = "";
		String lastname = "";
		String username = "";
		String password = "";
		String position = "";
		
		testEmployee.setEmpID(empID);
		
		System.out.println("Please type in fields for first name, last name, username, password, and position. An ID has been provided ");
		
		while (readInput.hasNext())
		{
			firstname = readInput.next();
			System.out.println("You entered " + firstname);
			testEmployee.setFirstname(firstname);
			
			lastname = readInput.next();
			System.out.println("You entered " + lastname);
			testEmployee.setLastname(lastname);
			
			username = readInput.next();
			System.out.println("You entered " + username);
			testEmployee.setUsername(username);
			
			password = readInput.next();
			System.out.println("You entered " + password);
			testEmployee.setPassword(password);
			
			position = readInput.next();
			System.out.println("You entered " + position);
			testEmployee.setPosition(position);
			
			if (firstname != null && lastname != null && username != null && password != null && position != null)
			{
				System.out.println("All fields have values");
				break;
			}
		}
				
		System.out.println(testEmployee.toString());
		
		return testEmployee;
		
		
	}
}
