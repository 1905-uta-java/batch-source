package com.revature.producerconsumer;

public class Basket {
	
	private int contents;
	private boolean isAvailable = false;
	
	/*
	 * - if there is something available we want the consumer to get it
	 * - if there is not something available, we want the consumer to wait
	 */
	public synchronized int get() {
		while(!isAvailable) {
			try {
				System.out.println("\t\t\t"+Thread.currentThread().getName()+ " is waiting ");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("CONSUMER got: "+contents);
		isAvailable = false;
		notify();
		return contents;
	}
	
	/*
	 * check for availability
	 * - if there isn't something available, we want the producer to add contents 
	 * 		to our basket, making it available 
	 * - if there is something available, we want the producer to wait
	 */
	public synchronized void put(int value) {
		while(isAvailable) {
			try {
				System.out.println("\t\t\t"+ Thread.currentThread().getName()+" is waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("PRODUCER put: "+value);
		contents = value;
		isAvailable = true;
		notify();
	}

}
