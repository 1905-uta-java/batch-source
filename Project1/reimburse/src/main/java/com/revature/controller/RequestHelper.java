package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ReimbursementDelegate;
import com.revature.delegates.UserDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate vd = new ViewDelegate();
	private AuthDelegate ad = new AuthDelegate();
	private UserDelegate ud = new UserDelegate();
	private EmployeeDelegate ed = new EmployeeDelegate();
	private ReimbursementDelegate rd = new ReimbursementDelegate();
	
	/* 
	 * This method is invoked for every GET request sent to a path not beginning with "static"
	 * Paths that we accommodate for include:
	 *    a. those which begin with "/api/" which indicate we're requesting resources/data
	 *    b. those which request web pages and need to be forwarded to the corresponding static html file
	 */
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")) {			
			String record = uri.substring(5);
			switch(record) {
			case "users":
				// some resource based delegate should handle this request
				// validate that the request is coming from an authorized user
				String authToken = request.getHeader("Authorization");
				System.out.println("Auth Header: "+authToken);
				// once we get Authorization header check that it's not null and that it's a 
					// valid combination of id and role
				if(!ad.isAuthorized(authToken)) {
					response.sendRedirect(request.getContextPath()+"/login");
					return;
				}
				// request appropriate user(s) from UserDelegate
				ud.getUsers(request, response);
				break;
			case "employees":
				ed.getEmployees(request, response);
				break;
			case "reimbursements":
				rd.getReimbursements(request, response);
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
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		switch(uri) {
		case "/login":
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			// authenticate with authDelegate 
			String auth = ad.authenticate(username, password);
			System.out.println(auth);
			// if authentication is successful, return Authorization to the client; otherwise
			if(auth == null) {
				response.setStatus(401); // 401 Unauthorized
			} else {
				response.setStatus(200);
				response.setHeader("Authorization", auth);
			}
			break;
		case "/api/add":
			// get key values pair from header
			String authToken = request.getHeader("token");
			boolean isLoggedIn = ad.isAuthorized(authToken);
			System.out.println(isLoggedIn);
			
			if(isLoggedIn == false) {
				System.out.println("Should be logged in to add remibursement");
				response.setStatus(401); // 401 Unauthorized
			} else {
				response.setStatus(200);
				// no need to change auth for now
//				response.setHeader("Authorization", auth);
				rd.addReimbursement(request, response);
			}
			break;
		case "/api/approveButton":
			rd.approveReimbursement(request, response);
			break;
		default:
			response.sendError(404, "Record Not Supported");
		}
	}
}

