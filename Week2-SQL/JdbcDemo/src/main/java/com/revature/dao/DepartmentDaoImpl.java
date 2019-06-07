package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
		List<Department> departments = new ArrayList<>();
		
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
			e.printStackTrace();
		}
		
		return departments;
	}

	@Override
	public Department getDepartmentById(int id) {
		
		String sql = "SELECT * FROM DEPARTMENT WHERE DEPT_ID = ?";
		Department d = null;
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int deptId = rs.getInt("DEPT_ID");
				String name = rs.getString("DEPT_NAME");
				double budget = rs.getDouble("MONTHLY_BUDGET");
				d = new Department(deptId, name, budget);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return d;
	}

	@Override
	public int createDepartment(Department d) {
		int departmentsCreated = 0;
		String sql = "INSERT INTO DEPARTMENT VALUES (?,?,?)";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, d.getId());
			ps.setString(2, d.getName());
			ps.setDouble(3, d.getMonthlyBudget());
			departmentsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return departmentsCreated;
	}
	@Override
	public int updateDepartment(Department d) {
		
		int departmentsUpdated = 0;
		String sql = "UPDATE DEPARTMENT "
				+ "SET DEPT_NAME = ?, "
				+ "MONTHLY_BUDGET = ? "
				+ "WHERE DEPT_ID = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			//con.setAutoCommit(false);
			ps.setString(1, d.getName());
			ps.setDouble(2, d.getMonthlyBudget());
			ps.setInt(3, d.getId());
			departmentsUpdated = ps.executeUpdate();
			//con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return departmentsUpdated;
	}

	@Override
	public int deleteDepartment(int id) {
		int rowsDeleted = 0;
		
		String sql = "DELETE FROM DEPARTMENT WHERE DEPT_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
	}

	@Override
	public void increaseDepartmentBudget(Department d, double increaseAmount) {
		
		String sql = "{call INCREASE_BUDGET(?,?)}";
		
		try(Connection con = ConnectionUtil.getConnection();
				CallableStatement cs = con.prepareCall(sql)){
			
			cs.setInt(1, d.getId());
			cs.setDouble(2, increaseAmount);
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
