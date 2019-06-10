package com.revature.intro;

public class LambdaDriver {

	public static void main(String[] args) {
		
		Runnable run = () -> {
			System.out.println("Lambda printing.");
		};
		
		Thread thread = new Thread(run);
		thread.start();
		
		Thread t2 = new Thread(() -> {System.out.println("Another Lambda");}); //java knows the method run is being overridden because Runnable is a functional interface
		t2.start();

	}

}
