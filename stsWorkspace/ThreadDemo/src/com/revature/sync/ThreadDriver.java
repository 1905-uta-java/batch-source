package com.revature.sync;

public class ThreadDriver {

	public static void main(String[] args) {
		//create new instances of StringBuilder and StringBuffer
		//to be shared by two threads
		/*StringBuilder sBuilder = new StringBuilder();
		StringBuffer sBuffer = new StringBuffer();
		Runnable job1 = new StringTestRunnable(sBuilder, sBuffer, 'a');
		Runnable job2 = new StringTestRunnable(sBuilder, sBuffer, 'b');
		Thread t1 = new Thread(job1);
		Thread t2 = new Thread(job2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("StringBuilder result: ");
		System.out.println(sBuilder);
		System.out.println();
		//System.out.println(sBuffer);
		
		System.out.println();
		System.out.println();
		
		System.out.println("StringBuffer result: ");
		System.out.println(sBuffer);
		System.out.println();
		//System.out.println(sBuffer);
		 *
		 */
		
		Account count = new Account();
		Runnable countJob = new AccountTestRunnable(count);
		Thread countThread1 = new Thread(countJob);
		Thread countThread2 = new Thread(countJob);
		
		countThread1.start();
		countThread2.start();
		
		try {
			countThread1.join();
			countThread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count is: " + count.count);

	}

}
