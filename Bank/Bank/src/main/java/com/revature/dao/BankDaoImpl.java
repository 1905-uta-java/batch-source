package com.revature.dao;

import com.revature.model.Bank;
import com.revature.util.ConnectionUtil;

import java.sql.Statement;
import java.text.DecimalFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class BankDaoImpl implements BankDao {

	private static Scanner sc = new Scanner(System.in);
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	@Override
	public void createAccount(Bank b) {
		
		String amountChecking="a";
		String amountSavings="a";
		double Checking=0;
		double Savings=0;
		// TODO Auto-generated method stub
		System.out.println("Enter Username");
		String name = sc.nextLine();
		
		System.out.println("Enter Password");
		String password = sc.nextLine();
		
		String accountType="";
		while(accountType.equals("checking")==false&&accountType.equals("savings")==false&&accountType.equals("both")==false) {
			System.out.println("Checking, Savings or Both:");
			accountType = sc.nextLine();
			accountType= accountType.toLowerCase();
			
		}
		
		if(accountType.equals("checking")) {
			while(amountChecking.matches(".*[a-z].*")) {
				System.out.println("Enter Amount for Checking:");
				amountChecking = sc.nextLine();
			}
			Checking = Double.parseDouble(amountChecking);
			Checking = Double.parseDouble(df2.format(Checking));
			
		}else if(accountType.equals("savings")) {
			while(amountSavings.matches(".*[a-z].*")) {
				System.out.println("Enter Amount for Savings:");
				amountSavings = sc.nextLine();
			}
			Savings = Double.parseDouble(amountSavings);
			Savings = Double.parseDouble(df2.format(Savings));
			
				
		}else if (accountType.equals("both")) {
			
			while(amountChecking.matches(".*[a-z].*")) {
				System.out.println("Enter Amount for Checking:");
				amountChecking = sc.nextLine();
			}
			
			while(amountSavings.matches(".*[a-z].*")) {
				System.out.println("Enter Amount for Savings:");
				amountSavings = sc.nextLine();
			}
			
			Checking = Double.parseDouble(amountChecking);
			Checking = Double.parseDouble(df2.format(Checking));
			Savings = Double.parseDouble(amountSavings);
			Savings = Double.parseDouble(df2.format(Savings));
			
		}
		
		
		
		String sql = "INSERT INTO BANK VALUES(?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setDouble(3, Checking);
			ps.setDouble(4, Savings);
			int bankUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Something went wrong. Username might be in use.");
			createAccount(b);
			
		}
		
	}

	public double depositMoney(Bank b) {
		double newCBal= 0;
		double newSBal= 0;
		
		double currentCBal= 0;
		double currentSBal=0;
		String addCBal="a";
		String addSBal="a";
		String sql="";
		boolean negative=true;
		
		accountType(b);
		
		if(b.getAccountType().equals("checking")) {
			while(addCBal.matches(".*[a-z].*")) {
				while(negative) {
					System.out.println("Enter Amount for Checking:");
					addCBal = sc.nextLine();
					if(Double.parseDouble(addCBal)<0) {
						System.out.println("No negatives!");
						negative=true;
					}else
						negative=false;
				}
					
			}
			newCBal = Double.parseDouble(addCBal);
			
		}else if(b.getAccountType().equals("savings")) {
			while(addSBal.matches(".*[a-z].*")) {
				while(negative) {
					System.out.println("Enter Amount for Savings:");
					addSBal = sc.nextLine();
					if(Double.parseDouble(addSBal)<0) {
						System.out.println("No negatives!");
						negative=true;
					}else
						negative=false;
				}
			}
			newSBal = Double.parseDouble(addSBal);
			
			
		}
		
		sql = "SELECT * FROM BANK WHERE ACCOUNT_USERNAME= ? AND ACCOUNT_PASSWORD = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1,b.getUsername());
			ps.setString(2,b.getPassword());
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()){
				currentCBal= rs.getDouble("CHECKING_BALANCE");
				currentSBal = rs.getDouble("SAVINGS_BALANCE");
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		newCBal +=currentCBal;
		newSBal +=currentSBal;
		newCBal= Double.parseDouble(df2.format(newCBal));
		newSBal= Double.parseDouble(df2.format(newSBal));
		
		// TODO Auto-generated method stub
		String sql1 = "UPDATE BANK "
				+ "SET CHECKING_BALANCE = ?, "
				+ "SAVINGS_BALANCE = ? "
				+ "WHERE ACCOUNT_USERNAME = ? AND ACCOUNT_PASSWORD = ?" ;
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql1)){
			
			//con.setAutoCommit(false);
			ps.setDouble(1, newCBal);
			ps.setDouble(2, newSBal);
			ps.setString(3, b.getUsername());
			ps.setString(4, b.getPassword());
			int bankUpdated = ps.executeUpdate();
			//con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Money Deposited");
		if(b.getAccountType().equals("savings")) {
			return newSBal;
			
		}else {
			
			return newCBal;
		}
	}

	public double withdrawMoney(Bank b) {
		
		double newCBal= 0;
		double newSBal= 0;
		
		double currentCBal= 0;
		double currentSBal=0;
		String addCBal="a";
		String addSBal="a";
		String sql="";
		boolean negative=true;
		
		accountType(b);
	
		if(b.getAccountType().equals("checking")) {
			while(addCBal.matches(".*[a-z].*")) {
				while(negative) {
					System.out.println("Enter Amount for Checking:");
					addCBal = sc.nextLine();
					if(Double.parseDouble(addCBal)<0) {
						System.out.println("No negatives!");
						negative=true;
					}else
						negative=false;
				}
					
			}
			newCBal = Double.parseDouble(addCBal);
			
			
		}else if(b.getAccountType().equals("savings")) {
			while(addSBal.matches(".*[a-z].*")) {
				while(negative) {
					System.out.println("Enter Amount for Savings:");
					addSBal = sc.nextLine();
					if(Double.parseDouble(addSBal)<0) {
						System.out.println("No negatives!");
						negative=true;
					}else
						negative=false;
				}
			}
			newSBal = Double.parseDouble(addSBal);
			
			
		}
		sql = "SELECT * FROM BANK WHERE ACCOUNT_USERNAME= ? AND ACCOUNT_PASSWORD = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1,b.getUsername());
			ps.setString(2,b.getPassword());
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()){
				currentCBal= rs.getDouble("CHECKING_BALANCE");
				currentSBal = rs.getDouble("SAVINGS_BALANCE");
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		newCBal= Double.parseDouble(df2.format(newCBal));
		newSBal= Double.parseDouble(df2.format(newSBal));
		newCBal =currentCBal-newCBal;
		newSBal =currentSBal-newSBal;
		if(newSBal<0||newCBal<0) {
			System.out.println("Not enough money to withdraw!");
			withdrawMoney(b);
		}
		
		
		
		// TODO Auto-generated method stub
		String sql1 = "UPDATE BANK "
				+ "SET CHECKING_BALANCE = ?, "
				+ "SAVINGS_BALANCE = ? "
				+ "WHERE ACCOUNT_USERNAME = ? AND ACCOUNT_PASSWORD = ?" ;
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql1)){
			
			//con.setAutoCommit(false);
			ps.setDouble(1, newCBal);
			ps.setDouble(2, newSBal);
			ps.setString(3, b.getUsername());
			ps.setString(4, b.getPassword());
			int bankUpdated = ps.executeUpdate();
			//con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Money withdrawn");
		
		if(b.getAccountType().equals("savings")) {
			return newSBal;
			
		}else {
			
			return newCBal;
		}
		
		// TODO Auto-generated method stub
		
	}

	public void logIn(Bank b) {
		// TODO Auto-generated method stub
		System.out.println("Enter Username");
		String name = sc.nextLine();
		
		System.out.println("Enter Password");
		String password = sc.nextLine();
		
		String sql = "SELECT * FROM BANK WHERE ACCOUNT_USERNAME= ? AND ACCOUNT_PASSWORD = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			
			String username="";
			String pass="";
			while(rs.next()){
				username = rs.getString("ACCOUNT_USERNAME");
				pass = rs.getString("ACCOUNT_PASSWORD");
			}
			if(username.equals(name)==false||pass.equals(password)==false) {
				System.out.println("Can not find Username and Password.");
				logIn(b);
			}else {
				b.setUsername(username);
				b.setPassword(pass);
				System.out.println("You logged In");
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void logOut(Bank b) {
		// TODO Auto-generated method stub
		System.out.println("You logged out");
		b.setUsername("");
		b.setPassword("");
		
	}

	public double viewBalance(Bank b) {
		// TODO Auto-generated method stub
		String sql="";
		double balance=0;
		String view="";
		
		accountType(b);

		if(b.getAccountType().equals("checking")) {
			view="CHECKING_BALANCE";
			
			
		}else if(b.getAccountType().equals("savings")) {
			
			view="SAVINGS_BALANCE";
			
		}
		sql = "SELECT * FROM BANK WHERE ACCOUNT_USERNAME= ? AND ACCOUNT_PASSWORD = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1,b.getUsername());
			ps.setString(2,b.getPassword());
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()){
				balance= rs.getDouble(view);
				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(b.getAccountType().equals("checking")) {
			
			b.setCheckingBalance(balance);
			
		}else if(b.getAccountType().equals("savings")) {
			
			b.setSavingsBalance(balance);
			
		}
		
		//System.out.println(balance);
		return balance;
		
	}
	public void accountType(Bank b) {
		String accountType="";
		while(accountType.equals("checking")==false&&accountType.equals("savings")==false) {
			System.out.println("Checking or Savings? ");
			accountType = sc.nextLine();
			accountType= accountType.toLowerCase();
		}
		b.setAccountType(accountType);
		
	}
	
	public void start(Bank b) {
		String select= "";
		while(select.equals("create account")==false&&select.equals("log in")==false) {
			System.out.println("Create Account or Log In? ");
			select = sc.nextLine();
			select= select.toLowerCase();
		}
		
		if(select.equals("create account")) {
			createAccount(b);
			System.out.println("");
			logIn(b);
		}else if(select.equals("log in")) {
			logIn(b);
		}
		
		mainMenu(b);
	}
	
	public void mainMenu(Bank b) {
		
		
		String option= "";
		while(option.equals("view balance")==false&&option.equals("deposit")==false&&option.equals("withdraw")==false&&option.equals("log out")==false) {
			System.out.println("Choose one of the options below: ");
			System.out.println("View Balance");
			System.out.println("Deposit");
			System.out.println("Withdraw");
			System.out.println("Log Out");
			option = sc.nextLine();
			option= option.toLowerCase();
		}
		
		if(option.equals("view balance")) {
			System.out.println(viewBalance(b));
			mainMenu(b);
		}else if(option.equals("deposit")) {
			System.out.println("New Balance: "+ depositMoney(b));
			mainMenu(b);
		}else if(option.equals("withdraw")) {
			System.out.println("New Balance: "+ withdrawMoney(b));
			mainMenu(b);
		}else if(b.getAccountType().equals("log out")) {
			logOut(b);
			System.out.println("Thank you for your service.");
		}
	}

	
}
