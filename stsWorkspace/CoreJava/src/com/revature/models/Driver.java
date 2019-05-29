package com.revature.models;

public class Driver {

	public static void main(String[] args) {
		Animals f = new Animals();
		Animals g = new Animals();
		System.out.println(f.toString());
		System.out.println(g.toString());
		System.out.println(f == g); //checks mem address reference
		System.out.println(f.equals(g));
		
		Cat a = new Cat();
		Cat b = new Cat();
		b.setSize(11);
		System.out.println(a.equals(b));
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		Animals c = new Cat();
		//example of runtime polymorphism
		System.out.println(c.toString());
		
		//Only cast when you know for sure the casted object is an instance of the casting class
		Cat d = (Cat) c;
		
		//f is not an instance of cat so even though we cast cat to f it will still result in a ClassCastException error
		//Cat e = (Cat) f;

	}

}
