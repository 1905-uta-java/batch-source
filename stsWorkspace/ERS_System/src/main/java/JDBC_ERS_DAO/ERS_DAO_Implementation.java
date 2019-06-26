package JDBC_ERS_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ERS_Actors.ERS_Request;
import JDBC_ERS_Conn.ERS_Connection;

public class ERS_DAO_Implementation implements ERS_DAO {
	
	/**
	 * Description - Returns a List of all requests that exist within the ERS_REQUEST table
	 * @param - none
	 * @returns - a List that contains ERS_request objects instantiated from the ERS_REQUEST table, an empty List otherwise
	 * @throws - SQLException if database access causes an error or connection is closed
	 */
	@Override
	public List<ERS_Request> getAllRequests() {
		List<ERS_Request> ersList = new ArrayList<>();
		String sql = "SELECT * FROM ERS_REQUEST"; //SQL query statement to be executed
		
		try (Connection con = ERS_Connection.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ersList.add(
					new ERS_Request(
						rs.getInt("REQ_ID"),
						rs.getInt("EMP_ID"),
						rs.getDouble("AMOUNT"),
						rs.getString("STATUS"),
						rs.getString("COMMENTS")
					));}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ersList;
	}
	
	/**
	 * Description - Returns a List of ERS_Requests pertaining to a specified employee by ID
	 * @param - emp_id: Integer representation of the employee being queried
	 * @return - A List of ERS_Requests pertaining to the specified employee, an empty List otherwise
	 * @throws - SQLException if database access causes an error or connection is closed
	 */
	@Override
	public List<ERS_Request> getRequestByEmp(int emp_id) {
		List<ERS_Request> ersList = new ArrayList<>();
		String sql = "SELECT * FROM ERS_REQUEST WHERE EMP_ID = ?"; //SQL query statement to be executed
		
		try (Connection con = ERS_Connection.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, emp_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ersList.add(
						new ERS_Request(
							rs.getInt("REQ_ID"),
							rs.getInt("EMP_ID"),
							rs.getDouble("AMOUNT"),
							rs.getString("STATUS"),
							rs.getString("COMMENTS")
						));}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ersList;
	}
	
	/**
	 * Description - Returns an ERS_Request object that matches the desired req_id parameter
	 * @param - req_id: Integer representation of the request id being queried from the ERS_REQUEST table
	 * @returns - an ERS_Request object
	 * @throws - SQLException if database access causes an error or connection is closed
	 */
	@Override
	public ERS_Request getRequestByReq(int req_id) {
		ERS_Request ers = null;
		String sql = "SELECT * FROM ERS_REQUEST WHERE REQ_ID = ?"; //SQL query statement to be executed
		
		try (Connection con = ERS_Connection.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, req_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ers = new ERS_Request(
					rs.getInt("REQ_ID"),
					rs.getInt("EMP_ID"),
					rs.getDouble("AMOUNT"),
					rs.getString("STATUS"),
					rs.getString("COMMENTS")
				);}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ers;
	}
	
	/**
	 * Description - Create a new ERS_Request in the ERS_REQUEST table
	 * @param - req: ERS_Request object that holds the necessary information to add a new row into ERS_REQUEST table
	 * @returns - the row count the ERS_Request object was inserted into or 0 if insertion failed.
	 * @throws - SQLException if database access causes an error or connection is closed
	 */
	@Override
	public int createRequest(ERS_Request req) {
		int created = 0;
		String sql = "INSERT INTO ERS_REQUEST "
				+ "VALUES (?, ?, ?, ?, ?)"; //SQL query statement to be executed
		
		try (Connection con = ERS_Connection.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, req.getReq_id());
			ps.setInt(2, req.getEmp_id());
			ps.setDouble(3, req.getAmount());
			ps.setString(4, req.getStatus());
			ps.setString(5, req.getComments());
			
			created = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return created;
	}
	
	/**
	 * Description - Update an ERS_Request in the ERS_REQUEST table
	 * @param - req: ERS_Request object that holds the necessary information to update an existing row in ERS_REQUEST table
	 * @returns - the row count of ERS_Request that was updated or 0 if update failed.
	 * @throws - SQLException if database access causes an error or connection is closed
	 */
	@Override
	public int updateRequest(ERS_Request req) {
		int updated = 0;
		String sql = "UPDATE ERS_REQUEST "
				+ "SET EMP_ID = ?, "
				+ "AMOUNT = ?, "
				+ "STATUS = ?, "
				+ "COMMENTS = ? "
				+ "WHERE REQ_ID = ?"; //SQL query statement to be executed
		
		try (Connection con = ERS_Connection.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, req.getEmp_id());
			ps.setDouble(2, req.getAmount());
			ps.setString(3, req.getStatus());
			ps.setString(4, req.getComments());
			ps.setInt(5, req.getReq_id()); //WHERE
			
			updated = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return updated;
	}
	
	/**
	 * Description - Updates and inserts into the ERS_REQUEST table in sql db by going through a List containing ERS_Request objects
	 * @param - req: List that contains the ERS_Request objects that will be used to update and insert into the sql db table
	 * @return - the row count of ERS_Requests that were updated or 0 if update failed.
	 * @throws - SQLException if database access causes an error or connection is closed
	 * @throws - NullPointerException if the parameter req is an empty List
	 */
	@Override
	public int updateRequest(List<ERS_Request> req) {
		int updated = 0;
		//String sql = "SELECT * FROM ERS_REQUEST WHERE EMP_ID = ?"; //SQL query statement to be executed
		
		try {
			for(int x = 0; x < req.size(); x++) {
				ERS_Request existChecker = this.getRequestByReq(req.get(x).getReq_id()); //pull from the db the record corresponding with the object's req_id in the current List index
				
				if(existChecker == null) {
					this.createRequest(req.get(x)); //create a new record in the sql db table since it doesn't exist
				} else {
					this.updateRequest(req.get(x)); //update the existing record
				}
			}
		} catch(NullPointerException e) {
			return 0; //updated failed because the List is empty
		}
		
		
		return updated;
	}
	
	public int getNextReqId() {
		int index = 0;
		
		//String for query
		String sql = "SELECT MAX(ERS_REQUEST.REQ_ID) AS COUNT FROM ERS_REQUEST";
		
		try (Connection con = ERS_Connection.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareCall(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				index = rs.getInt("COUNT") + 1; //Get the current highest value in primary key and INCREMENT FOR NEXT PKEY
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return index; //returns the next value of primary key
	}

}
