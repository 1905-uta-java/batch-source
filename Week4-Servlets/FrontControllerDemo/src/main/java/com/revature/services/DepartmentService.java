package com.revature.services;

import java.util.List;

import com.revature.daos.DepartmentDao;
import com.revature.daos.DepartmentDaoImpl;
import com.revature.models.Department;

public class DepartmentService {
	
	DepartmentDao dptDao = new DepartmentDaoImpl();
	
	public List<Department> getAll(){
		return dptDao.getDepartments();
	}
	
	// getById, other crud methods
			


}
