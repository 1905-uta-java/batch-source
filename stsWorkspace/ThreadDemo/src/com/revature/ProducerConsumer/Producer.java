package com.revature.ProducerConsumer;

public class Producer implements Runnable {
	
	private PCBuffer buffer;
	public Producer() {
		super();
	}
	
	public Producer(PCBuffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			buffer.put(i);
			try {
				Thread.sleep((int) (Math.random()*1500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
