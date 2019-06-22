package com.revature.gc;

public class MyObject {
	
	static int count;
	
	@Override
	public void finalize() {
		count++;
		System.out.println(count+": Garbage collected");
	}

	public static void main(String[] args) {
		
		for(int i = 0; i<100; i++) {
			MyObject o = new MyObject();
			System.gc();
		}
		
//		System.gc();

	}

}
