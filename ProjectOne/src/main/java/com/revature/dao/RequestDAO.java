package com.revature.dao;

import java.util.List;

import com.revature.models.Request;

public interface RequestDAO
{
	public List<Request> viewRequestsByEmployee(int emp_id);
	// get request by ID
	public List<Request> viewPendingRequestsForYourself(int emp_id);
	
	public List<Request> viewResolvedRequestsForYourself(int emp_id);
	
	// MANAGER METHODS
	
	public List<Request> viewAllPendingRequestsManagers();
	
	public List<Request> viewAllResolvedWithResolveInfo();
	
	// create requests
	public int createRequest(Request r);
	// update requests
	public int updateRequest(Request r);
	
	public Request viewOneRequestByID(int req_id);
	// delete requests	
}
