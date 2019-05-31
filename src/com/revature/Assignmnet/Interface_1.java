package com.revature.Assignmnet;


interface Animal{
	
	 void name(String nam);
	 void color(String col);

}

class dog implements Animal{
	
	
	public void name(String n) {
		
		System.out.println("--------------------");
		
		System.out.println("The name of Animal is : "+n);
			
	}


	public void color(String color) {

		System.out.println("Color of Animal is : "+color);
		
		
		System.out.println("--------------------");
	}
	
}

class cat implements Animal{


	public void name(String n) {
		
		
		
		System.out.println("The name of Animal is : "+n);
			
	}


	public void color(String color) {

		System.out.println("Color of Animal is : "+color);
		
		
		System.out.println("--------------------");
	}
	
}

class Lion implements Animal{


	public void name(String n) {
		
		System.out.println("The name of Animal is : "+n);
			
	}


	public void color(String color) {

		System.out.println("Color of Animal is : "+color);
		
		System.out.println("--------------------");
	}
	
	
	
}


public class Interface_1 {
	
	public static void main(String[] args) {
		
		Animal anl = new dog(); // Polymorphic  Statement //
		anl.name("BullDog");
		anl.color("Black");
		
		anl = new cat();
		
		anl.name("Cat");
		anl.color("Brown");
		
		anl = new Lion();
		anl.name("Lion");
		anl.color("Brown");
		
	}


}

