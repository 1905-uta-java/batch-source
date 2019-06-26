package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.doa.EmployeeDoa;
import com.revature.util.EmployeeAuthentication;

public class NewEmployee {
	public void createEmployee(HttpServletRequest request, HttpServletResponse response) {
		String fn = request.getParameter("firstname");
		String ln = request.getParameter("lastname");
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		
		
		if(EmployeeAuthentication.employeeConfirmation(fn,ln,un,pass)) {
			EmployeeDoa ed = new EmployeeDoa();
			ed.createEmployee(fn, ln, un, pass);
		}
		
		
	}
}
