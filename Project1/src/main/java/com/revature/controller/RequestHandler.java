package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.AuthenticationDelegate;
import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.ProfileDelegate;
import com.revature.delegate.ReimbursementDelegate;
import com.revature.delegate.StaticDelegate;

public class RequestHandler {
	private StaticDelegate sd = new StaticDelegate();
	private EmployeeDelegate ed = new EmployeeDelegate();
	private ReimbursementDelegate rd = new ReimbursementDelegate();
	private ProfileDelegate pd = new ProfileDelegate();
	private AuthenticationDelegate ad = new AuthenticationDelegate();
	
	public void doGets(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")) {
			//call upon api requests after validation
			String authToken = request.getHeader("Authorization");
			if(!ad.isAuthorized(authToken)) {
				response.sendRedirect(request.getContextPath()+"/login");
				return;
			}
			
			String miniUri = uri.substring(5);
			switch(miniUri) {
			case "emprequests":
				rd.getAnEmployeeRequests(request, response);
				break;
			case "employees":
				ed.getAllEmployees(request, response);
				break;
			case "profile":
				pd.getProfileInfo(request, response);
				break;
			case "manage":
				rd.getAllReimbursements(request, response);
				break;
			case "request":
				//make it easier for request to grab the employee id needed to query the DB
				rd.getEmployeesRequests(request, response);
				break;
			default:
				response.sendError(404, "Record not found!");
			}
			
		} else {
			sd.returnStatic(request, response);
		}
		
	}
	
	public void doPosts(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		switch(uri) {
		case "/api/employees":
			//TODO: extra implementation for creating employees
			break;
		case "/api/profile":
			//TODO: extra implementation for creating profiles
			break;
		case "/api/manage":
			//TODO: not sure what this would be for
			break;
		case "/api/request":
			rd.createRequest(request, response);
			break;
		case "/login":
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			String auth = ad.authenticate(username, password);
			
			if(auth == null) {
				response.sendRedirect("http://localhost:8080/Project1/invlogin");
			} else {
				response.setStatus(200);
				response.setHeader("Authorization",  auth);
			}
			break;
		default:
			response.sendError(405, "Method not supported");
		}
		
	}
	
	public void doPuts(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		switch(uri) {
		case "/api/request":
			rd.updateRequest(request, response);
			break;
		case "/api/manage":
			pd.updateInfo(request, response);
			break;
		default:
			response.sendError(405, "Method not supported");
		}
		
		
	}

}
