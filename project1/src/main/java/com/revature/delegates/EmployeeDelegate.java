package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.service.EmployeeService;
import com.revature.service.UserService;

public class EmployeeDelegate {
	EmployeeService eService = new EmployeeService();
	UserService uService = new UserService();
	Employee e = new Employee();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ArrayList<Employee> employees = new ArrayList<>();
		Object[] eArr = null;
		
		employees =	eService.getAll(); 
		eArr = employees.toArray();
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(eArr));
		pw.close();
	}

	
	public void returnEmpByUser(HttpServletRequest request, HttpServletResponse response, User u) throws IOException, ServletException{
		System.out.println("GETTING THIS USER EMPLOYEE INFO: " + u);
		Employee e = eService.returnEmployeeFromId(u.getEmployeeId());
		//User u = uService.getByUsername(username);
		System.out.println("User: " + u.toString());
		if(e != null) {
			PrintWriter pw = response.getWriter();
			pw.write(new ObjectMapper().writeValueAsString(e));
			System.out.println("returnEmpByUser: " + new ObjectMapper().writeValueAsString(e));
			pw.close();
		}
	}
	
	public int createEmployee(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Creating employee in EMPLOYEE SERVICE");
		int id = eService.getNewEmpNum();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String bDate= request.getParameter("bDate");
		String email = request.getParameter("email");
		String position = request.getParameter("pos");
		
		System.out.println(request.getParameter("manId"));
		
		if (request.getParameter("manId") != null && !request.getParameter("manId").equals("undefined")) {
			int manId = Integer.parseInt(request.getParameter("manId"));
			Employee e = new Employee(id, fname, lname, email, bDate, manId, position);
		} else {
			Employee e = new Employee(id, fname, lname, email, bDate, 0, position);			
		}
		
		eService.create(e);
		return id;
	}

	
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("\n\nTime to update an employeeeeeeeeeeee");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String birthDate = request.getParameter("birthDate");
		int id = Integer.parseInt(request.getParameter("empId"));
		Employee e = eService.getCurrentEmployee();
		
		if(e == null) {
			e = eService.returnEmployeeFromId(id);
			eService.updateEmployee(e);
		}
		
		
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setBirthDate(birthDate);
		
		System.out.println("About to update THIS BOOIIII: " + e + "\n\n");
		
		eService.updateEmployeeDB(e);
	}


	public void logout() {
		eService.logout();
	}
}
