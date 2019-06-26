package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ReimburseDelegate;
import com.revature.delegates.UserDelegate;
import com.revature.delegates.ViewDelegate;
import com.revature.models.User;

public class RequestHelper {
	private ViewDelegate vd;
	private AuthDelegate ad;
	private EmployeeDelegate ed;
	private UserDelegate ud;
	private ReimburseDelegate rd;
	
	public RequestHelper() {
		this.vd = new ViewDelegate();
		this.ad = new AuthDelegate();
		this.ed = new EmployeeDelegate();
		this.ud = new UserDelegate();
		rd = new ReimburseDelegate();
	}
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("Made it to the RH!");
		if(uri.startsWith("/api/")) {
			String record = uri.substring(5);
			switch(record) {
				case "employees":
					ed.getEmployees(request, response);
					break;
				case "user":
					ud.getUsers(request, response);
					break;
				case "remUpd":
					System.out.println("REM UPD here");
					rd.updReimburse(request, response);
					break;
			}
		} else 
			vd.returnView(request, response);
	}
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("Logging in user....idk whatever their name is");
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		String username = "";
		String password = "";
		String id = "";
		String auth = "";
		System.out.println("Process Post RH URI: " + uri);
		
		switch(uri) {
		case"/login":
			username = request.getParameter("username");
			password = request.getParameter("password");
			System.out.println("ProcessPost username & pass: " + username + " " + password);
			auth = ad.authenticate(username, password);
						
			if(auth == null) {
				System.out.println("Sending 401");
				response.setStatus(401);
			}
			else {
				response.setStatus(200);
				response.setHeader("Authorization", auth);
			}
			break;
			
		case "/empInfo":
			username = request.getParameter("username");
			System.out.println("EMP INFO here. Username = " + username);
			
			User u = ud.getSingleUser(username);
			ed.returnEmpByUser(request, response, u);
			break;
		
		case "/newEmp":
			System.out.println("\n\nNEW EMPLOYEE INCOMING!!!\n");
			int inId = ed.createEmployee(request, response);
			ud.createUser(request, response, inId);
			break;
			
		case "/userInfo":
			System.out.println("USER INFO here");
			username = request.getParameter("username");
			ud.returnUserInfo(request, response, username);
			break;
			
		case "/remInfo":
			System.out.println("REM INFO here");
			id = request.getParameter("userId");
			rd.returnRemInfo(request, response, id);
			break;
			
		case "/remReq":
			System.out.println("REM REQ here");
			rd.newReimburse(request, response);
			break;
			
		case "/updEmp":
			System.out.println("UPD EMP here");
			ed.updateEmployee(request, response);
			ud.updateUser(request, response);
			break;
			
		case "/allEmps":
			System.out.println("ALL EMPS here");
			ed.getEmployees(request, response);
			break;
			
		case "/allRems":
			System.out.println("PRINTING ALL REMS here");
			rd.getAll(request, response);

		case "/remPush":
			System.out.println("REM REQ here");
			rd.pushToDb();
			break;
		
		case "/adminRemReq":
			System.out.println("ADMIN REQUESTED IT ALLLLLLL");
			rd.adminRequest(request, response);
			break;
			
		case "/approveRem":
			System.out.println("APPROVING Reimbursement");
			id = request.getParameter("remId");
			System.out.println("APPROVED: " + id);
			rd.approve(Integer.parseInt(id));
			break;
		
		case "/denyRem":
			System.out.println("REJECTING Reimbursement");
			id = request.getParameter("remId");
			System.out.println("DENIED: " + id);
			rd.deny(Integer.parseInt(id));
			break;

			
		case "/logout":
			System.out.println("LOGGING OUT...");
			ed.logout();
			ud.logout();
			rd.logout();
			break;
			
		default:
			System.out.println("nah");
			
		}
	}
}
