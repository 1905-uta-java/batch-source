package com.revature;

public class MySingleton {
	
	private static MySingleton mySingleton;
	
	/*
	 * private static MySingleton mySingleton = new MySingleton();
	 */
	
	private int value;

	private MySingleton() {
		super();
	}
	
	public static MySingleton getInstance() {
		// with an eager Singleton, we wouldn't include this condition
		if(mySingleton == null) {
			mySingleton = new MySingleton();
		}
		return mySingleton;
		
	}
	
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
}
