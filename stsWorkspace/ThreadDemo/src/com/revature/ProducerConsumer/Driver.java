package com.revature.ProducerConsumer;

public class Driver {

	public static void main(String[] args) {
		PCBuffer buffer = new PCBuffer();
		
		Runnable producerJob = new Producer(buffer);
		Runnable consumerJob = new Consumer(buffer);
		
		Thread produceWorker = new Thread(producerJob, "PRODUCER");
		Thread consumerWorker = new Thread(consumerJob, "CONSUMER");
		
		produceWorker.start();
		consumerWorker.start();

	}

}
