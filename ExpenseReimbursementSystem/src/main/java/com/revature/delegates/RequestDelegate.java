package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.services.RequestService;

public class RequestDelegate {
	
	RequestService rService = new RequestService();
	
	public void getRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idStr = request.getParameter("empId");
		
		if(idStr == null) {
			// make a call to a service method which gets all of our employees
			List<Request> requests = rService.getAllRequests();
			
			// convert requests to JSON using Jackson databind's ObjectMapper
			ObjectMapper om = new ObjectMapper();
			String employeesJSON = om.writeValueAsString(requests);
			
			// write JSON to response body using response's PrintWriter
			PrintWriter pw = response.getWriter();
			pw.write(employeesJSON);
			pw.close();
		} else if (idStr.matches("^\\d+$")) {
			List<Request> req = rService.getAllRequests();
			List<Request> holder = new ArrayList<>();
			for(Request rr : req) {
				if(Integer.parseInt(idStr) == rr.getEmpId()) {
					holder.add(rr);
				}
			}
			Request r = rService.getRequestById(Integer.parseInt(idStr));
			if(r == null) {
				response.setStatus(404);
			}
			
			ObjectMapper om = new ObjectMapper();
			String employeeJSON = om.writeValueAsString(holder);
			
			PrintWriter pw = response.getWriter();
			pw.write(employeeJSON);
			pw.close();
			
		} else {
			response.setStatus(400);
		}	
	}
	
	public void createRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String newAmount = request.getParameter("amount");
		String newDescript = request.getParameter("description");
		System.out.println("Amount: "+newAmount+"Description: "+newDescript);
		//String id =request.getHeader("Authorization");
		//System.out.println(id);
		//String[] splitString = id.split(":");
		//int holder = Integer.parseInt(splitString[0]);
		
		Request r = new Request();
		r.setAmount(Double.parseDouble(newAmount));
		r.setDescription(newDescript);
		r.setEmpId(4);
		r.setStatus("PENDING");
		r.setResolvedBy("--");
		rService.createRequest(r);
//			response.setStatus(201);
			response.sendRedirect("../reinbursements");
		
	}

}
