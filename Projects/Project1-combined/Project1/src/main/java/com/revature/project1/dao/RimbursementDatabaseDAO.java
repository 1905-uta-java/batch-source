package com.revature.project1.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.models.Employee;
import com.revature.project1.models.ReimbursementRequest;
import com.revature.project1.util.ConnectionUtil;

public class RimbursementDatabaseDAO implements ReimbursementDAO {
	
	public RimbursementDatabaseDAO() {
		super();
		System.out.println("DAO constructor");
	}
	
	private Employee getEmployeeFromResultSet(ResultSet result) throws SQLException {
		
		return new Employee(
				result.getInt("EMPLOYEE_ID"),
				result.getString("FIRST_NAME"),
				result.getString("LAST_NAME"),
				result.getString("TITLE"),
				result.getInt("MANAGER_ID"),
				result.getString("EMAIL"),
				result.getString("PHONE"),
				result.getBytes("PASS_HASH"),
				result.getBytes("PASS_SALT"),
				result.getDate("HIRE_DATE"),
				result.getString("ADDRESS"),
				result.getString("CITY"),
				result.getString("STATE"),
				result.getString("COUNTRY"),
				result.getString("POSTAL_CODE")
		);
	}
	
	private ReimbursementRequest getRequestFromResultSet(ResultSet result) throws SQLException {
		
		return new ReimbursementRequest(
				result.getInt("REQUEST_ID"),
				result.getInt("EMPLOYEE_ID"),
				result.getFloat("AMOUNT"),
				result.getDate("DATE_REQUESTED"),
				result.getInt("MANAGER_ID"),
				result.getBoolean("WAS_APPROVED")
		);
	}
	
	public Employee getEmployee(int employeeID) {
		
		Employee emp = null;
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?");
			
			pStatement.setInt(1,  employeeID);
			
			ResultSet result = pStatement.executeQuery();
			
			if(result.next())
				emp = getEmployeeFromResultSet(result);

			pStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return emp;
	}

	public List<Employee> getSubordinates(int managerID) {
		
		List<Employee> subordinates = new ArrayList<Employee>();
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT * " + 
					"FROM EMPLOYEE " + 
					"START WITH EMPLOYEE_ID = ? " + 
					"CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID");
			
			pStatement.setInt(1,  managerID);
			
			ResultSet result = pStatement.executeQuery();
			
			Employee currentEmp;
			
			while(result.next()) {
				
				currentEmp = getEmployeeFromResultSet(result);
				
				if(currentEmp.getEmployeeID() != managerID)
					subordinates.add(currentEmp);
			}
			
			pStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return subordinates;
	}

	public boolean hasManager(int employeeID) {
		
		Employee employee = getEmployee(employeeID);
		
		if(employee == null)
			return false;
		
		return employee.getManagerID() != 0;
	}

	public Employee getEmployeeByEmail(String email) {
		
		Employee emp = null;
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMAIL = ?");
			
			pStatement.setString(1,  email);
			
			ResultSet result = pStatement.executeQuery();
			
			if(result.next())
				emp = getEmployeeFromResultSet(result);

			pStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public void updateEmployee(Employee employee) {
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement(
					  "UPDATE EMPLOYEE "
					+ "SET "
					+ "FIRST_NAME = ?, "
					+ "LAST_NAME = ?, "
					+ "TITLE = ?, "
					+ "MANAGER_ID = ?, "
					+ "EMAIL = ?, "
					+ "PHONE = ?, "
					+ "PASS_HASH = ?, "
					+ "PASS_SALT = ?, "
					+ "HIRE_DATE = ?, "
					+ "ADDRESS = ?, "
					+ "CITY = ?, "
					+ "STATE = ?, "
					+ "COUNTRY = ?, "
					+ "POSTAL_CODE = ? "
					+ "WHERE EMPLOYEE_ID = ?"
			);
			
			pStatement.setString(1,  employee.getFirstName());
			pStatement.setString(2,  employee.getLastName());
			pStatement.setString(3,  employee.getTitle());
			if(employee.getManagerID() != 0)
				pStatement.setInt(4,  employee.getManagerID());
			else
				pStatement.setNull(4, Types.INTEGER);
			pStatement.setString(5, employee.getEmail());
			pStatement.setString(6, employee.getPhone());
			pStatement.setBytes(7, employee.getPasswordHash());
			pStatement.setBytes(8, employee.getPasswordSalt());
			pStatement.setDate(9, new java.sql.Date(employee.getHireDate().getYear(), employee.getHireDate().getMonth(), employee.getHireDate().getDate()));
			pStatement.setString(10, employee.getAddress());
			pStatement.setString(11, employee.getCity());
			pStatement.setString(12, employee.getState());
			pStatement.setString(13,  employee.getCountry());
			pStatement.setString(14, employee.getPostalCode());
			pStatement.setInt(15, employee.getEmployeeID());
			
			pStatement.executeUpdate();

			pStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void createReimbursementRequest(ReimbursementRequest request) {
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			CallableStatement cStatement = connection.prepareCall("{call SUBMIT_REQUEST(?, ?)}");
			
			cStatement.setInt(1, request.getEmployeeID());
			cStatement.setFloat(2, request.getAmount());
			
			cStatement.executeUpdate();
			
			cStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public ReimbursementRequest getReimbursementRequest(int requestID) {
		
		ReimbursementRequest request = null;
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM REIMBURSEMENT_REQUEST WHERE REQUEST_ID = ?");
			
			pStatement.setInt(1,  requestID);
			
			ResultSet result = pStatement.executeQuery();
			
			if(result.next())
				request = getRequestFromResultSet(result);
			
			pStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return request;
	}
	
	public List<ReimbursementRequest> getRequestsForEmployee(int employeeID) {
		
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM REIMBURSEMENT_REQUEST WHERE EMPLOYEE_ID = ?");
			
			pStatement.setInt(1,  employeeID);
			
			ResultSet result = pStatement.executeQuery();
			
			while(result.next())
				 requests.add(getRequestFromResultSet(result));
			
			pStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return requests;
	}

	public List<ReimbursementRequest> getRequestsForManager(int managerID) {
		
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT * " + 
					"    FROM REIMBURSEMENT_REQUEST R " + 
					"    WHERE R.EMPLOYEE_ID IN ( " + 
					"        SELECT EMPLOYEE_ID " + 
					"            FROM EMPLOYEE " + 
					"            START WITH EMPLOYEE_ID = ? " + 
					"            CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID " + 
					"    )");
			
			pStatement.setInt(1,  managerID);
			
			ResultSet result = pStatement.executeQuery();
			
			ReimbursementRequest currentRequest;
			
			while(result.next()) {
				 
				currentRequest = getRequestFromResultSet(result);
				 
				if(currentRequest.getEmployeeID() != managerID)
					requests.add(currentRequest);
			}
			
			pStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return requests;
	}

	public void updateReimbursementRequest(ReimbursementRequest request) {
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement(
					  "UPDATE REIMBURSEMENT_REQUEST "
					+ "SET "
					+ "MANAGER_ID = ?, "
					+ "WAS_APPROVED = ? "
					+ "WHERE REQUEST_ID = ?"
			);
			
			pStatement.setInt(1, request.getManagerID());
			pStatement.setInt(2, (request.getWasApproved()) ? 1 : 0);
			pStatement.setInt(3, request.getRequestID());
			
			pStatement.executeUpdate();

			pStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void removeReimbursementRequest(int requestID) {
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement(
					  "DELETE FROM REIMBURSEMENT_REQUEST "
					+ "WHERE REQUEST_ID = ?"
			);
			
			pStatement.setInt(1, requestID);
			
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
