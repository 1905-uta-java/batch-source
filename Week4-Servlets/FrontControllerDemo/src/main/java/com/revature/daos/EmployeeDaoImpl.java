package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Department;
import com.revature.models.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private List<Employee> employees = new ArrayList<>();
	
	private DepartmentDao deptDao = new DepartmentDaoImpl();
	
	public EmployeeDaoImpl() {
		employees.add(new Employee(1, "Lisa Jones", 1300, 2));
		employees.add(new Employee(2, "Perry Hansen", 2500, 1));
		employees.add(new Employee(3, "Cindy Jenkins", 2000, 1));
		employees.add(new Employee(4, "Julie Smith", 1600, 3));
		employees.add(new Employee(5, "Ron Mitchell", 1250, 3));
		employees.add(new Employee(6, "Paul Paulson", 1500, 4));
		
	}

	@Override
	public List<Employee> getEmployees() {
		for(Employee e: employees) {
			for(Department d: deptDao.getDepartments()) {
				if(e.getDepartment()!=null && e.getDepartment().getId() == d.getId()) {
					e.setDepartment(d);
				}
			}
		}
		return new ArrayList<Employee>(employees);
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		for(Employee e: employees) {
			if(e.getId() == id) {
				employee = e;
			}
		}
		if(employee!=null && employee.getDepartment()!=null) {
			employee.setDepartment(deptDao.getDepartmentById(employee.getDepartment().getId()));
		}
		return employee;
	}

	@Override
	public int createEmployee(Employee e) {
		int maxId = 0; 
		for(Employee employee: employees) {
			if(employee.getId()>maxId) {
				maxId = employee.getId();
			}
		}
		e.setId(maxId+1);
		employees.add(e);
		return 1;
	}

	@Override
	public int updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
