package com.revature.project1.service;

import com.revature.project1.dao.ReimbursementDAO;
import com.revature.project1.dao.ReimbursementDummyDAO;
import com.revature.project1.dao.RimbursementDatabaseDAO;

public class ServiceManager {
	
	private static ReimbursementDAO dao;
	private static EmployeeService empService;
	private static ReimbursementRequestService requestService;
	private static AuthService authService;
	
	public static ReimbursementDAO getDAO() {
		
//		if(dao == null)
//			dao = new ReimbursementDummyDAO();
		if(dao == null)
			dao = new RimbursementDatabaseDAO();
		
		return dao;
	}
	
	public static EmployeeService getEmpService() {
		
		if(empService == null)
			empService = new EmployeeService(getDAO());
		
		return empService;
	}
	
	public static ReimbursementRequestService getReimbursementRequestService() {
		
		if(requestService == null)
			requestService = new ReimbursementRequestService(getDAO());
		
		return requestService;
	}
	
	public static AuthService getAuthService() {
		
		if(authService == null)
			authService = new AuthService(getDAO());
		
		return authService;
	}
}
