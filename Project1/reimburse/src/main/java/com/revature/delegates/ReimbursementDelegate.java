package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementDelegate {
	
	ReimbursementService rService = new ReimbursementService();
	
	public void getReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		List<Reimbursement> reimbursements = rService.getAllReimbursements();
		System.out.println(reimbursements.size());
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(reimbursements));
		pw.close();
	}

	public void addReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {		
		// read student info from form data
		int id = 0;
		String category = request.getParameter("category");
		String status = "pending";
		Double amount = Double.parseDouble(request.getParameter("amount"));
		// date has a default value at SQL prepared statement for today's date
		String dateSubmitted = request.getParameter("dateSubmitted");
		int approvingManagerId = 0;
		String dateApproved = "NA";
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		
		// create a new reimbursement object
		Reimbursement reimbursement = new Reimbursement(id, category, status, amount, dateSubmitted, approvingManagerId, dateApproved, employeeId);
		
		// add the reimbursement to the database
		rService.create(reimbursement);
		
		// send back to main page (the employee list) as 
		// a redirect to avoid multiple browser reload issue
		//response.sendRedirect(request.getContextPath() + "/StudentControllerServlet?command=LIST");
		response.sendRedirect(request.getContextPath() + "/api/reimbursements");	
	}
	
	public void approveReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, NumberFormatException {		
		// read student info from form data
		String id = request.getParameter("id");
		String category = request.getParameter("category");
		String status = "pending";
		String amount = request.getParameter("amount");
		String dateSubmitted = request.getParameter("dateSubmitted");
		// get manager currently logged in from session storage
		String approvingManagerId = request.getParameter("loggedInEmployeeId");
		String dateApproved = request.getParameter("dateApproved");
		String employeeId = request.getParameter("employeeId");
			
		// create a new reimbursement object
		Reimbursement reimbursement = new Reimbursement(Integer.parseInt(id), category, status, Double.parseDouble(amount), dateSubmitted, Integer.parseInt(approvingManagerId), dateApproved, Integer.parseInt(employeeId));

		
		// update that reimbursement's approving ManagerId and status
		// add the reimbursement to the database
		rService.approve(reimbursement);
		    
		
		// redirect manager to list of all reimbursements to potentially approve others
		// response.sendRedirect(request.getContextPath() + "/approve");	

		
	}
	
	
	
	
	public void getReimbursementById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read reimbursement id from form data
		
		String reimbursementId = request.getParameter("reimbursementId");
		System.out.println(reimbursementId);
		// parameter was originally sent as string
		// casted to int to match data model of Reimburse object
		int castedReimbursementId = Integer.parseInt(reimbursementId);
		
		// get reimbursement from database through service with DAO impl
		Reimbursement theReimbursement = rService.getReimbursementById(castedReimbursementId);
		
		// place reimbursement in request attribute
		request.setAttribute("THE_REIMBURSEMENT", theReimbursement);
		
		// send to update by id page
//		RequestDispatcher dispatcher = 
//				request.getRequestDispatcher("/update");
//		dispatcher.forward(request, response);
//	
	}
	
	
//	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String newName = request.getParameter("name");
//		String newDptIdStr = request.getParameter("department");
//		System.out.println("input "+newName+" with a dept id of "+newDptIdStr);
//		if(newDptIdStr != null && newDptIdStr.matches("^\\d+$")) {
//			Employee e = new Employee();
//			e.setName(newName);
//			e.getDepartment().setId(Integer.parseInt(newDptIdStr));
//			eService.create(e);
////			response.setStatus(201);
//			response.sendRedirect("../directory");
//		}
//	}



}
