package com.revature.models;

public class CoffeeMachine {
	
	private int id;
	private boolean hasCoffee;
	private boolean hasWater;
	private int timeRemaining;
	
	public CoffeeMachine() {
		super();
	}

	public CoffeeMachine(int id, boolean hasCoffee, boolean hasWater, int timeRemaining) {
		super();
		this.id = id;
		this.hasCoffee = hasCoffee;
		this.hasWater = hasWater;
		this.timeRemaining = timeRemaining;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isHasCoffee() {
		return hasCoffee;
	}

	public void setHasCoffee(boolean hasCoffee) {
		this.hasCoffee = hasCoffee;
	}

	public boolean isHasWater() {
		return hasWater;
	}

	public void setHasWater(boolean hasWater) {
		this.hasWater = hasWater;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	@Override
	public String toString() {
		return "CoffeeMachine [id=" + id + ", hasCoffee=" + hasCoffee + ", hasWater=" + hasWater + ", timeRemaining="
				+ timeRemaining + "]";
	}

}
