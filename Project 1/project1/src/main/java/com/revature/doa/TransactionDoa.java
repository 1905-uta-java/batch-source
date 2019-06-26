package com.revature.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Transaction;
import com.revature.util.ConnectionDb;

/*
 *Accesses the Transaction table in the database 
 */


public class TransactionDoa {
	
	//gets all the transactions and thier information
	public List<Transaction> getTransactions(){
		List<Transaction> transactions = new ArrayList();
		String statement = "SELECT * FROM TRANSACTION_TBL";
		try(Connection conn = ConnectionDb.getConnection();
				PreparedStatement ps = conn.prepareStatement(statement);
				ResultSet rs = ps.executeQuery();){
			while(rs.next()) {
				int id =	 rs.getInt("TRANS_ID");	
				int amount = rs.getInt("TRANS_AMOUNT");
				int eid = 	 rs.getInt("EMPLOYEE_ID");
				int mid =	 rs.getInt("MANAGER_ID");
				String log = rs.getString("TRANS_LOG");
				
				Transaction t = new Transaction(id, amount, eid, mid, log);
				transactions.add(t);
			}
			return transactions;
		}
		catch(SQLException e) {
			
		}
		System.out.println("Oh no");
		return null;
	}
	
	public void createNewTransaction(Transaction t) throws SQLException {
		
		String statement = "INSERT INTO TRANSACTION_TBL VALUES(?,?,?,?,?)";
		
		try(Connection conn = ConnectionDb.getConnection();
				PreparedStatement ps = conn.prepareStatement(statement);){
			int i = 1;
			
			ps.setInt(i++, t.getEmployeeId());
			ps.setDouble(i++, t.getAmount());
			ps.setInt(i++, t.getEmployeeId());
			ps.setInt(i++, t.getManagerId());
			ps.setString(i++, t.getLog());
			ps.executeUpdate();
			System.out.println("called ps");
		}
		
		
	}
	
	public List<Transaction> getTransactionByEmployeeId(int i) {
		List<Transaction>transactions = new ArrayList<>();
		List<Transaction> trans = getTransactions();
		for(Transaction t : trans) {
			if(i == t.getEmployeeId()) {
				transactions.add(t);
			}
		}
		return transactions;
	}
	
	public List<Transaction> getTransactionByEmployeeId(String i) {
		if(Integer.parseInt(i) > 0) {
			int id = Integer.parseInt(i);
			if(id < 20000) {
				return getTransactionByEmployeeId(id);
			}
		}
		return null;
	}
	
	public int nextId() {
		List<Transaction> trans = getTransactions();
		int index = 0;
		for(Transaction t : trans) {
			if(t.getId() >= index) {
				index = t.getId() + 1;
			}
		}
		return index;
	}
	
	public List<Transaction> getTransactionsByManagerId(int manId){
		List<Transaction>transactions = new ArrayList<>();
		List<Transaction> trans = getTransactions();
		for(Transaction t : trans) {
			if(manId == t.getManagerId()) {
				transactions.add(t);
			}
		}
		return transactions;
	}
	
	public List<Transaction> getTransactionsByManagerId(String i) {
		if(Integer.parseInt(i) > 0) {
			int id = Integer.parseInt(i);
			if(id > 20000) {
				return getTransactionsByManagerId(id);
			}
		}
		return null;
	}
}
