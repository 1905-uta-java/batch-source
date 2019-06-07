package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Department;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	DepartmentDao dd = new DepartmentDaoImpl();

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
		while(rs.next()) {
			Employee e = new Employee();
			
			int employeeId = rs.getInt("EMP_ID");
			e.setId(employeeId);
			
			String name = rs.getString("EMP_NAME");
			e.setName(name);
			
			double salary = rs.getDouble("MONTHLY_SALARY");
			e.setMonthlySalary(salary);
			
			String pos = rs.getString("EMP_POSITION");
			e.setPosition(pos);
			
			int managerId = rs.getInt("MANAGER_ID");
			e.setManagerId(managerId);
			
			int deptId = rs.getInt("DEPT_ID");
			e.getDepartment().setId(deptId);
			
			employees.add(e);

		}

		List<Department> departments = dd.getDepartments();
		
		for(Employee e: employees) {
			int deptId = e.getDepartment().getId();
			if(deptId!=0) {
				for(Department d: departments) {
					if(deptId == d.getId()) {
						e.setDepartment(d);
					}
				}
			}
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createEmployee(Employee d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmployee(Employee d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
