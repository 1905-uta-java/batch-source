package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	
	
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		switch(path) {
		case "/login":
			request.getRequestDispatcher("/static/Login.html").forward(request, response);
			break;
		case "/ehome":
			request.getRequestDispatcher("/static/Views/employeeHome.html").forward(request, response);
			break;
		case "/mhome":
			request.getRequestDispatcher("/static/Views/managerHome.html").forward(request, response);
			break;
		case "/reinbursements":
			request.getRequestDispatcher("/static/Views/employeeRequest.html").forward(request, response);
			break;
		case "/createrequest":
			request.getRequestDispatcher("/static/Views/createRequest.html").forward(request, response);
			break;
		case "/records-allemployees":
			request.getRequestDispatcher("/static/Views/employeeTable.html").forward(request, response);
			break;
		case "/manager-pending":
			request.getRequestDispatcher("/static/Views/managerPendingR.html").forward(request, response);
			break;
		case "/manager-resolved":
			request.getRequestDispatcher("/static/Views/managerResolvedR.html").forward(request, response);
			break;
		case "/manager-specify":
			request.getRequestDispatcher("/static/Views/specifyR.html").forward(request, response);
			break;
		case "/mreimbursements":
			request.getRequestDispatcher("/static/Views/mreimMain.html").forward(request, response);
			break;
		default:
			response.sendError(404, "Static Resource Not Found");
		}
		
	}

}
