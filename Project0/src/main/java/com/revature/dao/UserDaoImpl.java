package com.revature.dao;
import com.revature.util.ConnectionUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.revature.model.User;

public class UserDaoImpl implements UserDao {
	// create a user object
	// for populating after successful login
	User u = new User();

	public void createBankUser() throws SQLException {
		String userPassword = "";
		String userPassword2 = "0";
		Scanner userInput = new Scanner(System.in);

		System.out.println("Please enter email to create account: ");
		String userEmail = userInput.nextLine();
		do{
			System.out.println("Please enter password to create account: ");
			userPassword = userInput.nextLine();
			System.out.println("Please confirm the same password to create account: ");
			userPassword2 = userInput.nextLine();
		}while(!(userPassword.equals(userPassword2)));
		Double startingBalance = new Double(0.00);
		System.out.println("Your user email to login is " + userEmail + ".");
		String sql = "INSERT INTO BANK_USER (USER_EMAIL, USER_PASSWORD, USER_BALANCE) VALUES ('" + userEmail + "', '" + userPassword + "', '" + startingBalance + "')";
		
		Connection myConn= ConnectionUtil.getHardCodedConnection();
		Statement s = myConn.createStatement();
		s.executeQuery(sql);
	}
	
	public void login() throws SQLException {
		ResultSet rs = null;
		Scanner userInput = new Scanner(System.in);

		System.out.println("Please enter email to login: ");
		String userEmail = userInput.nextLine();
		System.out.println("Please enter password to login: ");
		String userPassword = userInput.nextLine();

        String sql = "SELECT * FROM BANK_USER WHERE USER_EMAIL = ? AND USER_PASSWORD = ?";
		Connection myConn= ConnectionUtil.getHardCodedConnection();
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setString(1, userEmail);
		ps.setString(2, userPassword);
		
		rs = ps.executeQuery();
		// produce object from prepared statement
		while(rs.next()) {
			String dbUserEmail = rs.getString("USER_EMAIL");
			String dbUserPassword = rs.getString("USER_PASSWORD");
			Double dbUserBalance = rs.getDouble("USER_BALANCE");
			u.email = dbUserEmail;
			u.password = dbUserPassword;
			u.balance = dbUserBalance;
		}
		rs.close();	
		if (u.password!=null||u.password.equals(userPassword)) {
			showPrivateMenu(u.email, u.balance);
		} else {
			System.out.println("Wrong username or password provided.");
		}
	}

	public void deposit() throws SQLException {
		Connection myConn= ConnectionUtil.getHardCodedConnection();
		CallableStatement myCallable = null;
		String sql = "";
		Scanner userInput = new Scanner(System.in);
		String userEmailForDeposit = "";
		String userEmail2 = "1";
		String inputAmount = "";
		Double amount = new Double(0.00);
		do{
			System.out.println("Please enter email to make deposit: ");
			userEmailForDeposit = userInput.nextLine();
			System.out.println("Please confirm the same email to make deposit: ");
			userEmail2 = userInput.nextLine();
		}while(!(userEmailForDeposit.equals(userEmail2)));
		
		System.out.println("Please enter amount to deposit: ");
		inputAmount = userInput.nextLine();
		amount = new Double(inputAmount);
		// prepare the stored procedure call
		sql = "{call deposit(?, ?)}";
		myCallable = myConn.prepareCall(sql);
		// set the parameters
		myCallable.setString(1, userEmailForDeposit);
		myCallable.setDouble(2, amount);
		// call the stored procedure
		myCallable.execute();
	}
	private void showPrivateMenu(String userEmail, Double userBalance) throws SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		char option = '0';
		Scanner scanner = new Scanner(System.in);
	
		System.out.println(dateFormat.format(date)); 
		System.out.println("you are a valued customer");
		
		do { 
		System.out.println("\n");
		System.out.println("a. withdraw");
		System.out.println("b. check balance");
		System.out.println("c. log out");
		System.out.println("enter an option: ");
	
		option = scanner.next().charAt(0);
		System.out.println("\n");
	
		switch(option) {
			case 'a':
				System.out.println("withdraw selected");
				withdraw(userEmail, userBalance);
				break;
			case 'b':
				System.out.println("check balance selected");
				checkBalance(userEmail);
				break;
			case 'c':
				System.out.println("log out selected");
				break;
			default:
				System.out.println("Not a valid option. Try again.");
				break; 
			} 
		} while (option != 'c');
		System.out.println("You have logged out.");
	}
	
	private void checkBalance(String userEmailForQuery) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Connection myConn= ConnectionUtil.getHardCodedConnection();

		String sql = "SELECT USER_BALANCE FROM BANK_USER WHERE USER_EMAIL = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, userEmailForQuery);
// 		Execute SQL query
		myRs = myStmt.executeQuery();
// 		Process result set
		while (myRs.next()) {
			Double userBalance = myRs.getDouble("USER_BALANCE");
			System.out.printf("%s%.2f\n", "Your balance is ", userBalance);
			u.balance = userBalance;
		}
	}

	public static boolean withdraw(String userEmailForWithdrawal, Double userBalance) throws SQLException {
			Connection myConn= ConnectionUtil.getHardCodedConnection();
			CallableStatement myCallable = null;
			String sql = "";
			Scanner userInput = new Scanner(System.in);
			String inputAmount = "";
			String confirmation = "";
			Double amount = new Double(0.00);
			do{
				System.out.println("Please enter amount to withdraw: ");
				inputAmount = userInput.nextLine();
				System.out.println("You would like to withdraw $" + inputAmount + ".\n" + 
				"Is this amount correct? (enter 'y' to proceed)\n");
				confirmation = userInput.nextLine().toLowerCase();
			}while(!(confirmation.equals("y")));
			
			amount = new Double(inputAmount);
			if (amount.compareTo(userBalance)==1) {
				System.out.println("The withdrawal exceeds existing balance.\n"
						+ "Enter a smaller value instead.");
			} else {
				// prepare the stored procedure call
				sql = "{call withdraw(?, ?)}";
				myCallable = myConn.prepareCall(sql);
				// set the parameters
				myCallable.setString(1, userEmailForWithdrawal);
				myCallable.setDouble(2, amount);
				// call the stored procedure
				myCallable.execute();
			}
			// return boolean flag for testing
			return true;
		}	
}