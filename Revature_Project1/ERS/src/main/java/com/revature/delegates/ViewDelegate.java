package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {

	public void returnView(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		switch(uri) {
		case "/":
			request.getRequestDispatcher("/Static/Views/Login.html").forward(request, response);
			break;
		case "/manager":
			request.getRequestDispatcher("/Static/Views/Manager.html").forward(request, response);
			break;
		case "/employee":
			request.getRequestDispatcher("/Static/Views/Employee.html").forward(request, response);
			break;
		default:
			response.sendError(404, "Static Resource Not Found");
		}
	}
	
}
