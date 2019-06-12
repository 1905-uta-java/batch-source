package com.revature.project0;

import com.revature.project0.database.BankSessionDaoImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		
		BankSessionDao dao = new BankSessionDaoImpl();
		BankSession session = new BankSession(dao);
		session.start();
	}
}
