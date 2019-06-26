package com.revature.dao;

import java.util.List;

import com.revature.models.Request;

public interface RequestDao {
	
	List<Request> getAllRequests();
	public Request getRequestById(int r);
	public void createRequest(Request r);
	public void updateRequestStatus(Request r);
	
	

}
