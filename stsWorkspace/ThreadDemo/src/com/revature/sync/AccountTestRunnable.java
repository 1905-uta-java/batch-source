package com.revature.sync;

public class AccountTestRunnable implements Runnable {
	private Account a = new Account();
	public AccountTestRunnable() {
		
	}
	
	public AccountTestRunnable(Account c) {
		this.a = c;
	}
	
	@Override
	public void run() {
		for(int x = 0; x < 5000; x++)
			a.increment();
	}

}
