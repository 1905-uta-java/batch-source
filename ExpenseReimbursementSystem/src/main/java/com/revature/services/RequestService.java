package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.utils.ConnectionUtil;

public class RequestService {

	public List<Request> getAllRequests() {
		
		List<Request> requests = new ArrayList<>();
		
		String sql = "SELECT * FROM REQUEST";
		
		try {
			Connection con = ConnectionUtil.getHardCodedConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next() ) {
				
				Request r = new Request();
				
				int reqID = rs.getInt("REQUESTID_");
				r.setReqID(reqID);
				
				int empId = rs.getInt("EMPID_");
				r.setEmpId(empId);
				
				double amount = rs.getInt("AMOUNT_");
				r.setAmount(amount);
				
				String descript = rs.getString("DESCRIPTION_");
				r.setDescription(descript);
				
				String status = rs.getString("REQSTATUS_");
				r.setStatus(status);
				
				String resolvedBy = rs.getString("RESOLVEDBY_");
				r.setResolvedBy(resolvedBy);
				
				requests.add(r);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return requests;
	}
	
	public List<Request> getApproved() {
		
		List<Request> requests = new ArrayList<>();
		
		String sql = "SELECT * FROM REQUEST WHERE REQSTATUS_ = 'APPROVED'";
		
		try {
			Connection con = ConnectionUtil.getHardCodedConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next() ) {
				
				Request r = new Request();
				
				int reqID = rs.getInt("REQUESTID_");
				r.setReqID(reqID);
				
				int empId = rs.getInt("EMPID_");
				r.setEmpId(empId);
				
				double amount = rs.getInt("AMOUNT_");
				r.setAmount(amount);
				
				String descript = rs.getString("DESCRIPTION_");
				r.setDescription(descript);
				
				String status = rs.getString("REQSTATUS_");
				r.setStatus(status);
				
				String resolvedBy = rs.getString("RESOLVEDBY_");
				r.setResolvedBy(resolvedBy);
				
				requests.add(r);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return requests;
	}

	public Request getRequestById(int id) {
		
		String sql = "SELECT * FROM REQUEST WHERE EMPID_ = ?";
		Request r = new Request();
		
		try {
			Connection con = ConnectionUtil.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				
				int reqID = rs.getInt("REQUESTID_");
				r.setReqID(reqID);
				
				int employeeId =rs.getInt("EMPID_");
				r.setEmpId(employeeId);
				
				double amount = rs.getDouble("AMOUNT_");
				r.setAmount(amount);
				
				String descr = rs.getString("DESCRIPTION_");
				r.setDescription(descr);
				
				String status = rs.getString("REQSTATUS_");
				r.setStatus(status);
				
				String resBy = rs.getString("RESOLVEDBY_");
				r.setResolvedBy(resBy);	
			}
			rs.close();
			
		} catch (SQLException m) {
			m.printStackTrace();
		}
		
		return r;
	}

	public void createRequest(Request r) {
		
		int createRequest = 0;
		String sql = "INSERT INTO REQUEST (REQUESTID_, EMPID_, AMOUNT_, DESCRIPTION_, REQSTATUS_, RESOLVEDBY_) "
				+ "VALUES(seq_req.nextval, ?, ?, ?, ?, ?)";
				
		try{
			
			Connection con = ConnectionUtil.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, r.getEmpId());
			ps.setDouble(2, r.getAmount());
			ps.setString(3, r.getDescription());
			ps.setString(4, r.getStatus());
			ps.setString(5, r.getResolvedBy());
	
			createRequest = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		//return ;
		
	}

	
	public void updateRequestStatus(Request r) {
		
		int updateRequest = 0;
		String sql = "UPDATE REQUEST "
				+ "SET REQSTATUS_= ?, RESOLVEDBY_ = ? "
				+ "WHERE EMPID_ = ?";
		
		try {
			Connection con = ConnectionUtil.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, r.getStatus());
			ps.setString(2, r.getResolvedBy());
			ps.setInt(3,  r.getEmpId());
			
			updateRequest = ps.executeUpdate();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
	
