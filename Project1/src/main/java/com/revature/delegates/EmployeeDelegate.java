package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.services.EmployeeService;

public class EmployeeDelegate {

	private EmployeeService eService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Employee> employees = eService.getEmployees();
		
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		pw.write(om.writeValueAsString(employees));
		pw.close();
		
	}
	
	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}
	
}
