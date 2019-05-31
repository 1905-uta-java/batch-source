package com.revature.animals;

// Abstract class-- can still have concrete implementation, but cannot be instantiated.


public abstract class Animal 
{
	// Fields are often kept Private to ensure proper encapsulation. Private fields can, (with the exception of reflection),
	// only be accessed by getters and setters. Limited access to fields provides proper data protection--
	// even inadvertent changes cannot be made. 
	private boolean alive;
	private String name;
	private int weight;
	private int height;
	
	// No-args constructor for abstract class "Animal."
	// Even though this class is abstract, and cannot be instantiated, a constructor 
	// still provides utility because subclasses of Animal may invoke it if they, in turn,
	// have no arguments.
	// In this way, the constructor plays a key role in setting up proper inheritance chains.
	public Animal()
	{
		// this makes a call to the Object class.
		super();
	}
	
	
	// Constructor with arguments for abstract class "Animal."
	// Even though this class is abstract, and cannot be instantiated, a constructor 
	// still provides utility because subclasses of Animal may invoke it if they, in turn,
	// have no arguments.
	// In this way, the constructor plays a key role in setting up proper inheritance chains.
	public Animal(String name, int weight, int height, boolean alive)
	{
		this.alive = alive;
		this.name = name;
		this.weight = weight;
		this.height = height;
	}
	
	
	// Abstract methods that will be implemented later.
	// This is an example of abstraction, because the user of these methods need not worry
	// about how such methods are implemented.
	// Since instances of the Hawk, Pigeon, and Wolf inherit from Animal, those classes ARE animals via their respective IS-A relationships.
	// These relationships allow Polymorphism-- Wolf, Pidgeon, and Hawk can implement their own versions of eat(), sleep(), and move() because they inherit from Animal.
	public abstract void eat();
	public abstract void sleep();
	
	// concrete method with implementation
	public void move()
	{
		System.out.println("This animal is moving!");
	}
	
	
	// Getters and setters for each field listed below.
	// Getters and setters are public because the user needs to access them 
	// in order to retrieve (get) or change (set) a value. 
	// 
	// The public access of getters and setters means that variables can be private,
	// and therefore, protected from inadvertent change.
	//
	// In this way, getters and setters comprise a crucial part of encapsulation, or data protection.
	public boolean isAlive() 
	{
		return alive;
	}
	public void setAlive(boolean alive) 
	{
		this.alive = alive;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getWeight() 
	{
		return weight;
	}
	public void setWeight(int weight) 
	{
		this.weight = weight;
	}
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height) 
	{
		this.height = height;
	}
	
	
	// hashCode() Object method implemented.
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (alive ? 1231 : 1237);
		result = prime * result + height;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}
	
	// equals() Object method implemented.
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (alive != other.alive)
			return false;
		if (height != other.height)
			return false;
		if (name == null) 
		{
			if (other.name != null)
				return false;
		} 
		else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	
}
