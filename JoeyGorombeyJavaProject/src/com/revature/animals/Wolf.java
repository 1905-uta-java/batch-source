package com.revature.animals;

// Compared to any other class in this program, Wolf has access to the most methods.
// It inherits from Animal, and also implements two interfaces.
// This Wolf class demonstrates how the abstract animal is rendered concretely,
// and how multiple interfaces can be implemented in the same class. 
public class Wolf extends Animal implements Domesticatable, Predatory
{
	boolean loneWolf;
	int numFangs;
	boolean outHunting;
	
	public Wolf()
	{
		// this makes a call to the Object class.
		super();
	}
	
	public Wolf(boolean loneWolf, int numFangs, boolean outHunting)
	{
		this.loneWolf = loneWolf;
		this.numFangs = numFangs;
		this.outHunting = outHunting;
	}
	
	// Various method overrides, possible as a result of inheritance, are key polymorphic ingredients,
	// as documented in more detail in the Hawk and Animal classes.
	@Override
	public void bringPreyHome() 
	{
		System.out.println("The Wolf has no trouble bringing its meal across the tundra.");
	}

	@Override
	public void feed() 
	{
		System.out.println("I wouldn't feed a wolf unless it's yours. But...go for it!");
	}

	@Override
	public void eat() 
	{
		System.out.println("The wolf is eating. Need I paint a picture?");
	}

	@Override
	public void sleep() 
	{
		System.out.println("Wolves can stay warm when they sleep, thanks to their thick furs.");
	}
	
	public void train()
	{
		System.out.println("Over many years of exposure to humans, some wolves became dogs!");
	}
	
	public void move()
	{
		System.out.println("The wolf bounds across the snows without a sound.");
	}

	public boolean isLoneWolf() {
		return loneWolf;
	}

	
	// as documented in other classes, getters and setters assist in ensuring robust encapsulation. 
	public void setLoneWolf(boolean loneWolf) {
		this.loneWolf = loneWolf;
	}

	public int getNumFangs() {
		return numFangs;
	}

	public void setNumFangs(int numFangs) {
		this.numFangs = numFangs;
	}

	public boolean isOutHunting() {
		return outHunting;
	}

	public void setOutHunting(boolean outHunting) {
		this.outHunting = outHunting;
	}

	// hashCode() Object method implemented
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (loneWolf ? 1231 : 1237);
		result = prime * result + numFangs;
		result = prime * result + (outHunting ? 1231 : 1237);
		return result;
	}

	// equals() Object method implemented.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wolf other = (Wolf) obj;
		if (loneWolf != other.loneWolf)
			return false;
		if (numFangs != other.numFangs)
			return false;
		if (outHunting != other.outHunting)
			return false;
		return true;
	}
	
	
}
