package com.revature.producerconsumer;

public class Driver {

	public static void main(String[] args) {
		
		Basket b = new Basket();
		
		Runnable producerJob = new Producer(b);
		Runnable consumerJob = new Consumer(b);
		
		Thread producerWorker = new Thread(producerJob, "PRODUCER");
		Thread consumerWorker = new Thread(consumerJob, "CONSUMER");
		
		producerWorker.start();
		consumerWorker.start();

	}

}
