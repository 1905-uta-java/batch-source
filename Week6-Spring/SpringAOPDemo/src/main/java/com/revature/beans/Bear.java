package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Bear {
	
	private static boolean isWinter = false;
	private boolean isFull = true;
	private boolean isAwake = true;
	
	
	public static boolean isWinter() {
		return isWinter;
	}
	public static void setWinter(boolean isWinter) {
		Bear.isWinter = isWinter;
	}
	public boolean isFull() {
		return isFull;
	}
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	public boolean isAwake() {
		return isAwake;
	}
	public void setAwake(boolean isAwake) {
		this.isAwake = isAwake;
	}
	
	public void bearHibernates() {
		if(Bear.isWinter) {
			setAwake(false);
			System.out.println("zzz");
		} else {
			throw new RuntimeException("bears hibernate in the winter");
		}
	}
	
	public void wakeBear() {
		setAwake(true);
	}
	
	@Override
	public String toString() {
		return "Bear [isFull=" + isFull + ", isAwake=" + isAwake + "]";
	}
	
	

}
