package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("HERE PATH: " + path);
		switch(path) {
		case "/login":
		case "/":
		case "/stuff":
			System.out.println("REQUESTING LOGIN");
			request.getRequestDispatcher("/static/index.html").forward(request, response);
			break;
		case "/home":
			System.out.println("REQUESTING HOME");
			request.getRequestDispatcher("/static/main.html").forward(request, response);
			break;
		case "/admin":
			System.out.println("REQUESTING ADMIN");			
			request.getRequestDispatcher("/static/admin.html").forward(request, response);
			break;
		default:
			response.sendError(404, "nah");
		}
	}
}
