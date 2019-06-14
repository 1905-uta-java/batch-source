package com.revature.producerconsumer;

public class Consumer implements Runnable {
	
	Basket basket;
	
	public Consumer() {
		super();
	}
	
	public Consumer(Basket basket) {
		super();
		this.basket = basket;
	}

	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			basket.get();
			
			try {
				Thread.sleep((int)(Math.random()*1500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
