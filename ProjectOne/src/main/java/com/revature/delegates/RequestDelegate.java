package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.businesslogic.CreateRequestService;
import com.revature.businesslogic.SelectRequestService;
import com.revature.businesslogic.UpdateRequestService;

public class RequestDelegate
{
	CreateRequestService createRequestTool = new CreateRequestService();
	SelectRequestService selectRequestTool = new SelectRequestService();
	UpdateRequestService updateRequestTool = new UpdateRequestService();
	
	public RequestDelegate()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void toCreateRequestService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("Made it to CREATE REQUEST SERVICE!");
		createRequestTool.makeRequest(request, response);
	}
	
	public void toSelectPending(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("GOIN TO SELECT REQUEST SERVICE!");
		selectRequestTool.getPendingRequestsForEmployee(request, response);
	}
	
	public void toSelectResolved(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("GOIN TO SELECT REQUEST SERVICE!");
		selectRequestTool.getResolvedRequestsForEmployee(request, response);
	}
	
	public void toSelectPendingAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("GOIN TO SELECT REQUEST SERVICE FOR ALL REQUESTS!");
		selectRequestTool.getPendingRequestsForAll(request, response);
	}
	
	public void toSelectResolvedAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("GOIN TO SELECT REQUEST SERVICE FOR ALL RESOLVED REQUESTS!");
		selectRequestTool.getResolvedRequestsForAll(request, response);
	}
	
	public void toSelectAllForSingleEmp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("GOIN TO SELECT REQUEST SERVICE FOR SINGLE EMPLOYEE!");
		selectRequestTool.getAllReqsForSingleEmp(request, response);
	}
	
	public void toApproveOrDenyRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("GOIN TO SELECT REQUEST SERVICE FOR APPROVE OR DENY REQUEST!");
		updateRequestTool.updateRequest(request, response);
	}
	
	
	

}
