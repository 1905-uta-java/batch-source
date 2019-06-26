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
		
		// perform introductory validation with reason and ammount
		String reason = request.getParameter("reason");
		boolean numbersInReason = createRequestTool.numbersInReason(reason);
		if (numbersInReason)
		{
			response.sendError(400);
			return;
		}
		
		String ammount = request.getParameter("ammount");
		boolean nonNumbersInAmmount = createRequestTool.nonNumbersInAmmount(ammount);
		if (nonNumbersInAmmount)
		{
			response.sendError(400);
			return;
		}
		
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
		String id = request.getParameter("enteredNumber");
		
		// validate numerical input
		boolean nonNumber = selectRequestTool.enteredIdIsNonNumber(id);
		if (nonNumber)
		{
			response.sendError(400, "You did not enter a number as a request ID!");
			return;
		}
		
		// validate maxId
		boolean idTooHigh = selectRequestTool.enteredIdAboveMaxId(id);
		System.out.println("ID TOO HIGH IS: " + idTooHigh);
		if (idTooHigh)
		{
			System.out.println("ENTERED ID IS NOT ABOVE MAX ID!");
			response.sendError(400, "You entered above the max ID!");
			return;
		}
		selectRequestTool.getAllReqsForSingleEmp(request, response);
	}
	
	public void toApproveOrDenyRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("GOIN TO SELECT REQUEST SERVICE FOR APPROVE OR DENY REQUEST!");
		updateRequestTool.updateRequest(request, response);
	}
	
	
	

}
