package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeDelegate {
	
	EmployeeService eService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		List<Employee> employees = eService.getAllEmployees();
		System.out.println(employees.size());
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(employees));
		pw.close();
	}
//	
//	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String newName = request.getParameter("name");
//		String newDptIdStr = request.getParameter("department");
//		System.out.println("input "+newName+" with a dept id of "+newDptIdStr);
//		if(newDptIdStr != null && newDptIdStr.matches("^\\d+$")) {
//			Employee e = new Employee();
//			e.setName(newName);
//			e.getDepartment().setId(Integer.parseInt(newDptIdStr));
//			eService.create(e);
////			response.setStatus(201);
//			response.sendRedirect("../directory");
//		}
//	}

}
