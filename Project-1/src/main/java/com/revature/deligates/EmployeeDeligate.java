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
		case "/resolved":
			this.getResolved(request, response);
			break;
		case "/submit":
			this.createRequest(request, response);
			break;
		case "/change":
			this.changeEmployee(request, response);
			break;
		default:
			response.sendError(404, "Page is not found");
		}
	}
	
	public void getEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the information from the request
		int id = valid.validateInt(request.getParameter("employeeId"));
		if(id == -1) {
			response.sendError(405, "Could not get employee information: id was invalid");
		}
		Employee e = eServe.getEmployee(id);
		
		// Get the information of the requested employee and send it back
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(e));
		pw.close();
	}
	
	public void createRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the information from the request
		RequestDao rDao = new RequestDaoImp();
		int id = 1;
		for(Request r : rDao.getRequests()) {
			if(r.getId() >= id) {
				id = r.getId() + 1;
			}
		}
		int eId = valid.validateInt(request.getParameter("employeeId"));
		double amount = valid.validateAmount(request.getParameter("amount"));
		String reason = request.getParameter("reason");
		if(eId == -1 || amount == -1.00) {
			response.sendError(405, "Could not create request: Input is Invalid");
		}
		
		Request r = new Request(id, eId, amount, reason, -1, -1);
		eServe.newRequest(r);
	}
	
	public void getRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = valid.validateInt(request.getParameter("employeeId"));
		if(id == -1) {
			response.sendError(405, "Could not get requests: id was invalid");
		}
		List<Request> rList = eServe.getRequests(id);
		List<Request> result = new ArrayList<Request>();
		
		for(Request r : rList) {
			if(!(r.getApprovedBy() >= 20000) && !(r.getDeniedBy() >= 20000)) {
				result.add(r);
			}
		}
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(result));
		pw.close();
	}
	
	public void getResolved(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = valid.validateInt(request.getParameter("employeeId"));
		if(id == -1) {
			response.sendError(405, "Could not get approved requests: id was invalid");
		}
		List<Request> rList = eServe.getRequests(id);
		List<Request> result = new ArrayList<Request>();
		
		for(Request r : rList) {
			if(r.getApprovedBy() >= 20000 || r.getDeniedBy() >= 20000) {
				result.add(r);
			}
		}
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(result));
		pw.close();
	}
	
	public void changeEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eId = valid.validateInt(request.getParameter("employeeId"));
		if(eId == -1) {
			response.sendError(405, "Could not change employee information: id was invalid");
		}
		String uName = request.getParameter("userName");
		String pWord = request.getParameter("passWord");
		String eMail = request.getParameter("eMail");
		boolean validInfo = true;
		
		if(valid.validateUname(uName) && uName != "") {
			validInfo = false;
		} if(!valid.validatePword(pWord) && pWord != "") {
			validInfo = false;
		} if(!valid.validateEmail(eMail) && eMail != "") {
			validInfo = false;
		}
		
		if(validInfo) {
			eServe.changeEmployee(eId, eMail, uName, pWord);
		} else {
			response.sendError(405, "Could not change Employee information: Input is Invalid");
		}
	}
	
}
