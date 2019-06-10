package com.revature.sync;

public class Account {
	volatile int count;
	
	public synchronized void increment() {
		count++;
	}
}
