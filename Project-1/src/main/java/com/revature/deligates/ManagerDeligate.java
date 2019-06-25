package com.revature.deligates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.service.ManagerService;
import com.revature.util.ValidationUtil;

public class ManagerDeligate {
	ManagerService mServe = new ManagerService();
	ValidationUtil valid = new ValidationUtil();
	
	public void returnManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		String record = uri.substring(8);
		switch(record) {
		case "/profile":
			this.getManager(request, response);
			break;
		case "/employees":
			this.getEmployees(request, response);
			break;
		case "/requests":
			this.getRequests(request, response);
			break;
		case "/approved":
			// May implement later
			break;
		case "/approve":
			this.approveRequest(request, response);
			break;
		case "/change":
			this.changeManager(request, response);
			break;
		default:
			response.sendError(404, "Page is not found");
		}
	}
	
	public void getManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = valid.validateInt(request.getParameter("managerId"));
		if(id == -1) {
			response.sendError(405, "Could not get manager information: id was invalid");
		}
		Manager m = mServe.getManager(id);
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(m));
		pw.close();
	}
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = valid.validateInt(request.getParameter("managerId"));
		if(id == -1) {
			response.sendError(405, "Could not get employees: id was invalid");
		}
		List<Employee> eList = mServe.getEmployees(id);
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(eList));
		pw.close();
	}
	
	public void getEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = valid.validateInt(request.getParameter("employeeId"));
		if(id == -1) {
			response.sendError(405, "Could not get employee: id was invalid");
		}
		Employee e = mServe.getEmployee(id);
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(e));
		pw.close();
	}
	
	public void getRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = valid.validateInt(request.getParameter("managerId"));
		if(id == -1) {
			response.sendError(405, "Could not get requests: id was invalid");
		}
		List<Employee> eList = mServe.getEmployees(id);
		
		List<Request> rList = mServe.getRequests(eList);
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(rList));
		pw.close();
	}
	
	public void approveRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mId = valid.validateInt(request.getParameter("managerId"));
		int rId = valid.validateInt(request.getParameter("requestId"));
		if(mId == -1 || rId == -1) {
			response.sendError(405, "Could not get approve the request: an id was invalid");
		}
		
		mServe.approveRequest(rId, mId);
	}
	
	public void changeManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mId = valid.validateInt(request.getParameter("managerId"));
		if(mId == -1) {
			response.sendError(405, "Could not change manager information: id was invalid");
		}
		String uName = request.getParameter("userName");
		String pWord = request.getParameter("passWord");
		String eMail = request.getParameter("email");
		boolean validInfo = true;
		
		if(valid.validateUname(uName)) {
			validInfo = false;
		} if(!valid.validatePword(pWord)) {
			validInfo = false;
		} if(!valid.validateEmail(eMail)) {
			validInfo = false;
		}
		
		if(validInfo) {
			mServe.changeManager(mId, eMail, uName, pWord);
		} else {
			response.sendError(405, "Could not change Manager information: Input is Invalid");
		}
	}
}
