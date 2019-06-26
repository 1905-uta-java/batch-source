package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.businesslogic.CreateEmployeeService;
import com.revature.businesslogic.SelectEmployeeService;
import com.revature.businesslogic.UpdateEmployeeService;
import com.revature.models.Employee;

public class EmployeeDelegate
{
	SelectEmployeeService selectEmpService = new SelectEmployeeService();
	UpdateEmployeeService updateEmpService = new UpdateEmployeeService();
	
	public EmployeeDelegate()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void toViewOwnInformation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		// send to getEmpInfo service
		System.out.println("LEAVING EMPLOYEE DELEGATE! GOING TO EMPLOYEE SERVICE!");
		selectEmpService.getEmployeeInfo(request, response);
	}
	
	public void toUpdateOwnInformation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("LEAVING EMPLOYEE DELEGATE! GOING TO UPDATE EMPLOYEE SERVICE!");
		// get request body and split it into array
				System.out.println(request);
				System.out.println("REQUEST LENGTH: " + request.getContentLength());
				String fullBody = request.getReader().readLine();
				System.out.println("Full request body is: " + fullBody);
				String[] splitBodyAmp = fullBody.split("&");
//				for (String string : splitBodyAmp)
//				{
//					System.out.println(string);
//				}
				
				// isolate username and password from request body and put the full declaration into an array
				String fullBodyUsername = splitBodyAmp[0];
				String fullBodyPassword = splitBodyAmp[1];
				String fullBodyId = splitBodyAmp[2];
				
//				System.out.println("FULL BODY USERNAME " + fullBodyUsername);
//				System.out.println("FULL BODY PASSWORD " + fullBodyPassword);
//				System.out.println("FULL BODY ID " + fullBodyId);
				
				// split username, password and ID arrays to obtain JUST the username, password, and ID
				String[]splitUsername = fullBodyUsername.split("=");
				String[]splitPassword = fullBodyPassword.split("=");
				String[]splitId = fullBodyId.split("=");
				
				String username = splitUsername[1];
				String password = splitPassword[1];
				String stringId = splitId[1];
				
				// verify fields are correct and parse stringID to an int
				System.out.println("USERNAME IS: " + username);
				System.out.println("PASSWORD IS: " + password);
				System.out.println("ID IS: " + stringId);
				
				boolean usernameNotEmpty = updateEmpService.updatedUsernameNotEmpty(username);
				boolean usernameNotNull = updateEmpService.updatedUsernameNotNull(username);
				boolean passwordNotEmpty = updateEmpService.updatedPasswordNotEmpty(password);
				boolean passwordNotNull = updateEmpService.updatedPasswordNotNull(password);
				
				if (!usernameNotEmpty || !usernameNotNull || !passwordNotEmpty || !passwordNotNull)
				{
					response.sendError(400, "Either your username or password is null or empty!");
				}
		
		updateEmpService.updateEmployeeInfo(request, response, username, password, stringId);
	}
	
	public void toViewAllEmps(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("LEAVING EMP DELEGATE! GOING TO EMP SERVICE");
		selectEmpService.getAllEmps(request, response);
	}
	
}
