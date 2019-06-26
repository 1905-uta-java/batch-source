package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.RequestDelegate;
import com.revature.delegates.UserDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate vd = new ViewDelegate();
	private AuthDelegate ad = new AuthDelegate();
	private UserDelegate ud = new UserDelegate();
	private EmployeeDelegate ed = new EmployeeDelegate();
	private RequestDelegate rd = new RequestDelegate();
	private int holder=0;
	/* 
	 * This method is invoked for every GET request sent to a path not beginning with "static"
	 * Paths that we accommodate for include:
	 *    a. those which begin with "/api/" which indicate we're requesting resources/data
	 *    b. those which request web pages and need to be forwarded to the corresponding static html file
	 */
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")) {
			// some resource based delegate should handle this request
			
			// validate that the request is coming from an authorized user
//			String authToken = request.getHeader("Authorization");
//			System.out.println("Auth Header: "+authToken);
//			
////			// once we get Authorization header check that it's not null and that it's a 
////				// valid combination of id and role
//			if(!ad.isAuthorized(authToken)) {
//				response.sendRedirect(request.getContextPath()+"/login");
//				return;
//			}
//			
			String record = uri.substring(5);
			switch(record) {
			case "employees":
				ed.getEmployees(request, response);
				break;
			case "requests":
				rd.getRequests(request, response);
				break;
			default:
				response.sendError(404, "Record Not Supported");
			}
			
		} else {
			// if the uri does not start with "/api/" or "/static/" the view delegate is used to attempt to redirect the path to a corresponding static resource
			vd.returnView(request,response);
		}
	}
	
	
	/* 
	 * This method is invoked for every POST request; the only POST requet currently supported 
	 * 	is for "/login"
	 */
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		switch(uri) {
		case "/login":
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			// authenticate with authDelegate 
			String auth = ad.authenticate(username, password);
			System.out.println(auth);
			System.out.println("HEREEEEEEEEEEE");
			String[] splitString = auth.split(":");
			holder = Integer.parseInt(splitString[0]);
			System.out.println(holder);
			// if authentication is successful, return Authorization to the client; otherwise
			if(auth == null) {
				response.setStatus(401); // 401 Unauthorized
			} else {
				response.setStatus(200);
				response.setHeader("Authorization", auth);
				System.out.println("sucess");
			}
			break;
		case "/api/requests":
			rd.createRequest(request, response);
			break;
		}
	}
}

		


