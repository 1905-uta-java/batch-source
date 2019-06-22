package com.revature.project0.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.data.*;
import com.revature.project0.util.*;

public class DatabaseManager {
	
	/*
	 * logs the user in if the username corresponds to an existing user and the password matches
	 */
	public BankUser login(String username, String password) {
		
		BankUser user = null;
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM BANK_USER WHERE USERNAME = ?");
			
			pStatement.setString(1,  username);
			
			ResultSet result = pStatement.executeQuery();
			
			if(!result.next())
				return null;
			
			PasswordResult storedPass = new PasswordResult(result.getBytes("PASS_HASH"), result.getBytes("PASS_SALT"));
			
			PasswordResult enteredPass = PasswordUtil.hashPassword(password, result.getBytes("PASS_SALT"));
			
			if(!enteredPass.equals(storedPass))
				return null;
			
			user = new BankUser(username, result.getString("EMAIL"), result.getBytes("PASS_HASH"), result.getBytes("PASS_SALT"));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}
	
	public List<BankAccount> pullUsersAccountData(BankUser user) {
		
		List<BankAccount> usersAccounts = new ArrayList<BankAccount>();
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT A.ACCOUNT_ID, A.CURRENT_BAL FROM BANK_ACCOUNT A JOIN USER_ACCESS UA ON A.ACCOUNT_ID = UA.ACCOUNT_ID WHERE USERNAME = ?");
			
			pStatement.setString(1,  user.getUsername());
			
			ResultSet result = pStatement.executeQuery();
			
			while(result.next()) {
				
				usersAccounts.add(new BankAccount(result.getInt(1), result.getDouble(2)));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return usersAccounts;
	}
	
	public List<Transaction> pullAccountsTransactions(BankAccount account) {
		
		List<Transaction> accountsTransactions = new ArrayList<Transaction>();
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement(
					"SELECT T.TRANSACTION_ID, T.TRANSACTION_TYPE, T.AMOUNT, T.FROM_ACCOUNT, T.TO_ACCOUNT" + 
					"    FROM TRANSACTION T" + 
					"    JOIN BANK_ACCOUNT A" + 
					"    ON A.ACCOUNT_ID = T.FROM_ACCOUNT OR A.ACCOUNT_ID = T.TO_ACCOUNT" + 
					"    WHERE A.ACCOUNT_ID = ?" + 
					"    ORDER BY T.TRANSACTION_ID ASC");
			
			pStatement.setInt(1, account.getAccountID());
			
			ResultSet result = pStatement.executeQuery();
			
			while(result.next()) {
				
				accountsTransactions.add(new Transaction(result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4), result.getInt(5)));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return accountsTransactions;
	}
	
	public void updateAccountBalanceOnDatabase(BankAccount account) {
		
		if(account == null)
			return;
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			Statement statement = connection.createStatement();
			
			// I have this using a regular statement here because it was specified that we would need
			// to use it at some point in the project, and there is nowhere that using a statement is
			// particularly worth-while. Here, at least, the values being inserted are numerical types, not strings
			statement.executeUpdate("UPDATE BANK_ACCOUNT SET CURRENT_BAL = " + account.getCurrentBalance() + " WHERE ACCOUNT_ID = " + account.getAccountID());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/*
	 * This method adds a new transaction to the database.
	 * This is handled server-size to ensure that the transaction_id is unique
	 */
	public void addTransactionToDatabase(Transaction transaction) {
		
		if(transaction == null)
			return;
		
		// in this case a non-zero id means it's already been added to the database
		// and recieved a unique id
		if(transaction.getTransactionID() != 0)
			return;
		
		try {
			Connection connection = ConnectionUtil.getConnection();
			
			CallableStatement cStatement = connection.prepareCall("{call ADD_TRANSACTION(?,?,?,?,?)}");
			
			cStatement.setString(1,  transaction.getTransactionType());
			cStatement.setDouble(2,  transaction.getAmount());
			cStatement.setInt(3, transaction.getFromAccountID());
			cStatement.setInt(4,  transaction.getToAccountID());
			
			cStatement.registerOutParameter(5, Types.INTEGER);
			
			cStatement.executeUpdate();
			
			transaction.setTransactionID(cStatement.getInt(5));
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	/*
	 * Uses a stored procedure to delete an account and remove all entries from the USER_ACCESS table relating
	 * to the account
	 */
	public void removeAccountFromDatabase(BankAccount account) {
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			CallableStatement cStatement = connection.prepareCall("{call DELETE_ACCOUNT(?)}");
			
			cStatement.setInt(1,  account.getAccountID());
			
			cStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void addAccountToDatabase(BankAccount account, BankUser user) {
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			CallableStatement cStatement = connection.prepareCall("{call CREATE_NEW_ACCOUNT_FOR_USER(?,?)}");
			
			cStatement.setString(1, user.getUsername());
			
			cStatement.registerOutParameter(2, Types.INTEGER);
			
			cStatement.executeUpdate();
			
			account.setAccountID(cStatement.getInt(2));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void addUserToDatabase(BankUser user) {
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			CallableStatement cStatement = connection.prepareCall("{call CREATE_NEW_USER(?,?,?,?)}");
			
			cStatement.setString(1, user.getUsername());
			cStatement.setString(2, user.getEmail());
			cStatement.setBytes(3, user.getPasswordHash());
			cStatement.setBytes(4, user.getPasswordSalt());
			
			cStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void removeUserFromDatabase(BankUser user) {
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			CallableStatement cStatement = connection.prepareCall("{call DELETE_USER(?)}");
			
			cStatement.setString(1, user.getUsername());
			
			cStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void grantUserAccesToAccount(String username, BankAccount account) {
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			CallableStatement cStatement = connection.prepareCall("{call GRANT_USER_ACCESS(?,?)}");
			
			cStatement.setInt(1, account.getAccountID());
			cStatement.setString(2, username);
			
			cStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	// Queries
	public boolean canAddUserToDatabase(BankUser user) {
		
		if(user == null)
			return false;
		
		if(user.getUsername() == null || user.getUsername().isEmpty())
			return false;
		
		if(user.getEmail() == null || user.getEmail().isEmpty())
			return false;
		
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT COUNT(*) FROM BANK_USER WHERE USERNAME = ? OR EMAIL = ?");
			
			pStatement.setString(1, user.getUsername());
			pStatement.setString(2, user.getEmail());
			
			ResultSet result = pStatement.executeQuery();
			
			if(result.next())
				return result.getInt(1) == 0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean userExists(String username) {
		
		if(username == null || username.isEmpty())
			return false;
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT COUNT(*) FROM BANK_USER WHERE USERNAME = ?");
			
			pStatement.setString(1, username);
			
			ResultSet result = pStatement.executeQuery();
			
			if(result.next())
				return result.getInt(1) != 0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean emailInUse(String email) {
		
		if(email == null || email.isEmpty())
			return false;
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT COUNT(*) FROM BANK_USER WHERE EMAIL = ?");
			
			pStatement.setString(1, email);
			
			ResultSet result = pStatement.executeQuery();
			
			if(result.next())
				return result.getInt(1) != 0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
	
	public int numUsersForAccount(int accountID) {
		
		if(accountID == 0)
			return 0;
		
		try {
			
			Connection connection = ConnectionUtil.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT COUNT(*) FROM USER_ACCESS WHERE ACCOUNT_ID = ?");
			
			pStatement.setInt(1, accountID);
			
			ResultSet results = pStatement.executeQuery();
			
			if(results.next())
				return results.getInt(1);
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}
}
