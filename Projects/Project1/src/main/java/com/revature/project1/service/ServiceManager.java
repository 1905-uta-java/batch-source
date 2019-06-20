package com.revature.project1.service;

import com.revature.project1.dao.ReimbursementDAO;
import com.revature.project1.dao.ReimbursementDummyDAO;

public class ServiceManager {
	
	private static ReimbursementDAO dao;
	private static EmployeeService empService;
	private static ReimbursementRequestService requestService;
	
	public static ReimbursementDAO getDAO() {
		
		if(dao == null)
			dao = new ReimbursementDummyDAO();
		
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
}
