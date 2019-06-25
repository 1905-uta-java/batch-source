package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImp;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImp;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImp;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.util.ValidationUtil;

public class ManagerService {
	ManagerDao mDao = new ManagerDaoImp();
	EmployeeDao eDao = new EmployeeDaoImp();
	RequestDao rDao = new RequestDaoImp();
	ValidationUtil valid = new ValidationUtil();
	
	// Attempt to get the manager object the user is trying to login to
	public Manager getLogin(String uName, String pWord) {
		if(valid.validateUname(uName)) {
			if(valid.validatePword(pWord)) {
				return mDao.getManagerByLogin(uName, pWord);
			}
		}
		return null;
	}
	
	public Manager getManager(int id) {
		return mDao.getManagerById(id);
	}
	
	// Attempt to get all of the requests
	public List<Request> getRequests(List<Employee> eList) {
		List<Request> rList = new ArrayList<Request>();
		for(Employee e : eList) {
			List<Request> eRequests = rDao.getEmpRequests(e.getId());
			for(Request r : eRequests) {
				rList.add(r);
			}
		}
		return rList;
	}
	
	// Attempt to get all of the employees
	public List<Employee> getEmployees(int id) {
		return eDao.getEmployeesByManId(id);
	}
	
	// Attempt to get a particular employee
	public Employee getEmployee(int id) {
		return eDao.getEmployeeById(id);
	}
	
	// Attempt to approve a request
	public int approveRequest(int id, int mId) {
		return rDao.approveRequest(id, mId);
	}
	
	// Attempt to change the manager's information
	public int changeManager(int id, String eMail, String uName, String pWord) {
		if(eMail != "") {
			mDao.changeEmail(id, eMail);
		} if(uName != "") {
			mDao.changeUName(id, uName);
		} if(pWord != "") {
			mDao.changePWord(id, pWord);
		}
		return 0;
	}
}
