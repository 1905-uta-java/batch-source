package com.revature.ProducerConsumer;

public class PCBuffer {
	private int contents;
	private boolean isAvailable = false;
	
	/*
	 * - If there is something available we want the consumer to get it
	 * - if there is not something available then wait
	 * 
	 */
	
	public synchronized int get() {
		while(!isAvailable) {
			System.out.println("\t\t\t" + Thread.currentThread().getName() + " is waiting.");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end while
		
		System.out.println("CONSUMER got: " + contents);
		isAvailable = false;
		notify(); //let producer know that consumer has handled the contents
		return contents;
	}
	
	/*
	 * - Check for availability
	 * - if there isn't something available then make it available
	 * - if there is something available then wait
	 */
	
	public synchronized void put(int value) {
		while(isAvailable)
			try {
				System.out.println("\t\t\t" + Thread.currentThread().getName() + " is waiting.");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("PRODUCER put: " + value);
		contents = value;
		isAvailable = true;
		notify();
		
	}

}
