package com.revature.Assignmnet;

import java.util.Scanner;

abstract class Account   // Abstract class with Inheritance //
{
	long Account_Number;
	String name;
	double balance=0;
	
	public void deposit(double amount)
	{
		System.out.println("Amount Deposited "+amount);
		
		balance += amount;
	}
	
	public void withdraw(double amount)
	{
		System.out.println("Amount withdrawn.. "+amount);
		
		balance -= amount;
	}
	
	public void displayAccountDetails()
	{
		System.out.println();
		
		System.out.println("Displaying account details...");
		
		System.out.println("Account no " + Account_Number );
		
		System.out.println("Name " + name );
	}
	
	public void displayBalance()
	{
		System.out.println("Balance is "+balance);
	}
	
}

final class  SB_Account extends Account
{
	double min_balance = 5000;
	
	void addInterest(int months)
	{
		balance = balance + (months * 0.04);
	}
	
	public   void deposit(double amount)
	{
		super.deposit(amount);
	}
	
	public   void withdraw(double amount)
	{
		super.withdraw(amount);
	}
	

}

final class CurrentAccount extends Account
{
	double min_balance = 1000;
	
	public   void deposit(double amount)
	{
		super.deposit(amount);
	}
	
	public   void withdraw(double amount)
	{
		super.withdraw(amount);
	}
	
}


public class Abstract_Inheritance {
	
	public static void main (String args[])
	{
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter the type of account you want to create :");
		String account_type = sc.next();
		
		//Runtien polymorphism //
		Account acct;		
		
		if (account_type.equalsIgnoreCase("SAVING"))
			
			acct = new SB_Account();
		else
			acct = new CurrentAccount();
		
		
		
		System.out.println("Enter account number...");
		acct.Account_Number = sc.nextLong();
		
		
		System.out.println("Enter Name...");
		acct.name = sc.next ();
	
		System.out.println("Enter Deposit...");
		double amount = sc.nextDouble();
		
		acct.displayAccountDetails();
		
		acct.deposit(amount);
		acct.deposit(1000);
		acct.withdraw(200);
		
		
		
		acct.displayBalance();	
		
	}

}
