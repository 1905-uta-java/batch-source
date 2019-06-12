package com.revature.BankingApp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.revature.BankingApp.doa.AccountDoaImpl;
import com.revature.BankingApp.doa.CustomerDoaImpl;
import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;
import com.revature.BankingApp.util.ConnectionUtil;
import com.revature.BankingApp.window.WelcomeWindow;

public class BankDriver {
	Connection c;
	public static void main(String[]args) {
				/*
				Connection c = ConnectionUtil.getHardCodedConnection();
				
				System.out.println(c.getMetaData().getDriverName());
				AccountDoaImpl ad = new AccountDoaImpl();
				CustomerDoaImpl cd = new CustomerDoaImpl();
				EmployeeDoaImpl ed = new EmployeeDoaImpl();
				System.out.println(ad.getAccount().get(0).toString());
				System.out.println(cd.getCustomerById(2));
				System.out.println(ed.getEmployeeById(8));
			*/
			
			WelcomeWindow ww = new WelcomeWindow();
	}
	
	
	
	public static void connect(String url, String un, String pass) {
		try {
		ConnectionUtil.getConnection(url, un, pass);
		}
		catch(Exception a) {
			a.printStackTrace();
		}
		
	}
	
	public static Customer User(String u, String p) {
		CustomerDoaImpl cdl = new CustomerDoaImpl();
		List<Customer> customers = cdl.getCustomer();
		for(Customer c : customers) {
			if(c.getUsername().equals(u) && c.getPassword().equals(p)) {
				return c;
			}
		}
		return null;
	}
	
	public static List<Account> getAccount(int cId) {
		AccountDoaImpl adl = new AccountDoaImpl();
		return adl.getAccountByCustomerId(cId);
	}
	
	public static void createNewAccount(Customer c, double balance, String AccountType) {
		AccountDoaImpl adl = new AccountDoaImpl();
		adl.createAccount(c, balance, AccountType);
	}
	
	public static boolean isDouble(String s) {
		 try {
		        double d = Double.parseDouble(s);
		    } catch (NumberFormatException | NullPointerException nfe) {
		        return false;
		    }
		    return true;
	}
	
	public static void deposit(Account a, double d) {
		AccountDoaImpl adl = new AccountDoaImpl();
		adl.updateAccount(a,d);
	}
	
	public static void withdraw(Account a, double d) {
		AccountDoaImpl adl = new AccountDoaImpl();
		adl.updateAccount(a , -d);
	}
	
	public static boolean emailExist(String s) {
		CustomerDoaImpl cdl = new CustomerDoaImpl();
		List<Customer> customers = new ArrayList();
		customers = cdl.getCustomer();
		for(Customer c: customers) {
			if(c.getEmail().equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean userExist(String s) {
		CustomerDoaImpl cdl = new CustomerDoaImpl();
		List<Customer> customers = new ArrayList();
		customers = cdl.getCustomer();
		for(Customer c: customers) {
			if(c.getUsername().equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}
	
	public static void addCustomer(Customer c) {
		CustomerDoaImpl cdl = new CustomerDoaImpl();
		cdl.addCustomer(c);
	}
	
	public static List<Account>getCustomerAccounts(Customer c){
		AccountDoaImpl acl = new AccountDoaImpl();
		return acl.getAccountByCustomerId(c.getCustomerId());
	}
}
