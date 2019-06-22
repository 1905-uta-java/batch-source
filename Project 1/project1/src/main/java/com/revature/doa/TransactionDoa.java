package com.revature.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Transaction;

import util.ConnectionDb;

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
	
	public Transaction getTransactionById(int i) {
		List<Transaction>transactions = getTransactions();
		for(Transaction t : transactions) {
			if(i == t.getId()) {
				return t;
			}
		}
		return null;
	}
}
