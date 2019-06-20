package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate vd = new ViewDelegate();
	private AuthDelegate ad = new AuthDelegate();
	
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
			
			// if authentication is successful, return Authorization to the client; otherwise
			if(auth == null) {
				response.setStatus(401); // 401 Unauthorized
			} else {
				response.setStatus(200);
				response.setHeader("Authorization", auth);
			}	
		}
	}
		

}
