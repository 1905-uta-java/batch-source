package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{

	@Override
	public List<Account> getAccounts() {
		List<Account> accounts = new ArrayList<>();
		
		String sql = "SELECT * FROM ACCOUNTS";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {
			
			while (rs.next()) {
				Account a = new Account();
				
				int empId = rs.getInt("CUSTOMERID");
				a.setId(empId);
				
				int accountNum = rs.getInt("ACCOUNTNUM");
				a.setAccountNum(accountNum);
				
				String accountType = rs.getString("ACCOUNTTYPE");
				a.setAccountType(accountType);
				
				double accountBalance = rs.getDouble("ACCOUNTBALANCE");
				a.setAccountBalance(accountBalance);
				
				accounts.add(a);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	@Override
	public Account getAccountByNum(int id) {
		String sql = ("SELECT * FROM ACCOUNTS WHERE CUSTOMERID = ?");
		Customer c = new Customer();
		Account a = new Account();
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int custId = rs.getInt("CUSTOMERID");
				a.setId(custId);
				int accountNum = rs.getInt("ACCOUNTNUM");
				a.setAccountNum(accountNum);
				String accountType = rs.getString("ACCOUNTTYPE");
				a.getAccountType();
				double accountBal = rs.getDouble("ACCOUNTBALANCE");
				a.getAccountBalance();
				
				a = new Account(custId, accountNum, accountType, accountBal);
				
			}
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public double getBalance(int accountNum) {
		String sql = ("SELECT A.ACCOUNTBALANCE FROM ACCOUNTS A WHERE A.CUSTOMERID = ?");
		Account a = new Account();
		double balance = 0;
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, accountNum);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				double accountBal = rs.getDouble("ACCOUNTBALANCE");
				a.setAccountBalance(accountBal);
				
				balance = accountBal;
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}

	@Override
	public int deposit(double amount, int accountNum) {
		int updatedBalance = 0;
		String sql = "UPDATE ACCOUNTS SET ACCOUNTBALANCE = ACCOUNTBALANCE + ? WHERE ACCOUNTNUM = ?";
		
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
//			con.setAutoCommit(false);
			ps.setDouble(1, amount);
			ps.setInt(2, accountNum);
				
			System.out.println("You've deposited " + amount);
			
			System.out.println("Amount: " + amount + " AccountNum: " + accountNum);
			updatedBalance = ps.executeUpdate();
			System.out.println("completed interaction with db");
//			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updatedBalance;
	}

	@Override
	public int withdraw(Account a, double amount) {
		int balanceUpdated = 0;
		
		String sql = "UPDATE ACCOUNTS SET ACCOUNTBALANCE = ? WHERE ACCOUNTNUM = ?";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			double curBal = a.getAccountBalance();

			ps.setDouble(1, curBal - amount);
			ps.setInt(2, a.getAccountNum());
			
			if (curBal - amount < 0 ) {
				System.out.println("Can not withdraw more than the amount in account.");
				
			} else {

			System.out.println("Withdrawing...\n");
			ps.execute();
			System.out.println("You've withdrawn " + amount);
			System.out.println("Your new balance is " + (curBal - amount) + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balanceUpdated;
	}

	@Override
	public int insertAccount(Account a) {
		int accountsCreated = 0;
		
		String sql = "INSERT INTO ACCOUNTS VALUES (?,?,?,?)";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			
			ps.setInt(1, a.getId());
			ps.setInt(2, a.getAccountNum());
			ps.setString(3, a.getAccountType());
			ps.setDouble(4, a.getAccountBalance());
			
			
			accountsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountsCreated;
	}

	@Override
	public int deposit2(Account a, double amount) {
		int balanceUpdate = 0;
		
		String sql = "UPDATE ACCOUNTS SET ACCOUNTBALANCE = ? WHERE ACCOUNTNUM = ?";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			double curBal = a.getAccountBalance();

			ps.setDouble(1, curBal + amount);
			ps.setInt(2, a.getAccountNum());
			
			System.out.println("Depositing...\n");
			ps.executeUpdate();
			
			System.out.println("You've deposited " + amount);
			System.out.println("Your new balance is " + (curBal + amount) +"\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balanceUpdate;
	}

}
