package com.revature.pZero.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pZero.model.BankAccount;
import com.revature.pZero.model.BankUser;
import com.revature.pZero.model.CheckingAccount;
import com.revature.pZero.model.SavingsAccount;
import com.revature.pZero.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class BankAccountsDAOImpl implements BankAccountsDAO {

	@Override
	public List<BankAccount> getAccounts(int user_Id) {
		
		//String for query
		String sql = "CALL GET_ALL_USER_BANK_ACCTS(?, ?)";
		List<BankAccount> ba = new ArrayList<>();
				
		try (Connection con = ConnectionUtil.getHardCodedConnection(); //try to establish a connection to db
				) {
			CallableStatement ps = con.prepareCall(sql);
			ps.setInt(1, user_Id);
			ps.registerOutParameter(2, OracleTypes.CURSOR);
			ps.executeQuery();
			ResultSet rs = (ResultSet) ps.getObject(2);
			
			while(rs.next()) { //get bank account info
					int bank_Id = rs.getInt("BANKID");
					int bankUserID = rs.getInt("USERID");
					double amount = rs.getDouble("AMOUNT");
					double interest_Rate = rs.getDouble("INTEREST_RATE");
					//System.out.println(interest_Rate);
					if(interest_Rate <= 0.0)
						ba.add(new CheckingAccount(bank_Id, bankUserID, amount));
					else
						ba.add(new SavingsAccount(bank_Id, bankUserID, amount, interest_Rate));
			}
			rs.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		
		return ba;
	}

	//@Override
	//public BankAccount getAccount(int account_id, String acct_Type) {
		
	//	return null;
	//}

	@Override
	public int createBankAccount(BankAccount b) {
		int bankAccountCreated = 0;
		String sql;
		boolean savings = false;
		if(b instanceof SavingsAccount) {
			sql = "INSERT INTO SAVING_ACCT VALUES (?, ?, ?, ?)";
			savings = true;
		}
		else
			sql = "INSERT INTO CHECKING_ACCT VALUES (?, ?, ?)";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, getNextBankId(b));
			ps.setInt(2, b.getUserId());
			ps.setDouble(3, b.getAmount());
			if(savings) {
				SavingsAccount s = (SavingsAccount) b;
				ps.setDouble(4, s.getInterestRate());
			}
			
			bankAccountCreated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankAccountCreated;
	}

	@Override
	public int updateBankAccount(BankAccount b) {
		int bankAccountUpdated = 0;
		String sql;
		boolean savings = false;
		
		if(b instanceof SavingsAccount) {
			sql = "UPDATE SAVING_ACCT "
					+ "SET USER_ID = ?, "
					+ "AMOUNT = ?, "
					+ "INTEREST_RATE = ? "
					+ "WHERE SAVING_ACCT.SAVING_ID = ?";
			savings = true;
		}
		else
			sql = "UPDATE CHECKING_ACCT "
					+ "SET USER_ID = ?, "
					+ "AMOUNT = ? "
					+ "WHERE CHECKING_ACCT.CHECKING_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)){
			
			
			if(savings) {
				SavingsAccount s = (SavingsAccount) b;
				
				ps.setInt(1, b.getUserId());
				ps.setDouble(2, b.getAmount());
				ps.setDouble(3, s.getInterestRate());
				ps.setDouble(4, b.getId());
			} else {
				ps.setInt(1, b.getUserId());
				ps.setDouble(2, b.getAmount());
				ps.setDouble(3, b.getId());
			}
			
			bankAccountUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankAccountUpdated;
	}

	@Override
	public int deleteBankAccount(BankAccount b) {
		int bankAccountDeleted = 0;
		String sql;
		boolean savings = false;
		if(b instanceof SavingsAccount) {
			sql = "DELETE FROM SAVING_ACCT WHERE SAVING_ACCT.SAVING_ID = ?";
			savings = true;
		}
		else
			sql = "DELETE FROM CHECKING_ACCT WHERE CHECKING_ACCT.CHECKING_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, b.getId());
			
			bankAccountDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankAccountDeleted;
	}
	
	public int getNextBankId(BankAccount b) {
		int index = 0;
		String sql;
		
		if(b instanceof SavingsAccount)
			sql = "SELECT MAX(SAVING_ACCT.SAVNG_ID) AS COUNT FROM SAVING_ACCT";
		else 
			sql = "SELECT MAX(CHECKING_ACCT.CHECKNG_ID) AS COUNT FROM CHECKING_ACCT";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareCall(sql)) {
			ResultSet rs = ps.executeQuery();
			
			index = rs.getInt("COUNT") + 1; //Get the current highest value in primary key and INCREMENT FOR NEXT PKEY
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return index; //returns the next value of primary key
	}

}
