package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO{
	


	@Override
	public int getAmount(int reqId) {
		int amount = 0;
		String sql = "SELECT AMOUNT FROM REIMBURSEMENT WHERE REQ_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, reqId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				amount = rs.getInt("AMOUNT");
			}
			
			rs.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error while grabbing amount");
			return 0;
		}
		
		return amount;
	}

	@Override
	public Reimbursement getReReq(int rereqId) {
		Reimbursement request = null;
		String sql = "SELECT * FROM REIMBURSEMENT WHERE REQ_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, rereqId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int reqId = rs.getInt("REQ_ID");
				int empId = rs.getInt("EMP_ID");
				int amount = rs.getInt("AMOUNT");
				int status = rs.getInt("STATUS");
				int resolvedBy = rs.getInt("RESOLVEDBY");
				String comment = rs.getString("COMMENTS");
				
				request = new Reimbursement(reqId, empId, amount, status, resolvedBy, comment);
			}
			
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting request");
		}
		
		return request;
	}

	@Override
	public List<Reimbursement> getAllReimbursements(int empId) {
		List<Reimbursement> empRequests = new ArrayList<>();

		String sql = "SELECT * FROM REIMBURSEMENT WHERE EMP_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int reqId = rs.getInt("REQ_ID");
				int eId = rs.getInt("EMP_ID");
				int amount = rs.getInt("AMOUNT");
				int status = rs.getInt("STATUS");
				int resolvedBy = rs.getInt("RESOLVEDBY");
				String comment = rs.getString("COMMENTS");
				
				Reimbursement request = new Reimbursement(reqId, eId, amount, status, resolvedBy, comment);
				empRequests.add(request);
			}
			
			rs.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting employee's requests");
		}
		
		
		return empRequests;
	}

	@Override
	public int setStatus(int status, int reqId) {
		String sql = "UPDATE REIMBURSEMENT SET STATUS = ? WHERE REQ_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, status);
			ps.setInt(2, reqId);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error updating status in request");
			return 0;
		}
		return 1;
	}

	@Override
	public int createReimbursement(int reqId, int empId, int amount, String comments) {
		String sql = "INSERT INTO REIMBURSEMENT(REQ_ID, EMP_ID, AMOUNT, STATUS, COMMENTS) VALUES(?, ?, ?, ?, ?)";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, reqId);
			ps.setInt(2, empId);
			ps.setInt(3, amount);
			ps.setInt(4, 0);
			ps.setString(5, comments);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error creating reimbursement");
			return 0;
		}
		return 1;
	}

	@Override
	public int setResolvedBy(int managerId, int reqId) {
		String sql = "UPDATE REIMBURSEMENT SET RESOLVEDBY=? WHERE REQ_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection(); 
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, managerId);
			ps.setInt(2, reqId);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error updating resolvedby in request");
			return 0;
		}
		return 1;
	}

	@Override
	public List<Reimbursement> getAll() {
		List<Reimbursement> allRequests = new ArrayList<>();

		String sql = "SELECT * FROM REIMBURSEMENT";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int reqId = rs.getInt("REQ_ID");
				int eId = rs.getInt("EMP_ID");
				int amount = rs.getInt("AMOUNT");
				int status = rs.getInt("STATUS");
				int resolvedBy = rs.getInt("RESOLVEDBY");
				String comment = rs.getString("COMMENTS");
				
				Reimbursement request = new Reimbursement(reqId, eId, amount, status, resolvedBy, comment);
				allRequests.add(request);
				
			}
			
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting all requests");
		}
		return allRequests;
	}

}
