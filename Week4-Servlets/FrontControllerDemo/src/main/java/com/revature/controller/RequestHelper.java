package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.DepartmentDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate vd = new ViewDelegate();
	private EmployeeDelegate ed = new EmployeeDelegate();
	private DepartmentDelegate dd = new DepartmentDelegate();
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")){
			// we'll try to match with the appropriate record being requested for
			String record = uri.substring(5);
			switch(record) {
			case "employees":
				ed.getEmployees(request, response);
				break;
			case "departments":
				dd.getDepartments(request, response);
				break;
			default:
				response.sendError(404, "Record Not Supported");
			}
		} else {
			// send request to view delegate to forward to a static resource
			vd.returnView(request, response);
		}
	}
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		switch(uri) {
		case "/api/employees":
			ed.createEmployee(request, response);
			break;
		default:
			response.sendError(405, "Method Not Supported for Resource");
		}
	}

}
