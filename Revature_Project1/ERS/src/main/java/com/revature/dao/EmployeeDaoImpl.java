package com.revature.dao;


import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.revature.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public boolean isLogIn(Employee e){
		boolean logIn = false;
		String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = ?";
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1,e.getEmpId());
			ResultSet rs = ps.executeQuery();
			
			int username=0;
			String pass="";
			
			while(rs.next()){
				System.out.print("Worked");
				username = rs.getInt("EMP_ID");
				pass = rs.getString("EMP_PASSWORD");
			}
			if(username == e.getEmpId()||pass.equals(e.getPassword())==true) {
				
				logIn= true;
			}else {
				
				logIn= false;
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return logIn;
	}

	public boolean isManager(Employee e) {
		boolean isManager = false;
		String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = ? AND EMP_PASSWORD = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1,e.getEmpId());
			ps.setString(2,e.getPassword());
			ResultSet rs = ps.executeQuery();
			
			String isMan="";
			while(rs.next()){
				isMan = rs.getString("IS_MANAGER");
				
			}
			if(isMan.equals("Y")==true) {
				isManager= true;
			}else {
				isManager= false;
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return isManager;
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee e = null;
		String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				int empId=rs.getInt("EMP_ID");
				String empPass = rs.getString("EMP_PASSWORD");
				String empName =rs.getString("EMP_NAME");
				Double monSal = rs.getDouble("MONTHLY_SALARY");
				String startDate = rs.getString("START_DATE");
				String man = rs.getString("IS_MANAGER");
				String full = rs.getString("FULL_TIME");
				boolean isMan = false;
				boolean isFull = false;
				if(man.equals("Y")==true) {
					isMan = true;
				}else {
					isMan = false;
				}
				if(full.equals("Y")==true) {
					isFull = true;
				}else {
					isFull = false;
				}
				
				e = new Employee(empId, empPass, empName, startDate, monSal, isFull, isMan);
			}
			
			
			
			
			
			rs.close();
		} catch (SQLException ex) {
		}
		return e;
	}

	public void updateFulltime(Employee e, boolean newFullTime) {
		// TODO Auto-generated method stub
		String full;
		if(newFullTime == true) {
			full = "Y";
		}else {
			full = "N";
		}
		
		String sql = "UPDATE EMPLOYEES "
				+ "SET FULL_TIME = ? "
				+ "WHERE EMP_ID = ? AND EMP_PASSWORD = ?" ;
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, full);
			ps.setInt(2, e.getEmpId());
			ps.setString(3, e.getPassword());
			
			int updated = ps.executeUpdate();
			
		} catch (SQLException ex) {
		}
		
	}

	public void updatePassword(Employee e, String newPassword) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE EMPLOYEES "
				+ "SET EMP_PASSWORD = ? "
				+ "WHERE EMP_ID = ? AND EMP_PASSWORD = ?" ;
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, newPassword);
			ps.setInt(2, e.getEmpId());
			ps.setString(3, e.getPassword());
			
			int updated = ps.executeUpdate();
			
		} catch (SQLException ex) {
		}
		
	}

	public boolean createReimbursement(Employee e) {
		// TODO Auto-generated method stub
		int uniqueID = 1234;
		
		String sql = "INSERT INTO REIMBURSEMENT VALUES(?,?,?,?,?,?)" ;
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1,uniqueID);
			ps.setInt(2, e.getEmpId());
			ps.setString(3, e.getEmpName());
			ps.setDouble(4,e.getReAmount());
			ps.setString(5, "Pending");
			ps.setString(6, null);
			
			
			int updated = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
			
		}
		
		return true;
	}

	public void approveReimbursement(Employee e) {
		
		
	}
	
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPLOYEES";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
		while(rs.next()) {
			Employee e = new Employee();
			String isFull="";
			String isMan="";
			
			System.out.println("it entered");
			e.setEmpId(rs.getInt("EMP_ID"));
			e.setPassword(rs.getString("EMP_PASSWORD"));
			e.setEmpName(rs.getString("EMP_NAME"));
			e.setMonthSal(rs.getDouble("MONTHLY_SALARY"));
			e.setStartDate(rs.getString("START_DATE"));
			isMan = rs.getString("IS_MANAGER");
			isFull = rs.getString("FULL_TIME");
			if(isMan.equals("Y")==true) {
				e.setManager(true);
			}else {
				e.setManager(false);
			}
			
			if(isFull.equals("Y")==true) {
				e.setFullTime(true);
			}else {
				e.setFullTime(false);
			}
			employees.add(e);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return employees;
	}
	
	public Employee authenticatedUser(int userId, String password) {
		String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = ? AND EMP_PASSWORD = ?";
			
		

		return null;
	}
	
}
