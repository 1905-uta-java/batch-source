package com.company.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	
	//Return a page dependent on the path given in the URI
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		//Determine which page to return passed on path
		switch(path) {
		case "/loginPage":
			request.getRequestDispatcher("/static/login.html").forward(request, response);
			break;
		case "/employeeHub":
			request.getRequestDispatcher("/static/employeeHub.html").forward(request, response);
			break;
		default:
			response.sendError(404, "Page Not Found");
		}
	}
	
}
