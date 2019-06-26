package com.revature.dao;

import java.util.List;
import com.revature.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public int createEmp(Employee e);
	public int updateEmp(Employee e, int id);
	public int deleteEmp(int id);
	public int updateEmp2(Employee e, int id);

}
