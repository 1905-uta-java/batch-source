package com.revature.twanimal;

public class Wolf implements Animal {

	@Override
	public void makeNoise() {
		// TODO Auto-generated method stub
		System.out.println("Howl");
	}

	@Override
	public void searchForFood() {
		// TODO Auto-generated method stub
		System.out.println("Found Rabbit");
	}

	@Override
	public void findHome() {
		// TODO Auto-generated method stub
		System.out.println("Returned to pack");
	}

}
