package com.revature.BankingApp.doa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;
import com.revature.BankingApp.util.ConnectionUtil;

public class AccountDoaImpl implements AccountDoa {

	public List<Account> getAccount() {
		List<Account>accounts = new ArrayList();
		
		String sql = "SELECT * FROM ACCOUNT";
		
		try(Connection c = ConnectionUtil.getHardCodedConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);
				){
			while(rs.next()) {
				int accNum = rs.getInt("ACCOUNT_NUMBER");
				double accBal = rs.getDouble("BALANCE");
				int empId = rs.getInt("EMPLOYEE_ID");
				int custId = rs.getInt("CUSTOMER_ID");
				String accType = rs.getString("ACCOUNT_TYPE");
				double intRate = rs.getDouble("INTEREST_RATE");
				String oDate = rs.getString("DATE_OPEN");
				String cDate = rs.getString("DATE_CLOSE");
				Account temp = new Account(accNum, custId, empId, accType,
						accBal, intRate, oDate,cDate);
						accounts.add(temp);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public Account getAccountById(int d) {
		List<Account>temp = getAccount();
		return temp.get(d);
	}

	//need to implement. Needs a customer object. Randomly assign employee;
	public void createAccount(Customer c, double balance, String accType) {
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Random rand = new Random();
		List<Account> accounts = getAccount();
		int high = 0;
		
		String dateOpen = dateFormat.format(date);
		for(Account a: accounts) {
			if(a.getAccountNumber() >= high) {
				high = a.getAccountNumber() + 1;
			}
		}
		
		
		int pk = high;
		int ck = c.getCustomerId();
		int ek =  rand.nextInt((10 - 5) + 1) + 5;
		
		//pk, cid, empid, acctType, balance, intRate, date open, date close
		String sql = "INSERT INTO ACCOUNT VALUES( ?, ?, 8, ?, ?, ?, ?, NULL )";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement ps = con.prepareCall(sql);
				){
			int i = 0;
			ps.setInt(++i, pk);
			ps.setInt(++i, ck);
			ps.setString(++i, accType);
			ps.setDouble(++i, balance);
			ps.setDouble(++i, .97);
			ps.setString(++i, dateOpen);
			ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getSQLState());
		}
		
		
		
	}
	
	//implement switch asking what you want to update. loop until they are done
	public int updateAccount(Account d) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void updateAccount(Account a, double d) {
		
		String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCOUNT_NUMBER = ?";
		double currBalance = a.getBalance();
		System.out.println(a.getAccountNumber());
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql);)	{
			
			ps.setDouble(1, currBalance + d);
			ps.setInt(2,  a.getAccountNumber());
			ps.execute();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//make sure they want to do this. create  a new method that just adds a date closed
	public int deleteAccount(Account d) {
		
		String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_ID = ?";
		
		try(Connection c = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = c.prepareStatement(sql);){
			ps.setInt(1,d.getAccountNumber());
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	public List<Account> getAccountByCustomerId(int cId) {
		List<Account> accounts = getAccount();
		List<Account> temp = new ArrayList();
		for(Account a : accounts) {
			if(a.getCustomerId() == cId) {
				temp.add(a);
			}
			
		}
		if(temp.size() >= 0)
			return temp;
		
		return null;
	}

}
