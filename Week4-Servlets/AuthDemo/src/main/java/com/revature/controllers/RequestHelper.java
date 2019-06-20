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
	
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")) {
			// some resource based delegate should handle this request
		} else {
			vd.returnView(request,response);
		}
	}
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		switch(uri) {
		case "/login":
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// authenticate with authDelegate 
			String auth = ad.authenticate(username, password);
			System.out.println(auth);
			// if authentication is successful, return Authorization to the client
			if(auth == null) {
				response.setStatus(401);
			} else {
				response.setStatus(200);
				response.setHeader("Authorization", auth);
			}	
		}
	}
		

}
