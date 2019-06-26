package com.revature.daos;

import com.revature.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao {


	@Override
	public Reimbursement getReimbursementById (int idToFind) throws SQLException {
		Reimbursement theReimbursement = null;
		// declare JDBC variables
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// add the reimbursement to the database
			// get a connection
			myConn = ConnectionUtil.getHardCodedConnection();
			
			// set parameters
			String sql = "select * from REIMBURSEMENT where id = ?";

			// create prepared statement 
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, idToFind);

			// execute SQL query
			myRs = myStmt.executeQuery(sql);		
			
			while (myRs.next()) {
				String dateApproved;
				// retrieve data from a result set row
				int id = myRs.getInt("ID");
				String category = myRs.getString("CATEGORY");
				String status = myRs.getString("STATUS");
			    double amount = myRs.getDouble("AMOUNT");
				String dateSubmitted = myRs.getDate("DATE_SUBMITTED").toString();
				int approvingManagerId = myRs.getInt("APPROVING_MGR_ID");
				try {
					dateApproved = myRs.getString("DATE_APPROVED").toString();
				} catch (Exception e) {
					// catch when null and no manager has yet approved
					dateApproved = "NA";
				}				
				int employeeId = myRs.getInt("EMPLOYEEID");
				
				// create new reimbursement object
				theReimbursement = new Reimbursement(id, category, status, amount, dateSubmitted,
						approvingManagerId, dateApproved, employeeId);
				
			}
			return theReimbursement;

		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
	}
	
	@Override
	public List<Reimbursement> getReimbursements() throws SQLException {
		List<Reimbursement> reimbursements = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = ConnectionUtil.getHardCodedConnection();
			
			// create a SQL statement
			String sql = "SELECT * FROM REIMBURSEMENT ORDER BY ID ASC";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				String dateApproved;
				// retrieve data from a result set row
				int id = myRs.getInt("ID");
				String category = myRs.getString("CATEGORY");
				String status = myRs.getString("STATUS");
			    double amount = myRs.getDouble("AMOUNT");
				String dateSubmitted = myRs.getDate("DATE_SUBMITTED").toString();
				int approvingManagerId = myRs.getInt("APPROVING_MGR_ID");
				try {
					dateApproved = myRs.getString("DATE_APPROVED").toString();
				} catch (Exception e) {
					// catch when null and no manager has yet approved
					dateApproved = "NA";
				}				
				int employeeId = myRs.getInt("EMPLOYEEID");
				
				// create new employee object
				Reimbursement tempReimbursements = new Reimbursement(id, category, status, amount, dateSubmitted,
						approvingManagerId, dateApproved, employeeId);
				
				// add it to the list of employees
				reimbursements.add(tempReimbursements);
			}
			return reimbursements;

		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
	}

	@Override
	public void createReimbursement(Reimbursement r) throws SQLException {
		// declare JDBC variables
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			// add the reimbursement to the database
			// get a connection
			myConn = ConnectionUtil.getHardCodedConnection();
			
			// set parameters
			String sql = "insert into REIMBURSEMENT " + "values (NULL, ?, 'Pending', ?, CURRENT_TIMESTAMP, NULL, NULL, ?)";

			// create prepared statement 
			myStmt = myConn.prepareStatement(sql);
			// ID for reimbursement is auto-increment
			myStmt.setString(1, r.getCategory());
			// STATUS is assigned pending
			myStmt.setDouble(2, r.getAmount());
			// APPROVING_MGR_ID is assigned null
			// DATE_APPROVED is assigned null
			myStmt.setInt(3, r.getEmployeeId());
	
			// execute SQL insert
			myStmt.execute();		
		} 
		finally {
			// update api
			getReimbursements();
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
	
	@Override
	public void approveReimbursement(Reimbursement r) throws SQLException {
		// declare JDBC variables
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			// add the reimbursement to the database
			// get a connection
			myConn = ConnectionUtil.getHardCodedConnection();
			
			// set parameters
			// update the corresponding table
			String sql = "UPDATE REIMBURSEMENT SET APPROVING_MGR_ID = ?, STATUS = 'APPROVED', DATE_APPROVED = CURRENT_TIMESTAMP WHERE ID = ?";
		
			// create prepared statement 
			myStmt = myConn.prepareStatement(sql);
			// get approving managers id
			myStmt.setInt(1, r.getApprovingManagerId());
			// get id of reimbursement
			myStmt.setDouble(2, r.getId());

	
			// execute SQL insert
			myStmt.execute();		
		} 
		finally {
			// update api
			getReimbursements();
			// clean up JDBC objects
			close(myConn, myStmt, null);
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