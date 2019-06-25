package com.revature.dao;

import java.util.List;

import com.revature.model.Request;

public interface RequestDao {
	public List<Request> getRequests();
	public List<Request> getEmpRequests(int eId);
	public Request getRequestById(int id);
	public Request getRequestByEmpId(int eId);
	public int createRequest(Request r);
	public int deleteRequest(int id);
	public int approveRequest(int id, int mId);
}
