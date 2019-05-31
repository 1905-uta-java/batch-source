package com.revature.Assignmnet;

public class Encapsulation {
	
	private int roll;    // Binding variable with the method to restrict user to invoke roll number directly //
	
	Encapsulation(){
		
		
		int roll = 1;

		
	}
	 

	
	void setter(int r) {   
		
		this.roll= r;
	}
	
	int getter() {
	
		System.out.println("Roll number inserted is : "+roll);
		return roll;
	}
	
	
	public static void main(String[] args) {
		
		Encapsulation eRef = new Encapsulation();
		
		eRef.setter(10);
		eRef.getter();
		
		
		
		
	}

}
