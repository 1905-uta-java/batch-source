package com.revature;

public class MySingleton {
	private static MySingleton mySingleton;
	
	/*
	 * 
	 * 
	 */
	
	private int value;
	
	private MySingleton() {
		super();
	}
	
	public static MySingleton getInstance() {
		//with an eager Singleton no need for the condition
		if(mySingleton == null) {
			mySingleton = new MySingleton();
		}
		
		return mySingleton;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
