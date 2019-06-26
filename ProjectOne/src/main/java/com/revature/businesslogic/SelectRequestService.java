package com.revature.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.RequestDAOImpl;
import com.revature.models.Request;

public class SelectRequestService
{
	RequestDAOImpl reqDaoObject = new RequestDAOImpl();
	EmployeeDAOImpl empDaoObject = new EmployeeDAOImpl();
	
	public SelectRequestService()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void getPendingRequestsForEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println(request);
		
		String token = request.getParameter("token");
		System.out.println(token);
		String stringID = token.substring(0, 1);
		int id = Integer.parseInt(stringID);
		List<Request> allRequests = reqDaoObject.viewPendingRequestsForYourself(id);
		
		 //use jackson databind 
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(allRequests));
		pw.close();
	}
	
	public void getResolvedRequestsForEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println(request);
		
		String token = request.getParameter("token");
		System.out.println(token);
		String stringID = token.substring(0, 1);
		int id = Integer.parseInt(stringID);
		List<Request> allRequests = reqDaoObject.viewResolvedRequestsForYourself(id);
		
		 //use jackson databind 
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(allRequests));
		pw.close();
	}
	
	public void getPendingRequestsForAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("ENTERED GETPENDINGREQUESTSFORALL METHOD");
		System.out.println(request);
		List<Request> allRequests = reqDaoObject.viewAllPendingRequestsManagers();
		System.out.println("DAO SHOULD HAVE RETRIEVED OBJECTS BY NOW");
		
		 //use jackson databind 
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(allRequests));
		pw.close();
	}
	
	
	public void getResolvedRequestsForAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("ENTERED GET RESOLVED REQUESTS FOR ALL METHOD");
		System.out.println(request);
		List<Request> allRequests = reqDaoObject.viewAllResolvedWithResolveInfo();
		System.out.println("DAO SHOULD HAVE RETRIEVED OBJECTS BY NOW");
		
		 //use jackson databind 
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(allRequests));
		pw.close();
	}
	
	public void getAllReqsForSingleEmp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println(request);
		String id = request.getParameter("enteredNumber");
		System.out.println("ID is: " + id);
		int idNumber = Integer.parseInt(id);
		List<Request> allRequests = reqDaoObject.viewRequestsByEmployee(idNumber);
		
		 //use jackson databind 
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(allRequests));
		pw.close();
	}
	
	public boolean enteredIdIsNonNumber(String id)
	{
		if (id.matches("^[0-9]+$"))
		{
			return false;
		}
		else
		{
			System.out.println("ID is nonNumbers=!");
			return true;
		}
	}
	
	public boolean enteredIdAboveMaxId(String id)
	{
		int enteredId;
		try
		{
			 enteredId = Integer.parseInt(id);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		
		return enteredIdAboveMaxId(enteredId);
	}
	
	public boolean enteredIdAboveMaxId(int id)
	{
		int maxId = empDaoObject.getMaxEmpID();
		
		if (id > maxId)
		{
			System.out.println("Theres no way that " + id + "can be an Id!" + maxId + "is less than that!");
			return true;
		}
		else
		{
			return false;
		}
	}
}
