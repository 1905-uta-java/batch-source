package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>(); //get a connection, create a statement to get a resultset that can be used
		
		String sql = "SELECT * FROM DEPARTMENT";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {
			while(rs.next()) {
				int deptId = rs.getInt("DEPT_ID");
				String name = rs.getString("DEPT_NAME");
				double budget = rs.getDouble("MONTHLY_BUDGET");
				departments.add(new Department(deptId, name, budget));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return departments;
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createDepartment(Department d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDepartment(Department d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDepartment(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
