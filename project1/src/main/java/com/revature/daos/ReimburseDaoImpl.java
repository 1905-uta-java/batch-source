package com.revature.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.Reimburse;
import com.revature.util.ConnectionUtil;

public class ReimburseDaoImpl implements ReimburseDao{
	ArrayList<Reimburse> remReq = new ArrayList<>();
	private SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-YYYY");
	
	@Override
	public ArrayList<Reimburse> getAllReimburseReq() {
		String sql = "SELECT * FROM REIMBURSE";
		String fulfillDate = "";
		String issueDate = "";
		
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			while(rs.next()) {
				int remId = rs.getInt("REM_ID");
				String desc = rs.getString("DESCRIPTION");
				double amount = rs.getDouble("AMOUNT");
				Date iDate = rs.getDate("ISSUE_DATE");
				Date fDate = rs.getDate("FULFILL_DATE");
				String status = rs.getString("status");
				int manId = rs.getInt("MAN_ID");
				int empId = rs.getInt("EMP_ID");
				
				if(fDate != null)
					fulfillDate = simpleFormat.format(fDate);
				if(iDate != null)
					issueDate = simpleFormat.format(iDate); 
				
				remReq.add(new Reimburse(remId, desc, amount, issueDate, fulfillDate, status, manId, empId));
				
			}
			
		} catch (SQLException e) {
			return null;
		}
		
		return remReq;
	}

	@Override
	public ArrayList<Reimburse> getReimburseForUser(int id) {
		String sql= "SELECT * FROM REIMBURSE WHERE EMP_ID = ?";
		ArrayList<Reimburse> r = new ArrayList<>();
		String fulfillDate = null;

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int remId = rs.getInt("REM_ID");
				String desc = rs.getString("DESCRIPTION");
				double amount = rs.getDouble("AMOUNT");
				Date iDate = rs.getDate("ISSUE_DATE");
				Date fDate = rs.getDate("FULFILL_DATE");
				String status = rs.getString("status");
				int manId = rs.getInt("MAN_ID");
				int empId = rs.getInt("EMP_ID");
				
				if(fDate != null)
					fulfillDate = simpleFormat.format(fDate);
				
				String issueDate = simpleFormat.format(iDate); 
				
				r.add(new Reimburse(remId, desc, amount, issueDate, fulfillDate, status, manId, empId));

			}
			
		} catch (SQLException e) {
			return null;
		}
		
		return r;
	}

	@Override
	public List<Reimburse> getAllWithStatus(String statusIn) {
		List<Reimburse> empReimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSE WHERE STATUS = ?";

		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, statusIn);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rId = rs.getInt("REM_ID");
				String desc = rs.getString("DESCRIPTION");
				double amount = rs.getDouble("AMOUNT");
				Date iDate = rs.getDate("ISSUE_DATE");
				Date fDate = rs.getDate("FULFILL_DATE");
				String status = rs.getString("STATUS");
				int manId = rs.getInt("MAN_ID");
				int empId = rs.getInt("EMP_ID");
				
				String fulfillDate = simpleFormat.format(fDate);
				String issueDate = simpleFormat.format(iDate);
				
				empReimbursements.add(new Reimburse(rId, desc, amount, issueDate, fulfillDate, status, manId, empId));	
			}
		} catch (SQLException e) {
			return null;
		}
		
		return empReimbursements;
	}

	@Override
	public List<Reimburse> getWithStatus(String statusIn, int id) {
		List<Reimburse> empReimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSE WHERE STATUS = ? AND EMP_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, statusIn);
			ps.setInt(2, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rId = rs.getInt("REM_ID");
				String desc = rs.getString("DESCRIPTION");
				double amount = rs.getDouble("AMOUNT");
				Date iDate = rs.getDate("ISSUE_DATE");
				Date fDate = rs.getDate("FULFILL_DATE");
				String status = rs.getString("STATUS");
				int manId = rs.getInt("MAN_ID");
				int empId = rs.getInt("EMP_ID");
				
				String fulfillDate = simpleFormat.format(fDate);
				String issueDate = simpleFormat.format(iDate);
				
				empReimbursements.add(new Reimburse(rId, desc, amount, issueDate, fulfillDate, status, manId, empId));	
			}
			
			
		} catch (SQLException e) {
			return null;
		}
		
		return empReimbursements;
	}

	
	
	@Override
	public int newReimburse(Reimburse r) {
		Date date = new Date();
		
		
		String sql = "INSERT INTO REIMBURSE VALUES (?,?,?,?,?,?,?,?)";
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, r.getRem_id());
			ps.setString(2, r.getDesc());
			ps.setDouble(3, r.getAmount());
			ps.setString(4, r.getIssueDate());
			ps.setString(5, simpleFormat.format(date));//r.getFulfillDate());
			ps.setString(6, r.getStatus());
			ps.setInt(7, r.getManId());
			ps.setInt(8, r.getEmpId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			return e.getErrorCode();
		}
		return 0;
	}

	
	@Override
	public int delReimburse(int rId) {
		String sql = "{call DEL_REM(?)}";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall(sql)){
			cs.setInt(1, rId);
			
			cs.execute();
			cs.close();
		} catch(SQLException e) {
			return e.getErrorCode();
		}
		
		return 0;
	}
	
	@Override
	public int newRemId() {
		String sql = "SELECT MAX(REM_ID) AS REM_ID FROM REIMBURSE";
		int remId = 0;
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			while(rs.next()) {
				remId = rs.getInt("REM_ID");
			}
		
		} catch (SQLException e) {
			System.out.println("ERROR: " + e.getErrorCode());			
		}
		return remId;
	}
	
	@Override
	public int updateReimburse(Reimburse r) {
		String sql = "{call UPD_REM(?,?,?,?,?)}";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, r.getRem_id());
			ps.setString(2, r.getDesc());
			ps.setDouble(3, r.getAmount());
			ps.setString(4, r.getFulfillDate());
			ps.setString(5, r.getStatus());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DB ERROR CODE: " + e.getErrorCode() );
		}
		
		return 0;
	}

	@Override
	public ArrayList<Reimburse> getAllWithManId(int id) {
		String sql= "SELECT * FROM REIMBURSE WHERE MAN_ID = ?";
		ArrayList<Reimburse> r = new ArrayList<>();
		String fulfillDate = null;

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int remId = rs.getInt("REM_ID");
				String desc = rs.getString("DESCRIPTION");
				double amount = rs.getDouble("AMOUNT");
				Date iDate = rs.getDate("ISSUE_DATE");
				Date fDate = rs.getDate("FULFILL_DATE");
				String status = rs.getString("status");
				int manId = rs.getInt("MAN_ID");
				int empId = rs.getInt("EMP_ID");
				
				if(fDate != null)
					fulfillDate = simpleFormat.format(fDate);
				
				String issueDate = simpleFormat.format(iDate); 
				
				r.add(new Reimburse(remId, desc, amount, issueDate, fulfillDate, status, manId, empId));

			}
			
		} catch (SQLException e) {
			System.out.println("DB ERROR CODE (getAllWithManId): " + e.getErrorCode() );
			return null;
		}
		
		return r;
	}
	
}
