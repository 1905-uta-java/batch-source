package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {

	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("view delegate");
		switch (path) {
		case "/static" :
			request.getRequestDispatcher("static/").forward(request, response);
			break;
			
		case "/employeeHome" :
			request.getRequestDispatcher("/static/employeeHome.html").forward(request, response);
			break;
			
		case "/managerHome" :
			request.getRequestDispatcher("/static/managerHome.html").forward(request, response);
			break;
			
		default :
			response.sendError(404, "Static Resource Not Found");
		}
	}
	
}