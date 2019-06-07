package com.revature.dao;

import java.util.List;

import com.revature.model.Department;

public interface DepartmentDao {
	
	public List<Department> getDepartments();
	public Department getDepartmentById(int id);
	public int createDepartment(Department d);
	public int updateDepartment(Department d);
	public int deleteDepartment(int id);

}
