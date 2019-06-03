package com.revature.sync;

public class ThreadDriver {

	public static void main(String[] args) {
		//create an instance of a stringbuilder and stringbuffer to be shared by two threads
		StringBuilder sbuilder = new StringBuilder();
		StringBuffer sbuffer = new StringBuffer();
		Runnable job1 = new StringTestRunnable(sbuilder, sbuffer, '*');
		Runnable job2 = new StringTestRunnable(sbuilder, sbuffer, '~');
		Thread t1 = new Thread(job1);
		Thread t2 = new Thread(job2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("StringBuilder result:");
		System.out.println(sbuilder);
		System.out.println();
		
		System.out.println("StringBuffer result:");
		System.out.println(sbuffer);
		System.out.println();

	}

}
