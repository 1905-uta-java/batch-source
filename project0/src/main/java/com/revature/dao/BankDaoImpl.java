package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.models.BankAccount;
import com.revature.util.ConnectionUtil;

public class BankDaoImpl implements BankDao{
	User a = new User();
	
	/*
	 * Returns all bank accounts in DB
	 * */
	@Override
	public List<BankAccount> getBankAccounts() {
		List<BankAccount> bankAccounts = new ArrayList<>();
		
		String sql = "SELECT * FROM BANK_ACC";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				BankAccount ba = new BankAccount();
				
				//ACC_ID
				int id = rs.getInt("ACC_NUM");
				ba.setId(id);
				//TYPE
				String type = rs.getString("TYPE");
				ba.setType(type);
				//USERNAME
				String username = rs.getString("USERNAME");
				ba.setUsername(username);
				//CURRENT_BALANCE
				double currBalance = rs.getDouble("CURRENT_BALANCE");
				ba.setCurrBalance(currBalance);
				//USER_ACC_ID
				int userAccId = rs.getInt("USER_ACC_ID");
				ba.setUsrAccId(userAccId);
				
				bankAccounts.add(ba);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankAccounts;
	}


	/*
	 * Here, we create a bank account list of all bank account pertaining to the user selected
	 * */
	public List<BankAccount> getAllBankAccounts(User a) {
		List<BankAccount> bankAccList = new ArrayList<>();
		String sql = "SELECT * FROM BANK_ACC WHERE USER_ACC_ID = ?";
		//String outAcc = "";
		int accNum = 0;
		String type = "";
		double currBalance = 0.00;
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, a.getId());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				accNum = rs.getInt("ACC_NUM");
				type = rs.getString("TYPE");
				currBalance = rs.getDouble("CURRENT_BALANCE");
				
				bankAccList.add(new BankAccount(accNum, type, a.getUsername(), currBalance, a.getId(),a));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankAccList;
	}
	
	/*
	 * Creates Bank account in DB
	 * */
	@Override
	public int createBankAccount(BankAccount ba) {
		String sql = "INSERT INTO BANK_ACC VALUES (?,?,?,?,?)";
		int accountsCreated = 0;
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, ba.getId());
			ps.setString(2, ba.getType());
			ps.setString(3, ba.getUsername());
			ps.setDouble(4, ba.getCurrBalance());
			ps.setInt(5, ba.getUsrAccId());
			
			accountsCreated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Bank account created successfully!\n" + ba.getCurrBalance() + " added to a new " + ba.getType() + " account!");
		return accountsCreated;
	}
	
	/*
	 * Gets a new account number (iterates from MAX)
	 * */
	@Override
	public int getNewAccNum() {
		int newAccNum = 0;
		String sql = "SELECT MAX(ACC_NUM) AS ID FROM BANK_ACC";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();){
				ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				newAccNum = rs.getInt("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ++newAccNum;
	}
	
	/*
	 * This will update the account balance
	 * */
	@Override
	public void updateBankAccount(BankAccount d) {
		String sql = "{call UPD_BANK_ACC(?,?,?)}";
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall(sql)){
			
			cs.setDouble(1, d.getCurrBalance());
			cs.setInt(2, d.getId());
			cs.setInt(3, d.getUsrAccId());
			
			cs.execute();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Bank account updated!");
	}

	
	/*
	 * BE CAREFUL, this will remove bank accounts tied to Account stuff
	 * */
	@Override
	public void deleteBankAccount(int bankId, User a) {
		System.out.println("Deleting BANK_ID: " + bankId + " for account with ID: " + a.getId());
		String sql = "{call DEL_BANK_ACC(?,?)}";
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall(sql)){
			
			cs.setInt(1, bankId);
			cs.setInt(2, a.getId());
			cs.execute();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Bank account deleted!");
	}

}
