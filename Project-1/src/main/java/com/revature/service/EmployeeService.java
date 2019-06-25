package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImp;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImp;
import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.util.ValidationUtil;

public class EmployeeService {
	EmployeeDao eDao = new EmployeeDaoImp();
	RequestDao rDao = new RequestDaoImp();
	ValidationUtil valid = new ValidationUtil();
	
	// Attempt to get the employee the user is tring to login to
	public Employee getLogin(String uName, String pWord) {
		if(valid.validateUname(uName)) {
			if(valid.validatePword(pWord)) {
				return eDao.getEmployeeByLogin(uName, pWord);
			}
		}
		return null;
	}
	
	public Employee getEmployee(int id) {
		return eDao.getEmployeeById(id);
	}
	
	// Attempt to get the requests that the employee has made
	public List<Request> getRequests(int id) {
		return rDao.getEmpRequests(id);
	}
	
	// Attempt to create a new request by the employee
	public int newRequest(Request r) {
		return rDao.createRequest(r);
	}
	
	public int changeEmployee(int id, String eMail, String uName, String pWord) {
		if(eMail != "") {
			eDao.changeEmail(id, eMail);
		} if(uName != "") {
			eDao.changeUName(id, uName);
		} if(pWord != "") {
			eDao.changePWord(id, pWord);
		}
		return 0;
	}
}
