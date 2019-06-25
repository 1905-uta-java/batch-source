package com.revature.deligates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImp;
import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.service.EmployeeService;
import com.revature.util.ValidationUtil;

public class EmployeeDeligate {
	EmployeeService eServe = new EmployeeService();
	ValidationUtil valid = new ValidationUtil();
	
	public void returnEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		String record = uri.substring(8);
		switch(record) {
		case "/profile":
			this.getEmployee(request, response);
			break;
		case "/requests":
			this.getRequests(request, response);
			break;
		case "/approved":
			this.getApproved(request, response);
			break;
		case "/submit":
			this.createRequest(request, response);
			break;
		case "/change":
			break;
		default:
			
		}
	}
	
	public void getEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the information from the request
		int id = valid.validateInt(request.getParameter("employeeId"));
		Employee e = eServe.getEmployee(id);
		
		// Get the information of the requested employee and send it back
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(e));
		pw.close();
	}
	
	public void createRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the information from the request
		RequestDao rDao = new RequestDaoImp();
		int num = rDao.getRequests().size() - 1;
		int id = 1;
		if(num != -1) {
			id = rDao.getRequests().get(num).getId() + 1;
		}
		int eId = valid.validateInt(request.getParameter("employeeId"));
		double amount = valid.validateAmount(request.getParameter("amount"));
		String reason = request.getParameter("reason");
		
		Request r = new Request(id, eId, amount, reason, -1);
		eServe.newRequest(r);
	}
	
	public void getRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = valid.validateInt(request.getParameter("employeeId"));
		List<Request> rList = eServe.getRequests(id);
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(rList));
		pw.close();
	}
	
	public void getApproved(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = valid.validateInt(request.getParameter("employeeId"));
		List<Request> rList = eServe.getRequests(id);
		List<Request> result = new ArrayList<Request>();
		
		for(Request r : rList) {
			if(r.getApprovedBy() != 0) {
				result.add(r);
			}
		}
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(result));
		pw.close();
	}
	
	public void changeEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eId = valid.validateInt(request.getParameter("managerId"));
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
			eServe.changeEmployee(eId, eMail, uName, pWord);
		} else {
			response.sendError(405, "Could not change Employee information: Input is Invalid");
		}
	}
	
}
