package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.deligates.EmployeeDeligate;
import com.revature.deligates.LoginDeligate;
import com.revature.deligates.ManagerDeligate;

public class RequestHelper {
	
	LoginDeligate lDel = new LoginDeligate();
	EmployeeDeligate eDel = new EmployeeDeligate();
	ManagerDeligate mDel = new ManagerDeligate();
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")) {
			String record = uri.substring(5,8);
			switch(record) {
			case "emp":
				eDel.returnEmployee(request, response);
				break;
			case "man":
				mDel.returnManager(request, response);
				break;
			case "log":
				lDel.returnLogin(request, response);
				break;
			case "cre":
				break;
			default:
				response.sendError(404, "Page not found");
			}
		} else {
			
		}
	}
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")) {
			String record = uri.substring(5,8);
			switch(record) {
			case "emp":
				eDel.returnEmployee(request, response);
				break;
			case "man":
				mDel.returnManager(request, response);
				break;
			case "log":
				lDel.returnLogin(request, response);
				break;
			case "cre":
				lDel.returnCreateUser(request, response);
				break;
			default:
				response.sendError(404, "Page not found");
			}
		}
	}
}
