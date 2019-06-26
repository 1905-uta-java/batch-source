package ERS_Runners;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ERS_Actors.ERS_Request;
//imports
import JDBC_ERS_DAO.ERS_DAO;
import JDBC_ERS_DAO.ERS_DAO_Implementation;

public class ERS_Runner {
	//class attributes
	ERS_DAO ers = new ERS_DAO_Implementation();
	
	public void getUserRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		
		List<ERS_Request> ersList = ers.getAllRequests();
		
		pw.write(om.writeValueAsString(ersList));
		pw.close();
	}
	
	public void getRequestByUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		
		try {
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			List<ERS_Request> ersList = ers.getRequestByEmp(emp_id);
			pw.write(om.writeValueAsString(ersList));
		} catch (NumberFormatException nfe) {
			response.setStatus(400);
		}
		
		
		pw.close();
	}
	
	public void createRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("emp_id"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			String comments = request.getParameter("comments");
			String pending = "pending";
			int req_id = ers.getNextReqId();
			
			ERS_Request req = new ERS_Request(req_id, id, amount, pending, comments);
			
			ers.createRequest(req);
			
		} catch (NumberFormatException nfe) {
			response.setStatus(400);
		}
	}
	
	public void approveRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			int req_id = Integer.parseInt(request.getParameter("req_id"));
			ERS_Request req = ers.getRequestByReq(req_id);
			
			req.setStatus("Approved");
			
			ers.updateRequest(req);
		} catch (NumberFormatException nfe) {
			response.setStatus(400);
		}
	}
	
	public void denyRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			int req_id = Integer.parseInt(request.getParameter("req_id"));
			ERS_Request req = ers.getRequestByReq(req_id);
			
			req.setStatus("Deny");
			
			ers.updateRequest(req);
		} catch (NumberFormatException nfe) {
			response.setStatus(400);
		}
	}
	
	
}
