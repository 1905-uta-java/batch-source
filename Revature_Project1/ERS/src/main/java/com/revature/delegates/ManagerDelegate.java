package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.services.ManagerService;

public class ManagerDelegate {

	ManagerService mService = new ManagerService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Employee> employees = mService.getAll();
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(employees));
		pw.close();	
	}
}
