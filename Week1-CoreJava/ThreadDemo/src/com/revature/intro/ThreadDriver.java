package com.revature.intro;

public class ThreadDriver {

	public static void main(String[] args) {

		Thread t = new TestThread();
		
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());
		
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());
		System.out.println("Thread state: "+t.getState()+" isAlive? "+t.isAlive());

		
		
		
	}

}
