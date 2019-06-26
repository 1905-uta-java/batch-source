package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.service.EmployeeService;
import com.revature.service.UserService;

public class UserDelegate {
	UserService uService = new UserService();
	EmployeeService eService = new EmployeeService();
	
	public void getUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		List<User> users = uService.getAll();
		System.out.println("Made it to get users");
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(users));
		pw.close();
	}
	
	
	public void createUser(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException{
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-YYYY");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int empId = id;
		String userRole = request.getParameter("userRole");
		Date date = new Date();
		String createDate =  simpleFormat.format(date);
		
		System.out.println(username + " " + password + " " + createDate + " " + empId + " " + userRole);
		
		if(!uService.checkUsername(username)) {
			User u = new User(username, password, createDate, empId, userRole, null);
			uService.create(u);
		}
		
	}
	
	public User getSingleUser(String username) {
		System.out.println("SINGLE USER UD HERE. Username = " + username);
		return uService.getByUsername(username);
	}

	public void returnUserInfo(HttpServletRequest request, HttpServletResponse response, String username) throws IOException, ServletException{ 
		User u = uService.getByUsername(username);
		
		System.out.println(u);
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(u));
		pw.close();
	}
	
	public void updateUser(HttpServletRequest request, HttpServletResponse response) {
		//String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User u = uService.getCurrentUser();
		u.setPassword(password);
		
		uService.updateUser(u);
	}


	public void logout() {
		uService.logout();
	}

}
