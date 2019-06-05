package com.revature.sync;

public class Count {
	
	volatile int count;
	
	public synchronized void increment() {
		count++;
	}

}
