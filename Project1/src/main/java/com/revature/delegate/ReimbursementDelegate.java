package com.revature.delegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;

public class ReimbursementDelegate {

	
	ReimbursementService rServ = new ReimbursementService();
	EmployeeService eServe = new EmployeeService();

	
	public void getAllReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Reimbursement> reimbursements = rServ.getAllReimbursements();
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(reimbursements));
		pw.close();
	}
	
	public void getEmployeesRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String employee = (String) request.getHeader("Authorization").split(":")[0];
		int empId = Integer.parseInt(employee);
		List<Reimbursement> reimbursements = rServ.getEmployeeReimbursements(empId);
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(reimbursements));
		pw.close();
	}
	
	public void createRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int reqId = rServ.getAllReimbursements().size() + 1;

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String comments = request.getParameter("comments");
		String amount = request.getParameter("amount");
		int empId = eServe.getEmployeeByName(name).getEmpNum();
		
		rServ.createRebe(reqId, empId, Integer.parseInt(amount), comments);
		response.sendRedirect("../home");
	}
	
	public void updateRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String[] data = br.readLine().split("&");
		
		//get rServ to set status, resolvedBy into a request specified by ID.
		if(data.length == 3) {
			String[] reqId = data[0].split("=");
			String[] status = data[1].split("=");
			String[] resolvedBy = data[2].split("=");
			
			int rId = Integer.parseInt(reqId[1]);
			int stat = Integer.parseInt(status[1]);
			int resolved = Integer.parseInt(resolvedBy[1]);
			
			rServ.changeStatus(stat, rId);
			rServ.setResolvedBy(resolved, rId);
		}
		
		response.setStatus(201);
	}
	
	public void getAnEmployeeRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//this is different from getEmployeesRequest because it doesn't grab the ID from the authentication token. Instead it is another parameter in the body.
		String eIdStr = request.getHeader("EmployeeID");
		//Get our employee's ID and query the DB to give us that employee's information
		int eId = Integer.parseInt(eIdStr);
		
		
		//Use that employee ID to get all of their requests.
		List<Reimbursement> reimbursements = rServ.getEmployeeReimbursements(eId);
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(reimbursements));
		pw.close();
	}
}
