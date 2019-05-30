package com.revature.models;

public class Driver {

	public static void main(String[] args) {
//		Animal a1 = new Animal();
//		Animal a2 = new Animal();
//		System.out.println(a1.toString());
//		System.out.println(a2.toString());
//		System.out.println(a1 == a2);
//		System.out.println(a1.equals(a2));
//		
//		Cat c1 = new Cat();
//		Cat c2 = new Cat();
//		c2.setSize(5);
//		System.out.println(c1.equals(c2));
//		System.out.println(c1.hashCode());
//		System.out.println(c2.hashCode());
		
		Animal a3 = new Cat();
//		System.out.println(a3.getLegs());
		
		//virtual method invocation -- this is runtime polymorphism because at runtime the method is not determined
//		System.out.println(a3.toString());
		
		// this throws a ClassCastException because the object instantiated is not a Cat
//		Cat c3 = (Cat) new Animal();
		
		// because a3 was initialized as a cat, this cast would be okay
		Cat c4 = (Cat) a3;
		c4.setSize(10);
		System.out.println(c4);
		c4.setSize(-5);
		System.out.println(c4);
		
		
	}

}
