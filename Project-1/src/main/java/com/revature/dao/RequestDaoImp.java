package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Request;
import com.revature.util.ConnectionUtil;

public class RequestDaoImp implements RequestDao {

	public List<Request> getRequests() {
		List<Request> requests = new ArrayList<Request>();
		
		String sql = "SELECT * FROM REIMBURSE_REQUEST";
		
		// Attempt to retrieve the Requests from the table
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int reimId = rs.getInt("REIMID");
				int empId = rs.getInt("EMPLOYEEID");
				double amount = rs.getDouble("AMOUNT");
				String reason = rs.getString("REASON");
				int appBy = rs.getInt("APPROVED_BY");
				int denBy = rs.getInt("DENIED_BY");
				requests.add(new Request(reimId, empId, amount, reason, appBy, denBy));
			}
		} catch (SQLException e) {
			System.out.println("Failed to retrieve all the requests");
		}
		return requests;
	}
	
	public List<Request> getEmpRequests(int eId) {
		List<Request> requests = new ArrayList<Request>();
		
		String sql = "SELECT * FROM REIMBURSE_REQUEST WHERE EMPLOYEEID = ?";
		
		// Attempt to retrieve the Requests from the table
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1,  eId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIMID");
				int empId = rs.getInt("EMPLOYEEID");
				double amount = rs.getDouble("AMOUNT");
				String reason = rs.getString("REASON");
				int appBy = rs.getInt("APPROVED_BY");
				int denBy = rs.getInt("DENIED_BY");
				requests.add(new Request(reimId, empId, amount, reason, appBy, denBy));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Failed to retrieve the requests belonging to the specified employee");
		}
		return requests;
	}

	public Request getRequestById(int id) {
		String sql = "SELECT * FROM REIMBURSE_REQUEST WHERE REIMID = ?";
		Request reim = null;

		// Attempt to retrieve the specified Request from the table
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIMID");
				int empId = rs.getInt("EMPLOYEEID");
				double amount = rs.getDouble("AMOUNT");
				String reason = rs.getString("REASON");
				int appBy = rs.getInt("APPROVED_BY");
				int denBy = rs.getInt("DENIED_BY");
				reim = new Request(reimId, empId, amount, reason, appBy, denBy);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Failed to retrieve the request with the specified id");
		}
		return reim;
	}

	public Request getRequestByEmpId(int eId) {
		String sql = "SELECT * FROM REIMBURSE_REQUEST WHERE EMPLOYEEID = ?";
		Request reim = null;

		// Attempt to retrieve the specified Request from the table
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1,  eId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIMID");
				int empId = rs.getInt("EMPLOYEEID");
				double amount = rs.getDouble("AMOUNT");
				String reason = rs.getString("REASON");
				int appBy = rs.getInt("APPROVED_BY");
				int denBy = rs.getInt("DENIED_BY");
				reim = new Request(reimId, empId, amount, reason, appBy, denBy);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Failed to retrieve the employee's request");
		}
		return reim;
	}

	public int createRequest(Request r) {
		int reimCreated = 0;
		String sql = "INSERT INTO REIMBURSE_REQUEST VALUES (?,?,?,?,?,?)";
		
		// Attempt to insert the new Request
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, r.getId());
			ps.setInt(2,  r.getEmpId());
			ps.setDouble(3, r.getAmount());
			ps.setString(4, r.getReason());
			if(r.getApprovedBy() >= 20000) {
				ps.setInt(5, r.getApprovedBy());
			} else {
				ps.setNull(5, Types.NULL);
			}
			if(r.getDeniedBy() >= 20000) {
				ps.setInt(6, r.getDeniedBy());
			} else {
				ps.setNull(6, Types.NULL);
			}
			reimCreated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("Failed to create new request: " + r.toString());
		}
		return reimCreated;
	}

	public int deleteRequest(int id) {
		int rowsDel = 0;
		String sql = "DELETE FROM REIMBURSE_REQUEST WHERE REIMID = ?";
		
		// Attempt to delete the specified Employee
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1,  id);
			rowsDel = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to delete the request");
		}
		return rowsDel;
	}

	public int approveRequest(int id, int mId) {
		int reimUpdated = 0;
		String sql = "UPDATE REIMBURSE_REQUEST " + 
				"SET APPROVED_BY = ? " + 
				"WHERE REIMID = ?";
		
		// Attempt to update the value holding the id of the manager who has approved the request
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, mId);
			ps.setInt(2, id);
			reimUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to approve the specified request id: " + id + " manager id: " + mId);
		}
		return reimUpdated;
	}
	
	public int denyRequest(int id, int mId) {
		int reimUpdated = 0;
		String sql = "UPDATE REIMBURSE_REQUEST " + 
				"SET DENIED_BY = ? " + 
				"WHERE REIMID = ?";
		
		// Attempt to update the value holding the id of the manager who has approved the request
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, mId);
			ps.setInt(2, id);
			reimUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to deny the specified request id: " + id + " manager id: " + mId);
		}
		return reimUpdated;
	}

}
