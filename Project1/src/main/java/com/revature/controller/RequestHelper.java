package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserAccountDao;
import com.revature.dao.UserAccountDaoImpl;
import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ReimbursementDelegate;
import com.revature.delegates.ViewDelegate;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.model.UserAccount;

public class RequestHelper {
	
	EmployeeDelegate ed = new EmployeeDelegate();
	ViewDelegate vd = new ViewDelegate();
	AuthDelegate ad = new AuthDelegate();
	UserAccountDao uad = new UserAccountDaoImpl();
	ReimbursementDelegate rd = new ReimbursementDelegate();
	ReimbursementDao rbd = new ReimbursementDaoImpl();
	EmployeeDao empDao = new EmployeeDaoImpl();
	static int empId;
	static String userName;
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		String authToken = request.getHeader("Authorization");
		
		if (uri.startsWith("/api/")) {
			String record = uri.substring(5);
		} else {
			vd.returnView(request, response);
		}
		
	}
	
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = "";
		String password = "";
		String amount = "";
		String reason = "";
		String firstName = "";
		String lastName = "";
		String email = "";
		String logoutTrue = "";
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		

		switch (uri) {
		
		case ("/employeeHome") :
			username = request.getParameter("username");
			password = request.getParameter("password");
			amount = request.getParameter("amount");
			reason = request.getParameter("reason");
			firstName = request.getParameter("firstName");
			lastName = request.getParameter("lastName");
			email = request.getParameter("email");
			logoutTrue = request.getParameter("logoutTrue");
			System.out.println("SAY HI TO MY USERNAME: " + request.getParameter("username"));
			
			
			List<UserAccount> users = new ArrayList<>();
			users = uad.getUserAccounts();
			
			List<Reimbursement> reimbursements = new ArrayList<>();
			reimbursements.clear();
			reimbursements = rbd.getReimbursements();
			
			Reimbursement r = new Reimbursement();
			UserAccount u = new UserAccount();
			ObjectMapper om = new ObjectMapper();
			
			String reimString = om.writeValueAsString(reimbursements);
			response.setHeader("Reimbursement", reimString);
			
		
			Employee e = new Employee();
			if (userName != null) {
				UserAccount user = uad.getUserAccountByUsername(userName);
				empId = user.getId();
				e = empDao.getEmployeeById(empId);
			}
			
			System.out.println(username);
			if (userName == null) {
				userName = username;
				empId = uad.getUserAccountByUsername(userName).getId();
				System.out.println(empId);
				e = empDao.getEmployeeById(empId);	
				System.out.println();
			}
			System.out.println(userName);
			
			if (firstName != null || lastName != null || email != null) {
				System.out.println("Updating the Employee");
				e = new Employee(e.getId(), firstName, lastName, email, e.getManagerId());
				empDao.updateEmp2(e, empId);
				e = empDao.getEmployeeById(empId);
			}
			
			System.out.println(e);
						
			if (amount != null) {
				r = rd.addingReimbursement(empId, amount, reason);
				rbd.submitReimbursement(r);
			}
			
								
			String auth = ad.authenticate(username, password);
			System.out.println("Emp ID is: " + empId);

			System.out.println(e);
			
			String empString = om.writeValueAsString(e);
			
			response.setHeader("EmployeeInfo", empString);
			response.setHeader("Authorization", auth);			
			
			response.setStatus(200);
			break;
			
			
	// ---------------------------------------------------------------------------------------------------------------------		
			
		case ("/managerHome") :
			List<Reimbursement> reim = new ArrayList<>();
			reim = rbd.getReimbursements();
			r = new Reimbursement();
			
			
			
			om = new ObjectMapper();
			
			reimString = om.writeValueAsString(reim);
			System.out.println(reimString);
			response.setHeader("Reim", reimString);
			
			
		//	rbd.updateReimbursement(statusA, Integer.parseInt(rIndexA));
			
//			if (statusA != null ) {
//				r = new Reimbursement(Integer.parseInt(idA), Integer.parseInt(amountA), reasonA, statusA, Integer.parseInt(rIndexA));
//				rbd.updateReimbursement(r, statusA, rIndexA);
//			}
			
			break;
			
		case ("/viewEmps") :
			
			List<Employee> emps = new ArrayList<>();
			emps = empDao.getEmployees();
			
			om = new ObjectMapper();
			
			String employees = om.writeValueAsString(emps);
			response.setHeader("Employees", employees);
			
			System.out.println(employees);
			
			
			break;
			
		case ("/changeStatus") :
			

			String statusA;
			String rIndexA;
			String idA;
			String amountA;
			String reasonA;
			
			statusA = request.getParameter("statusA");
			rIndexA = request.getParameter("rIndexA");
			idA = request.getParameter("idA");
			amountA = request.getParameter("amountA");
			reasonA = request.getParameter("reasonA");
			
			System.out.println(statusA + "_" + rIndexA + "_" + idA + "_" + amountA + "_" + reasonA);
			
			System.out.println(Integer.parseInt(amountA) + "_" + statusA + "_" + Integer.parseInt(idA));
			
			rbd.updateReimbursement(Integer.parseInt(amountA), statusA, Integer.parseInt(idA));
			
			
		}
		
	}
	
}
