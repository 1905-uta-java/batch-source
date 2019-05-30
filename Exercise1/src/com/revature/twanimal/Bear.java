package com.revature.twanimal;


public abstract class Bear implements Animal {

	//Encapsulation, properties are only accessible through getters/setters
	private String furColor;
	private boolean isMale;
	private int hunger = 50;
	
	@Override
	public void makeNoise() {
		System.out.println("Bear growls");

	}

	@Override
	public void searchForFood() {
		System.out.println("Found berries");
		hunger -= 10;

	}

	@Override
	public abstract void findHome();

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getHunger() {
		return hunger;
	}
	
	public void setHunger(int hunger) {
		this.hunger = hunger;	
	}
}
