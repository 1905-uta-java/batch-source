package com.company.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.company.model.Reimbursement;
import com.company.util.ConnectionUtil;



public class ReimbursementDaoImpl implements ReimbursementDao{

	//Get all of the reimbursements in the table
	@Override
	public List<Reimbursement> getReimbursements() {
		//Store all the requests into the list 
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		//SQL statement to get all the requests from Reimbursement
		String sql = "SELECT * FROM REIMBURSEMENT";
		
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);){
					
			//Get the information from SQL and put into an Reimbursements Object
			while(rs.next()) {
				int reqId = rs.getInt("REQUEST_ID");
				int empId = rs.getInt("EMP_ID");
				String status = rs.getString("STATUS");
				double amount = rs.getDouble("AMOUNT");
				String reason = rs.getString("REASON");
				int managerId = rs.getInt("MANAGER_ID");
				String empNotes = rs.getString("EMP_NOTES");
				String managerNotes = rs.getString("MANAGER_NOTES");
				Date date = rs.getDate("SUBMIT_DATE");
						
				//Add the request to the list
				reimbursements.add(new Reimbursement(reqId,empId,status,amount,reason,managerId,empNotes,managerNotes,date));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
				
				
		return reimbursements;
	}

	//Get a reimbursement by its id from the table
	@Override
	public Reimbursement getReimbursementById(int id) {
		//Store all the requests into the list 
		Reimbursement reimbursement = new Reimbursement();
		
		//SQL statement to get all the requests from Reimbursement where REQUEST_ID = id
		String sql = "SELECT * FROM REIMBURSEMENT WHERE REQUEST_ID = ?";
		
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();		
			
			//Get the information from SQL and put into an Reimbursement Object
			while(rs.next()) {
				int reqId = rs.getInt("REQUEST_ID");
				int empId = rs.getInt("EMP_ID");
				String status = rs.getString("STATUS");
				double amount = rs.getDouble("AMOUNT");
				String reason = rs.getString("REASON");
				int managerId = rs.getInt("MANAGER_ID");
				String empNotes = rs.getString("EMP_NOTES");
				String managerNotes = rs.getString("MANAGER_NOTES");
				Date date = rs.getDate("SUBMIT_DATE");
						
				//Add the account to the list
				reimbursement = new Reimbursement(reqId,empId,status,amount,reason,managerId,empNotes,managerNotes, date);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
				
		return reimbursement;		
	}

	//Get all the reimbursements for an employee by their id
	@Override
	public List<Reimbursement> getAllReimbursementsByEmployee(int empId) {
		//Store all the requests into the list 
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		//SQL statement to get all the requests from Reimbursement with EMP_ID = empId
		String sql = "SELECT * FROM REIMBURSEMENT WHERE EMP_ID = ?";
		
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();		
			
			//Get the information from SQL and put into an Reimbursement Object
			while(rs.next()) {
				int reqId = rs.getInt("REQUEST_ID");
				int empID = rs.getInt("EMP_ID");
				String status = rs.getString("STATUS");
				double amount = rs.getDouble("AMOUNT");
				String reason = rs.getString("REASON");
				int managerId = rs.getInt("MANAGER_ID");
				String empNotes = rs.getString("EMP_NOTES");
				String managerNotes = rs.getString("MANAGER_NOTES");
				Date date = rs.getDate("SUBMIT_DATE");
						
				//Add the account to the list
				reimbursements.add(new Reimbursement(reqId,empID,status,amount,reason,managerId,empNotes,managerNotes, date));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
				
		return reimbursements;	
	}

	//Get all the reimbursements of a manager
	@Override
	public List<Reimbursement> getAllReimbursementsByManager(int mangId) {
		//Store all the requests into the list 
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		//SQL statement to get all the requests from Reimbursement with MANAGER_ID = mangId
		String sql = "SELECT * FROM REIMBURSEMENT WHERE MANAGER_ID = ?";
		
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setInt(1, mangId);
			ResultSet rs = ps.executeQuery();		
			
			//Get the information from SQL and put into an Reimbursement Object
			while(rs.next()) {
				int reqId = rs.getInt("REQUEST_ID");
				int empId = rs.getInt("EMP_ID");
				String status = rs.getString("STATUS");
				double amount = rs.getDouble("AMOUNT");
				String reason = rs.getString("REASON");
				int managerId = rs.getInt("MANAGER_ID");
				String empNotes = rs.getString("EMP_NOTES");
				String managerNotes = rs.getString("MANAGER_NOTES");
				Date date = rs.getDate("SUBMIT_DATE");
						
				//Add the account to the list
				reimbursements.add(new Reimbursement(reqId,empId,status,amount,reason,managerId,empNotes,managerNotes, date));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
				
		return reimbursements;	
	}

	
	//Create a new reimbursement request 
	@Override
	public int createReimbursement(Reimbursement r) {
		int reimbursementCreated = 0;
		
		//SQL statement to add a new account
		String sql = "INSERT INTO REIMBURSEMENT VALUES (?,?,?,?,?,?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, r.getReqId());
			ps.setInt(2, r.getEmpId());
			ps.setString(3, r.getStatus());
			ps.setDouble(4, r.getAmount());
			ps.setString(5, r.getReason());
			ps.setInt(7, r.getManagerId());
			ps.setString(6, r.getEmpNotes());
			ps.setString(8, r.getManagerNotes());
			ps.setDate(9, r.getDate());
			
			reimbursementCreated = ps.executeUpdate();
		
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return reimbursementCreated;
	}

	//Update an existing Reimbursement
	@Override
	public int updateReimbursement(Reimbursement r) {
		int reimbursementUpdated = 0;
		
		//SQL statement to update a request
		String sql = "UPDATE REIMBURSEMENT "
						+ "SET EMP_ID = ?, "
						+ "STATUS = ?, "
						+ "AMOUNT = ?, "
						+ "REASON = ?, "
						+ "MANAGER_ID = ?," 
						+ "EMP_NOTES = ?, "
						+ "MANAGER_NOTES = ?,"
						+ "SUBMIT_DATE = ?"
						+ "WHERE REQUEST_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(9, r.getReqId());
			ps.setInt(1, r.getEmpId());
			ps.setString(2, r.getStatus());
			ps.setDouble(3, r.getAmount());
			ps.setString(4, r.getReason());
			ps.setInt(5, r.getManagerId());
			ps.setString(6, r.getEmpNotes());
			ps.setString(7, r.getManagerNotes());
			ps.setDate(8, r.getDate());
			
			reimbursementUpdated = ps.executeUpdate();
		
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return reimbursementUpdated;
	}

	//Delete an existing request
	@Override
	public int deleteReimbursement(int id) {
		int rowsDeleted = 0;
		
		//SQL statement to Delete an reimbursement based on id
		String sql = "DELETE FROM REIMBUSEMENT WHERE REQUEST_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		return rowsDeleted;
	}

	//Get next available reimbursement ID
	@Override
	public int getNextReimbursementID() {
		List<Reimbursement> requests = getReimbursements();
		Collections.sort(requests,new Comparator<Reimbursement>() {

			public int compare(Reimbursement e1, Reimbursement e2) {
			    return Integer.compare(e1.getReqId(), e2.getReqId());
			}

		});
		int newId = requests.get(requests.size()-1).getReqId();
		return newId;
		
	}
	
}
