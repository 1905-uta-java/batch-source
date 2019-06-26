package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeDelegate {
	
	EmployeeService eService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idStr = request.getParameter("id");
		
		if(idStr == null) {
			// make a call to a service method which gets all of our employees
			List<Employee> employees = eService.getAllEmployees();
			
			// convert employees to JSON using Jackson databind's ObjectMapper
			ObjectMapper om = new ObjectMapper();
			String employeesJSON = om.writeValueAsString(employees);
			
			// write JSON to response body using response's PrintWriter
			PrintWriter pw = response.getWriter();
			pw.write(employeesJSON);
			pw.close();
		} else if (idStr.matches("^\\d+$")) {
			Employee e = eService.getEmployeeById(Integer.parseInt(idStr));
			if(e == null) {
				response.setStatus(404);
			}
			
			ObjectMapper om = new ObjectMapper();
			String employeeJSON = om.writeValueAsString(e);
			
			PrintWriter pw = response.getWriter();
			pw.write(employeeJSON);
			pw.close();
			
		} else {
			response.setStatus(400);
		}
	}

}
