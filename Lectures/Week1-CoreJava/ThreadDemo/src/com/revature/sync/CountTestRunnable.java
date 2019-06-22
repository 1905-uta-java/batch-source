package com.revature.sync;

public class CountTestRunnable implements Runnable {

	Count c = new Count();
	
	public CountTestRunnable() {
		super();
	}
	
	public CountTestRunnable(Count c) {
		super();
		this.c = c;
	}
	
	@Override
	public void run() {
		for(int i=0; i<5000;i++) {
			c.increment();
		}
		
	}

}
