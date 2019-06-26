package com.revature.services;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class LoginService {
	
	EmployeeDao empDao = new EmployeeDaoImpl();
	
	public boolean isManager(Employee e) {
		return empDao.isManager(e);
	}

}
