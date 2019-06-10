package com.revature.intro;

public class MyObj {
	
	static int count;
	
	@Override
	public void finalize() {
		count++;
		System.out.println(count + ": Garbage Collected.");
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++) {
			MyObj mo = new MyObj();
			System.gc();
		}
		

	}

}
