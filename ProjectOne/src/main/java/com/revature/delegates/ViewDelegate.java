package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate
{
	
	
	public ViewDelegate()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public void directToView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("Your path is " + path);
		
		switch (path)
		{
			case ("/login"):
			{
				System.out.println("You entered the login case!");
				request.getRequestDispatcher("static/login.html").forward(request, response);
				break;
			}
			case ("/employeehome"):
			{
				System.out.println("You entered the employee homepage!");
				request.getRequestDispatcher("static/EmployeeHomepage.html").forward(request, response);
				break;
			}
			case("/managerhome"):
			{
				System.out.println("You entered the manager homepage!");
				request.getRequestDispatcher("static/ManagerHomepage.html").forward(request, response);
				break;
			}
			case("/logout"):
			{
				System.out.println("YOU ARE BEING LOGGED OUT!");
				request.getRequestDispatcher("static/logout.html").forward(request, response);
				break;
			}
			
			case("/createRequest"):
			{
				System.out.println("YOU ARE CREATING A REQUEST!");
				request.getRequestDispatcher("static/createRequest.html").forward(request, response);
				break;
			}
			case ("/viewPending"):
			{
				System.out.println("You are viewing your own requests!");
				request.getRequestDispatcher("static/viewPending.html").forward(request, response);
				break;
			}
			
			case("/viewResolved"):
			{
				System.out.println("YOU ARE VIEWING YOUR OWN RESOLVED REQUESTS");
				request.getRequestDispatcher("static/viewResolved.html").forward(request, response);
				break;
				
			}
			
			case ("/viewInformation"):
			{
				System.out.println("YOU ARE VIEWING YOUR OWN INFORMATION");
				request.getRequestDispatcher("static/viewInformation.html").forward(request, response);
				break;
			}
			case ("/updateInformation"):
			{
				System.out.println("YOU ARE UPDATING YOUR OWN INFORMATION");
				request.getRequestDispatcher("static/updateInformation.html").forward(request, response);
				break;
			}
			
			case ("/viewAllPending"):
			{
				System.out.println("AS A MANGER, TAKING TO VIEWING ALL PENDING");
				request.getRequestDispatcher("static/viewAllPending.html").forward(request, response);
				break;
			}
			case ("/viewAllResolved"):
			{
				System.out.println("AS A MANAGER, GOING TO VIEW ALL RESOLVED");
				request.getRequestDispatcher("static/viewAllResolved.html").forward(request, response);
				break;
			}
			case("/viewAllEmps"):
			{
				System.out.println("AS A MANAGER, TAKING TO VIEW ALL EMPS PAGE");
				request.getRequestDispatcher("static/viewAllEmps.html").forward(request, response);
				break;
			}
			case("/viewReqFromSingleEmp"):
			{
				System.out.println("AS A MANAGER, TAKING TO VIEW REQS FROM SINGLE EMP PAGE");
				request.getRequestDispatcher("static/viewReqFromSingleEmp.html").forward(request, response);
				break;
			}
			case("/approveOrDeny"):
			{
				System.out.println("AS A MANAGER, TAKING TO APPROVE OR DENY REQEUSTS");
				request.getRequestDispatcher("static/approveOrDeny.html").forward(request, response);
				break;
			}
				
			
			default:
			{
				response.sendError(404, "Static Resource not found!");
			}
		}
	}
}
