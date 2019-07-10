package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DirectoryServlet extends HttpServlet {
	// need to add /directory to web.xml
	
	// implement doGet handler method to handle GET request we expect to be made in our browser 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("Views/Directory.html").forward(request, response);
	}

}
