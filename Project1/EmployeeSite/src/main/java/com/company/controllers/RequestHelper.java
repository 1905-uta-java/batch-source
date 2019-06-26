package com.company.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.delegates.AuthDelegate;
import com.company.delegates.EmployeeDelegate;
import com.company.delegates.EventsDelegate;
import com.company.delegates.NewsDelegate;
import com.company.delegates.ReimbursementDelegate;
import com.company.delegates.ViewDelegate;
import com.company.model.Employee;
import com.company.model.Events;
import com.company.model.News;
import com.company.model.Reimbursement;
import com.company.util.ValidationUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestHelper {
	
	//All my delegates
	private ViewDelegate vd = new ViewDelegate();
	private AuthDelegate ad = new AuthDelegate();
	private EmployeeDelegate ed = new EmployeeDelegate();
	private ReimbursementDelegate rd = new ReimbursementDelegate();
	private EventsDelegate evd = new EventsDelegate();
	private NewsDelegate nd = new NewsDelegate();
	
	
	private ObjectMapper om = new ObjectMapper();
	
	//Handle distributing requests to the correct delegates
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//The URI from the request body with only the path information
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		//Check if the uri starts with api to determine if its a request for information or to view a page
		if(uri.startsWith("/api/")) {
			
			//Create a print writer
			PrintWriter pw = response.getWriter();
			
			//Authenticate token
			String token = request.getHeader("Authorization");
			
			if(!ad.isAuth(token)) {
				response.sendRedirect(request.getContextPath()+"/loginPage");
				return;
			}
			
			//Determine which delegate to go to
			switch(uri) {
		
			//Get Relevant information on Employees 
			case "/api/employees":
				List<Employee> emps = ed.getRelevantEmployees(request, response);
				
				//Convert to JSON
				String empsJSON = om.writeValueAsString(emps);
				
				//Write the JSON to response body
				pw.write(empsJSON);
				response.setStatus(200);
				break;
				
			//Get the employee's information
			case "/api/employee":
				Employee emp = ed.getEmployeeInfo(request, response);
				
				//Convert to JSON
				String empJSON = om.writeValueAsString(emp);
				
				//Write the JSON to response body
				pw.write(empJSON);
				response.setStatus(200);
				break;
				
			//get relevant information on Employees
			case "/api/reimbursements":
				List<Reimbursement> reimb = rd.getRelevantReimbRequests(request, response);
				
				//Convert to JSON
				String reimbJSON = om.writeValueAsString(reimb);
				
				//Write the JSON to response body
				pw.write(reimbJSON);
				response.setStatus(200);
				break;
				
			//get the employee's events
			case "/api/events":
				List<Events> evs = evd.getEmpEvents(request, response);
				
				//Convert to JSON
				String evsJSON = om.writeValueAsString(evs);
				
				//Write the JSON to response body
				pw.write(evsJSON);
				response.setStatus(200);
				break;
				
			//get all the work news
			case "/api/news":
				List<News> news = nd.getNewsInfo(request, response);
				
				//Convert to JSON
				String newsJSON = om.writeValueAsString(news);
				
				//Write the JSON to response body
				pw.write(newsJSON);
				response.setStatus(200);
				break;
				
			default:
				response.sendError(404, "Not Supported");
			}
		}else if(uri.equals("/login")) {
			//Get email and password form parameters
			String email = request.getHeader("Email");
			String password = request.getHeader("Password");
			
			//Check that what was given is both a valid email and password before connecting to database
			if(ValidationUtil.validEmail(email) && ValidationUtil.validPassword(password)) {
				
				String auth = ad.authenticate(email, password);
				//Check if auth was successful or failed
				if(auth == null) {
					//Send a failure
					response.setStatus(401);
				}else {
					//Send token in the header
					response.setStatus(200);
					response.setHeader("Authorization", auth);
				}
			}else {
				//Send a failure
				response.setStatus(401);
			}
		}else {
			vd.returnView(request,response);
		}
	}

	//Handle distributing Post requests to the correct delegates
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//The URI from the request body with only the path information
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		//Authenticate token
		String token = request.getHeader("Authorization");
		
		if(!ad.isAuth(token)) {
			response.sendRedirect(request.getContextPath()+"/loginPage");
			return;
		}
		
		//Verification int
		int verify = 0;
		//Switch statement to determine what object is being created
		switch(uri) {
		
		//Create a new employee with delegate
		case "/api/employee":
			verify = ed.createEmployee(request, response);
			break;
			
		//Create a new reimbursement with delegate
		case "/api/reimbursement":
			verify = rd.createReimbRequest(request, response);
			break;
			
		//Create a new reimbursement with delegate
		case "/api/events":
			verify = evd.createEvents(request, response);
			break;
			
		//Create a new news with delegate
		case "/api/news":
			verify = nd.createNews(request, response);
			break;
			
		default:
			//If all else, return error.
			response.sendError(404, "Not Supported");
		}
			
		//Check that the database has object added. 
		if(verify > 0) {
			response.setStatus(200);
		}else {
			//failed to create new entry
			response.setStatus(404);
		}
		
	}

	//Handle distributing Put requests to the correct delegates
	public void processPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//The URI from the request body with only the path information
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		//Authenticate token
		String token = request.getHeader("Authorization");
		
		if(!ad.isAuth(token)) {
			response.sendRedirect(request.getContextPath()+"/loginPage");
			return;
		}
		
		//Verification int
		int verify = 0;
		//Switch statement to determine what object is being created
		switch(uri) {
		
		//Update employee with delegate
		case "/api/employee":
			verify = ed.updateEmployee(request, response);
			break;
			
		//Update employee with delegate
		case "/api/employee/promote":
			verify = ed.promoteEmployee(request, response);
				break;
				
		//Update employee with delegate
		case "/api/employee/changepassword":
			verify = ed.changePassword(request, response);
				break;
			
		//Update reimbursement with delegate
		case "/api/reimbursement":
			verify = rd.updateReimbRequest(request, response);
			break;
			
		//Update reimbursement with delegate
		case "/api/events":
			verify = evd.updateEvents(request, response);
			break;
			
		//Update news with delegate
		case "/api/news":
			verify = nd.updateNews(request, response);
			break;
			
		//
			
		default:
			//If all else, return error.
			response.sendError(404, "Not Supported");
		}
			
		//Check that the database has object added. 
		if(verify > 0) {
			response.setStatus(201);
		}else {
			//failed to create new entry
			response.setStatus(404);
		}
		
	}

	//Handle distributing Delete requests to the correct delegates
	public void processDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//The URI from the request body with only the path information
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		//Authenticate token
		String token = request.getHeader("Authorization");
		
		if(!ad.isAuth(token)) {
			response.sendRedirect(request.getContextPath()+"/loginPage");
			return;
		}
		
		//Verification int
		int verify = 0;
		//Switch statement to determine what object is being created
		switch(uri) {
		
		//Delete employee with delegate
		case "/api/employee":
			verify = ed.deleteEmployee(request, response);
			break;
			
		//Delete reimbursement with delegate
		case "/api/reimbursement":
			verify = rd.deleteReimbRequest(request, response);
			break;
			
		//Delete event with delegate
		case "/api/events":
			verify = evd.deleteEvents(request, response);
			break;
			
		//Delete news with delegate
		case "/api/news":
			verify = nd.deleteNews(request, response);
			break;
			
		default:
			//If all else, return error.
			response.sendError(404, "Not Supported");
		}
			
		//Check that the database has object added. 
		if(verify > 0) {
			response.setStatus(202);
		}else {
			//failed to create new entry
			response.setStatus(404);
		}
		
	}

}
