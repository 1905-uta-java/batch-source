package com.revature.businesslogic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.RequestDAOImpl;
import com.revature.models.Request;

public class CreateRequestService
{
	RequestDAOImpl reqDaoObject = new RequestDAOImpl();

	public CreateRequestService()
	{
		super();
	}
	
	public void makeRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("MADE IT TO THE SERVICE METHOD WHICH CREATES THE REQUEST!");
		
		// make new request object
		Request testRequest = new Request();
		
		// set reqID
		int reqID = reqDaoObject.getMaxReqID() + 1;
		System.out.println("Request ID we will use: " + reqID);
		
		// set fields for employee
		String reason = request.getParameter("reason");
		String token = request.getParameter("token");
		String ammount = request.getParameter("ammount");
		String status = "PENDING";
		System.out.println(request.getParameter("token"));
		
		// parse first char of token to an int and assign it to createdBy;
		String stringID = (String)token.subSequence(0, 1);
		int createdBy = Integer.parseInt(stringID);
		//int resolvedBy = -1 ;
		System.out.println("EMP_ID for created by: " + createdBy);
		
		
		testRequest.setReqID(reqID);
		testRequest.setReason(reason);
		testRequest.setAmmount(Integer.parseInt(ammount));
		testRequest.setCreatedBy(createdBy);
		//testRequest.setResolvedBy(resolvedBy);
		testRequest.setStatus(status);
		
		System.out.println(testRequest.toString());
		
		// sendRequest to database
		reqDaoObject.createRequest(testRequest);
	}
	
}
