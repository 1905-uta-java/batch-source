package com.revature.ProducerConsumer;

public class Consumer implements Runnable {
	private PCBuffer buffer;
	
	public Consumer() {
		super();
	}
	
	public Consumer(PCBuffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for(int x = 0; x < 10; x++) {
			buffer.get();
			
			try {
				Thread.sleep((int) (Math.random()*1500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
