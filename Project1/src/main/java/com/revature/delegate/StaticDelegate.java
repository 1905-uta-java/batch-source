package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaticDelegate {
	
	public void returnStatic(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		switch(uri) {
		case "/home":
			request.getRequestDispatcher("/static/views/Profile.html").forward(request, response);
			break;
		case "/login":
			request.getRequestDispatcher("/static/views/Login.html").forward(request, response);
			break;
		case "/requests":
			request.getRequestDispatcher("/static/views/Requests.html").forward(request, response);
			break;
		case "/manage":
			request.getRequestDispatcher("/static/views/ManageRequests.html").forward(request, response);
			break;
		case "/invlogin":
			request.getRequestDispatcher("/static/views/ILogin.html").forward(request, response);
			break;
		default:
			response.sendError(404, "Page not found!");
		}
	}

}
