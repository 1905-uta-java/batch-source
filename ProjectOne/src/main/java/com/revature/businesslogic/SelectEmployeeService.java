package com.revature.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.RequestDAOImpl;
import com.revature.models.Employee;

public class SelectEmployeeService
{
	EmployeeDAOImpl empDaoObject = new EmployeeDAOImpl();
	public SelectEmployeeService()
	{
		super();
	}
	
	public void getEmployeeInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("MADE IT TO SELECT EMP INFO SERVICE!");
		
		// get ID to select
		String token = request.getParameter("token");
		System.out.println(token);
		String stringID = token.substring(0, 1);
		int id = Integer.parseInt(stringID);
		
		// get employee to select using id
		Employee empToSelect = empDaoObject.getEmployeeByID(id);
		System.out.println(empToSelect.toString());
		
		System.out.println(empToSelect.toString());
		System.out.println("HAVE SELECTED EMPLOYEE! MAPPING WITH JACKSON DATABIND!");
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(empToSelect));
		pw.close();
	}
	
	public void getAllEmps(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("MADE IT TO SELECT ALL EMPS SERVICE!");
		List<Employee> allEmps = empDaoObject.getEmployees();
		
		//use jackson databind 
		for (Employee e : allEmps)
		{
			System.out.println(e);
		}
		System.out.println("HAVE SELECTED EMPLOYEES! MAPPING WITH JACKSON DATABIND!");		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(allEmps));
		pw.close();
		
	}
}
