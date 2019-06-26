package com.company.delegates;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.Reimbursement;
import com.company.services.ReimbursementService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementDelegate {
	private ReimbursementService rs = new ReimbursementService();
	
	//Get reimbursements relevant to the employee id
	public List<Reimbursement> getRelevantReimbRequests(HttpServletRequest request,HttpServletResponse response){
		String strId = request.getParameter("emp_id");
		int empId = rs.convertStringToInt(strId);
		List<Reimbursement> empRequests;
		//Check if empId is 0
		if(empId == 0) {
			return null;
		}
		
		//Check if admin account to get all information
		if(empId == 100001) {
			empRequests = rs.getAll();
		}else {
		
			List<Reimbursement> managerRequests = rs.getAllByManagerId(empId);
			empRequests = rs.getAllByEmpId(empId);
		
			empRequests.addAll(managerRequests);
		}
		return empRequests;
	}
	
	//Create a new reimbursements request
	public int createReimbRequest(HttpServletRequest request,HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement newReq = mapper.readValue(request.getInputStream(),Reimbursement.class);

		int reqId = rs.getNextRequestId();
		
		newReq.setReqId(reqId);
		
		return rs.create(newReq);
	}
	
	//Update a reimbursement request in the database
	public int updateReimbRequest(HttpServletRequest request,HttpServletResponse response) {
		String status = request.getParameter("status");
		String managerNotes = "";
		
		String strId = request.getParameter("id");
		int requestId = rs.convertStringToInt(strId);
		
		//Check if requestId is 0
		if(requestId == 0) {
			return 0;
		}
		
		//Get an object of the request being referenced
		Reimbursement reim = rs.getById(requestId);
		reim.setStatus(status);
		reim.setManagerNotes(managerNotes);
		
		return rs.update(reim);
	}
	
	//Delete a reimbursement request in database
	public int deleteReimbRequest(HttpServletRequest request,HttpServletResponse response) {
		String strId = request.getParameter("id");
		int requestId = rs.convertStringToInt(strId);
		
		//Check if requestId is 0
		if(requestId == 0) {
			return 0;
		}
		
		return rs.delete(requestId);
	}
	
	
}
