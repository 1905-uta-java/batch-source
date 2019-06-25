package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthenticationDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.RequestDelegate;
import com.revature.delegates.ViewDelegate;
import com.revature.models.Employee;

public class RequestHelper
{
	
	public RequestHelper()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	private ViewDelegate viewDelegate = new ViewDelegate();
	private AuthenticationDelegate ad = new AuthenticationDelegate();
	private RequestDelegate rd = new RequestDelegate();
	private EmployeeDelegate ed = new EmployeeDelegate();
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("You are at request helper GET METHOD! Your shortened path is: " + path);
		
		// if path starts with api, direct it to delegate to direct the appropriate service
		if (path.startsWith("/api/"))
		{
			System.out.println("Alright. You want an API? You need to get to a non static resource!");
			String record = path.substring(5);
			System.out.println("Record path is: " + record);
			switch (record)
			{
				case("viewPendingAll"):
				System.out.println("LEAVING REQUEST HELPER TO GO TO REQUEST DELEGATE!");
				rd.toSelectPendingAll(request, response);
				break;
				
				case("viewResolvedAll"):
				System.out.println("LEAVING REQUEST HELPER TO GO TO REQUEST DELEGATE!");
				rd.toSelectResolvedAll(request, response);
				break;
				
				case("viewAllEmps"):
				
					System.out.println("LEAVING REQEUST HELPER TO GO TO EMPLOYEE DELEGATE");
					ed.toViewAllEmps(request, response);
					break;
			}
		}
		else
		{
			System.out.println("You are at the request helper. You are being redirected to view delegate");
			viewDelegate.directToView(request, response);
		}
		
		
		// otherwise, direct it to the appropriate delegate to direct the appropriate static resource
	}
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("You are at request helper POST METHOD! Your shortened path is: " + path);
		
		// if path starts with api, direct it to delegate to direct the appropriate service
		if (path.startsWith("/api/"))
		{
			System.out.println("Alright. You want an API? You need to get to a non static resource!");
			String record = path.substring(5);
			System.out.println("Record path is: " + record);
			switch (record)
			{
				case ("auth"):
				
					System.out.println("ENTERED AUTH CASE. ABOUT TO LEAVE REQUEST HELPER TO GO TO AUTH DELEGATE");
					ad.toAuthenticationService(request, response);
					 break;
				
				
				case ("createReq"):
					
					System.out.println("ENTERED CREATE REQ!");
					rd.toCreateRequestService(request, response);
					break;
					
				case ("viewPending"):
					System.out.println("ENTERED VIEW PENDING!");
					rd.toSelectPending(request, response);
					break;
				
				
				case("viewResolved"):
					System.out.println("ENTERED VIEW RESOVLED!");
					rd.toSelectResolved(request, response);
					break;
				
				
				case("viewOwnInformation"):
					System.out.println("LEAVING REQUEST HELPER TO EMPLOYEE DELEGATE");
					ed.toViewOwnInformation(request, response);
					break;
					
				case("viewReqFromSingleEmp"):
					System.out.println("LEAVING REQUEST HELPER TO GO TO REQUEST DELEGEATE");
					rd.toSelectAllForSingleEmp(request, response);
					break;
				
			}
		}
	}
	
	public void processPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("You are at request helper PUT METHOD! Your shortened path is: " + path);
		
		// if path starts with api, direct it to delegate to direct the appropriate service
		if (path.startsWith("/api/"))
		{
			System.out.println("Alright. You want an API? You need to get to a non static resource!");
			String record = path.substring(5);
			System.out.println("Record path is: " + record);
			switch (record)
			{
				case ("updateInformation"):
					System.out.println("LEAVING REQUEST HELPER TO EMPLOYEE DELEGATE");
					ed.toUpdateOwnInformation(request, response);
					break;
				case ("updateRequest"):
					System.out.println("LEAVING REQUEST HELPER TO REQUEST DELEGATE");
					rd.toApproveOrDenyRequest(request, response);
					break;
			}
		}
	}
	
	public void processDelete(HttpServletRequest request, HttpServletResponse response)
	{
		
	}
}
