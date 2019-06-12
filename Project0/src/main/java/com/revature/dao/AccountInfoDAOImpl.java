package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.AccountInfo;
import com.revature.util.ConnectionUtil;

public class AccountInfoDAOImpl implements AccountInfoDAO{

	@Override
	public AccountInfo pullUpAccount(int id) {
		String sql = "SELECT * FROM ACCOUNT_INFO WHERE A_ID = ?";
		AccountInfo acc= null;
		
		try(Connection conMan = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = conMan.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int aId = rs.getInt("A_ID");
				int accountBalance = rs.getInt("ACCOUNT_BALANCE");
				String billingAddress = rs.getString("BILLING_ADDRESS");
				String billingCity = rs.getString("BILLING_CITY");
				String billingState = rs.getString("BILLING_CITY");
				String billingCountry = rs.getString("BILLING_COUNTRY");
				int billingZip = rs.getInt("BILLING_ZIP_CODE");
				acc = new AccountInfo(aId, accountBalance, billingAddress, billingCity, billingState, billingCountry, billingZip);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return acc;
	}

	@Override
	public int currentBalance(int id) {
		String sql = "SELECT ACCOUNT_BALANCE FROM ACCOUNT_INFO WHERE A_ID = ?";
		int balance = 0;
		
		try (Connection conMan = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = conMan.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				balance = rs.getInt("ACCOUNT_BALANCE");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}

//added feature to change billing address otherwise it is defaulted as personal info address
	@Override
	public boolean newAddress(String street, String city, String state, String country, int zipCode, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deposit(int money, int id) {
		String sql = "UPDATE ACCOUNT_INFO SET ACCOUNT_BALANCE = ? WHERE A_ID = ?";
		int balance = 0 , deltaBalance = currentBalance(id) + money;
		
		try(Connection conMan = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = conMan.prepareStatement(sql)){
			ps.setInt(1, deltaBalance);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
		
			rs.close();
			balance = currentBalance(id);
		} catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
			balance = -1;
		}
		return balance;
	}

	@Override
	public int withdraw(int money, int id) {
		String sql = "UPDATE ACCOUNT_INFO SET ACCOUNT_BALANCE = ? WHERE A_ID = ?";
		int balance = 0 , deltaBalance = currentBalance(id) - money;
		
		//make sure to have checked deltaBalance - currentBalance
		try(Connection conMan = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = conMan.prepareStatement(sql)){
			ps.setInt(1, deltaBalance);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
	
			rs.close();
			balance = currentBalance(id);
		} catch(SQLException e) {
			System.out.println("Something went wrong...");
			e.printStackTrace();
			balance = -1;
		}
		return balance;
	}

}
