package com.revature.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.doa.EmployeeDoa;
import com.revature.util.EmployeeAuthentication;
import com.revature.util.ManagerAuthentication;

public class LoginPage {

	EmployeeDoa ed = new EmployeeDoa();
	
	public void userLog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println(user + " " + pass);
		
		
		if(EmployeeAuthentication.isEmployeeLogIn(user, pass)) {
			response.setStatus(200);
			String s = new ObjectMapper().writeValueAsString(EmployeeAuthentication.user(user, pass));
			System.out.println("emp");
			response.setHeader("Authentic", s);
		}
		else if(ManagerAuthentication.isManagerLogIn(user, pass)) {
			response.setStatus(200);
			String s= new ObjectMapper().writeValueAsString(ManagerAuthentication.user(user, pass));
			response.setHeader("Authentic", s);
			System.out.println("man");
		}
		else
			response.setStatus(401);
	
	}
	
	
	
}
