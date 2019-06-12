package com.revature.accountdao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.accountmodel.Account;
import com.revature.accountutil.ConnectionUtil;

// Class to implement the AccountDao interface
public class AccountDaoImp implements AccountDao {

	// Get a list of the accounts in the table
	@Override
	public List<Account> getAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		String sql = "SELECT * FROM ACCOUNT_TABLE";
		
		// Attempt to retrieve the accounts from the table
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int accountId = rs.getInt("ACCOUNTID");
				int uId = rs.getInt("USERID");
				int pin = rs.getInt("PIN");
				double bal = rs.getDouble("BALANCE");
				accounts.add(new Account(accountId, uId, pin, bal));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	// Get an account from the table by the account id
	@Override
	public Account getAccountById(int id) {
		String sql = "SELECT * FROM ACCOUNT_TABLE WHERE ACCOUNTID = ?";
		Account a = null;
		
		// Attempt to retrieve the specified account from the table
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int accountId = rs.getInt("ACCOUNTID");
				int uId = rs.getInt("USERID");
				int pin = rs.getInt("PIN");
				double bal = rs.getDouble("BALANCE");
				a = new Account(accountId, uId, pin, bal);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	// Get an account from the table by the user id
	@Override
	public Account getAccountByUId(int usId) {
		String sql = "SELECT * FROM ACCOUNT_TABLE WHERE USERID = ?";
		Account a = null;
		
		// Attempt to retrieve the specified account from the table
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1,  usId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int accountId = rs.getInt("ACCOUNTID");
				int uId = rs.getInt("USERID");
				int pin = rs.getInt("PIN");
				double bal = rs.getDouble("BALANCE");
				a = new Account(accountId, uId, pin, bal);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	// Create an account and insert it into the table
	@Override
	public int createAccount(Account a) {
		int accountCreated = 0;
		String sql = "INSERT INTO ACCOUNT_TABLE VALUES (?,?,?,?)";
		
		// Attempt to insert the new account
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, a.getId());
			ps.setInt(2,  a.getuId());
			ps.setInt(3, a.getPin());
			ps.setDouble(4, a.getBalance());
			accountCreated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountCreated;
	}

	// Delete an account, specified by its id, from the table
	@Override
	public int deleteAccount(int id) {
		int rowsDel = 0;
		String sql = "DELETE FROM ACCOUNT_TABLE WHERE ACCOUNTID = ?";
		
		// Attempt to delete the specified account
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1,  id);
			rowsDel = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsDel;
	}
	
	// Use a callable statement to check balance
	@Override
	public double checkBalance(Account a) {
		String sql = "{CALL GET_BALANCE (?, ?)}";
		double bal = -1;
		
		// Attempt to call the prepared statement to get the balance
		try(Connection con = ConnectionUtil.getConnection();
				CallableStatement cs = con.prepareCall(sql);) {
			cs.setInt(1, a.getId());
			cs.registerOutParameter(2, java.sql.Types.DOUBLE);
			cs.executeQuery();
			bal = cs.getDouble(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bal;
	}

	// Deposit funds into the specified account
	@Override
	public int depositFunds(Account a, double funds) {
		int accountUpdated = 0;
		String sql = "UPDATE ACCOUNT_TABLE " + 
				"SET BALANCE = ? " + 
				"WHERE ACCOUNTID = ?";
		
		// Attempt to add funds to the specified account
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setDouble(1, (a.getBalance() + funds));
			ps.setInt(2, a.getId());
			accountUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountUpdated;
	}

	// Withdraw funds from the specified account
	@Override
	public int withdrawFunds(Account a, double funds) {
		int accountUpdated = 0;
		String sql = "UPDATE ACCOUNT_TABLE " +
				"SET BALANCE = ? " + 
				"WHERE ACCOUNTID = ?";
		
		// Attempt to remove funds from the specified account
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			// Only remove the funds if it will not overdraw the account
			if(a.getBalance() - funds >= 0.00) {
				ps.setDouble(1, (a.getBalance() - funds));
				ps.setInt(2, a.getId());
				accountUpdated = ps.executeUpdate();
			} else {
				System.out.println("There is not enough money in your account to withdraw $" + 
						String.format("%.2f", funds) + "\nYou currently have $" + 
						String.format("%.2f", a.getBalance()) + " in your account.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountUpdated;
	}

	// Change the pin of the specified account
	@Override
	public int changePin(Account a, int pin) {
		int accountUpdated = 0;
		String sql = "UPDATE ACCOUNT_TABLE " + 
				"SET PIN = ? " + 
				"WHERE ACCOUNTID = ?";
		
		// Attempt to add funds to the specified account
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setDouble(1, pin);
			ps.setInt(2, a.getId());
			accountUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountUpdated;
	}
	
}
