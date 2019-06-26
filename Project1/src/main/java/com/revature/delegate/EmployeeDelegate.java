package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeDelegate {
	
	private EmployeeService empService = new EmployeeService();
	
	public void getAllEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Employee> employees = empService.getEmployees();
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(employees));
		pw.close();
		
	}
	
	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Added functionality for managers
	}
	
}
