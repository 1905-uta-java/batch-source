package com.revature;

import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.model.Bank;



public class Driver {
	public static void main(String[] args) {
		
		
		
		String accountType="checking";
		
		Bank b = new Bank();
		BankDao bd = new BankDaoImpl();
		bd.start(b);
		//bd.logIn(b);
		//bd.accountType(b);
		//System.out.println("Money left in account: "+ bd.depositMoney(b));
		//bd.logOut(b);
	}

}
