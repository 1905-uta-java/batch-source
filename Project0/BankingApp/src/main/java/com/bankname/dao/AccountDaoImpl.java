package com.bankname.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankname.model.Account;
import com.bankname.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class AccountDaoImpl implements AccountDao{

	//Get all the accounts in the Account Table
	@Override
	public List<Account> getAccounts() {
		//Store the accounts into the array
		List<Account> accounts = new ArrayList<>();
		
		//SQL Statement to get all from Accounts
		String sql = "SELECT * FROM ACCOUNT";
		
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);){
			
			//Get the information from SQL and put into an Account Object
			while(rs.next()) {
				int acctNum = rs.getInt("ACCT_NUMBER");
				String acctType = rs.getString("TYPE");
				double acctBalance = rs.getDouble("BALANCE");
				int userID = rs.getInt("USER_ID");
				
				//Add the account to the list
				accounts.add(new Account(acctNum,acctType,acctBalance,userID));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return accounts;
	}

	//Get the Account information from database using the account number
	@Override
	public Account getAccountByAcctNumber(int acctNumber) {
		Account acct = null;
		
		//SQL statement to get the Account by the acctNumber
		String sql = "SELECT * FROM ACCOUNT WHERE ACCT_NUMBER = ?";
		
		//Try connecting to the database and Run SQL
				try(Connection con = ConnectionUtil.getConnection();
						PreparedStatement ps = con.prepareStatement(sql);){
					ps.setInt(1, acctNumber);
					ResultSet rs = ps.executeQuery();
					
					//Get the information from SQL and put into an Account Object
					while(rs.next()) {
						int acctNum = rs.getInt("ACCT_NUMBER");
						String acctType = rs.getString("TYPE");
						double acctBalance = rs.getDouble("BALANCE");
						int userID = rs.getInt("USER_ID");
						
						//Create the Account Object
						acct = new Account(acctNum,acctType,acctBalance,userID);
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
		
		
		return acct;
	}

	//Get the Account information from the database using the userID
	@Override
	public List<Account> getAccountsByUserID(int userID) {
		List<Account> accounts = new ArrayList<>();
		
		//SQL statement to get the Account by the userID
		String sql = "SELECT * FROM ACCOUNT WHERE USER_ID = ?";
		
		//Try connecting to the database and Run SQL
				try(Connection con = ConnectionUtil.getConnection();
						PreparedStatement ps = con.prepareStatement(sql);){
					ps.setInt(1, userID);
					ResultSet rs = ps.executeQuery();
					
					//Get the information from SQL and put into an Account Object
					while(rs.next()) {
						int acctNum = rs.getInt("ACCT_NUMBER");
						String acctType = rs.getString("TYPE");
						double acctBalance = rs.getDouble("BALANCE");
						int thisUserID = rs.getInt("USER_ID");
						
						//Create the Account Object
						accounts.add(new Account(acctNum,acctType,acctBalance,thisUserID));
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
		
		
		return accounts;
	}

	//Create an account in the table Account
	@Override
	public int createAccount(Account a) {
		int accountsCreated = 0;
		
		//SQL statement to add a new account
		String sql = "INSERT INTO ACCOUNT VALUES (?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, a.getAcctNumber());
			ps.setString(2, a.getAcctType());
			ps.setDouble(3, a.getBalance());
			ps.setInt(4, a.getUserID());
			
			accountsCreated = ps.executeUpdate();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return accountsCreated;
	}

	//Update an account in the Account Table
	@Override
	public int updateAccount(Account a) {
		int accountsUpdated = 0;
		
		//SQL statement to add a new account
				String sql = "UPDATE ACCOUNT "
						+ "SET TYPE = ? , "
						+ "BALANCE = ?, "
						+ "USER_ID = ? "
						+ "WHERE ACCT_NUMBER = ?";
				
				try(Connection con = ConnectionUtil.getConnection();
						PreparedStatement ps = con.prepareStatement(sql)){
					
					ps.setInt(4, a.getAcctNumber());
					ps.setString(1, a.getAcctType());
					ps.setDouble(2, a.getBalance());
					ps.setInt(3, a.getUserID());
					
					accountsUpdated = ps.executeUpdate();
				
				}catch(SQLException e){
					e.printStackTrace();
				}
		
		return accountsUpdated;
	}

	//Delete an account in the Account Table
	@Override
	public int deleteAccount(int acctNumber) {
		int rowsDeleted = 0;
		
		//SQL statement to Delete an account based on ACCT_NUMBER
		String sql = "DELETE FROM ACCOUNT WHERE ACCT_NUMBER = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, acctNumber);
			rowsDeleted = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		return rowsDeleted;
	}

	//Get the next available account number
	@Override
	public int getNextAccountNumber() {
		//SQL Call statement to call a stored procedure
		String sql = "{? = call GET_NEXT_ACCT_NUM}";
		
		//Hold the value given
		int maxAcctNum = 0;
		
		try(Connection con = ConnectionUtil.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				){
			
			//Get the result set
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			//Get the result as an integer
			while(rs.next()) {
				maxAcctNum = rs.getInt("MAX(ACCT_NUMBER)");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return maxAcctNum+1;
	}

}
