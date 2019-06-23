package com.revature.project1.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.auth.AuthToken;
import com.revature.project1.service.AuthService;
import com.revature.project1.service.ServiceManager;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private static AuthService authService = ServiceManager.getAuthService();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	System.out.println("doPost");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		AuthToken token = authService.verifyPassword(password, email);
		
		PrintWriter writer = response.getWriter();
		
		if(token != null) {
			
			ObjectMapper mapper = new ObjectMapper();
			
			String tokenString = mapper.writeValueAsString(token);
			
			writer.append(tokenString);
			
		} else {
			
			writer.append("{}");
		}
		
		writer.close();
    }
}
