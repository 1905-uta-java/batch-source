package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ManagerDelegate;
import com.revature.delegates.ViewDelegate;


public class RequestHelper {

	private ManagerDelegate md = new ManagerDelegate();
	private ViewDelegate vd = new ViewDelegate();
	
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")){
			String record = uri.substring(5);
			switch(record) {
			case "allemployees":
				md.getEmployees(request, response);
				break;
			default:
				response.sendError(404, "Record Not Supported");
			}
		}else {
			// send request to view delegate to forward to a static resource
			vd.returnView(request, response);
		} 
	}
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		switch(uri) {
		case "/login":
			
		}
	}
	
	
	
	
	
}
