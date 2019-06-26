package com.revature.daos;
import com.revature.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() throws SQLException {
		List<Employee> employees = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = ConnectionUtil.getHardCodedConnection();
			
			// create a SQL statement
			String sql = "SELECT * FROM EMPLOYEE ORDER BY ID ASC";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				
				// retrieve data from a result set row
				int id = myRs.getInt("ID");
				String firstName = myRs.getString("FIRST_NAME");
				String lastName = myRs.getString("LAST_NAME");
			    String position = myRs.getString("POSITION");
				String startDate = myRs.getDate("START_DATE").toString();
				String location = myRs.getString("LOCATION");
				Double salary = myRs.getDouble("SALARY");

				// create new employee object
				Employee tempEmployee = new Employee(id, firstName, lastName, position, startDate, location, salary);
				
				// add it to the list of employees
				employees.add(tempEmployee);
			}
			return employees;

		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close(); // doesn't really close...just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
