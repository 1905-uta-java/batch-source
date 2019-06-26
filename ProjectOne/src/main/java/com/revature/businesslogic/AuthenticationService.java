package com.revature.businesslogic;

import java.util.List;

import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.Employee;

public class AuthenticationService
{
	// create an instance of the employeeDaoImpl class to use
		EmployeeDAOImpl empDaoObject = new EmployeeDAOImpl();

	public AuthenticationService()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee verifyEmployee(String username, String password)
	{	
		// VERIFY HERE
		// IF VERIFED, MAKE TOKEN
		// IF NOT VERIFIED, SEND EM BACK TO USER LOGIN
		List<Employee> allEmployees = empDaoObject.getEmployees();
		
		for (Employee e : allEmployees)
		{
			System.out.println("Retrieved employee ID is: " + e.toString());
			System.out.println("Username entered: " + e.getUsername());
			System.out.println("Password entered: " + e.getPassword());
			System.out.println("Username we got: " + username);
			System.out.println("Password we got " + password); 
			
			if (username.equals(e.getUsername()) && password.equals(e.getPassword()))
			{
				System.out.println("YOU ARE IN OUR SYSTEM!");
				return e;
			}
		}
		
		return null;
	}
	
	public boolean isAuthorized(String token) 
	{
		if (token != null && token.split(":").length == 2) 
		{
			String idStr = token.split(":")[0];
			System.out.println("ID is: " + idStr);
			String position = token.split(":")[1];
			System.out.println("Position is: " + position);
			if (idStr.matches("^\\d+$")) 
			{
				Employee e = empDaoObject.getEmployeeByID(Integer.parseInt(idStr));
				if(e != null && e.getPosition().equals(position)) 
				{
					System.out.println("TOKEN IS GOOD!");
					return true;
				}
			}
		}
		System.out.println("YOUR TOKEN SUCKS!");
		return false;
	}
	
	public String authenticateEmployee(Employee e)
	{
		// Don't forget to replace this here!
		System.out.println("You are about to be authenticated!");
		System.out.println(e.toString() + "is you!");
		String token = e.getEmpID() + ":" + e.getPosition();
		System.out.println("Your token is: " + token);
		return token;
		
	}
	
	public boolean usernameIsNotNull(String username)
	{
		if (username != null)
		{
			System.out.println("Username is not null!");
			return true;
		}
		else
		{
			System.out.println("Username is null!");
			return false;
		}
	}
	
	public boolean passwordIsNotNull(String password)
	{
		if (password != null)
		{
			System.out.println("Password is not null!");
			return true;
		}
		else
		{
			System.out.println("Password is null!");
			return false;
		}
	}
	
	public boolean usernameIsNotBlank(String username)
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
	
	public boolean passwordIsNotBlank(String password)
	{
		if (password == "")
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
