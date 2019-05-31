package com.revature.animals;

public class Pidgeon extends Animal implements Domesticatable 
{
	// As with other classes, private fields ensure proper encapsulation.
	boolean sittingOnWire;
	boolean inBackyard;
	int numFlocksMigrated;
	
	public Pidgeon()
	{
		// this makes a call to the Object class.
		super();
	}
	
	// constructor with all args.
	public Pidgeon(boolean sittingOnWire, boolean inBackyard, int numFlocksMigrated)
	{
		this.sittingOnWire = sittingOnWire;
		this.inBackyard = inBackyard;
		this.numFlocksMigrated = numFlocksMigrated;
	}

	// As with other concrete classes that inherit from Animal, the Pidgeon class implements the move(), eat(), and sleep() methods in its own way,
	// a key feature of polymorphism only possible because Pidgeon extends Animal.
	@Override
	public void feed() 
	{
		System.out.println("The pidgeon is being fed by gracious humans like yourself!");		
	}

	@Override
	public void eat() 
	{
		System.out.println("The pidgeon often likes to eat what humans leave outside for them.");
		System.out.println("Some pidgeons prefer more natural means of eating.");
	}

	@Override
	public void sleep() 
	{
		System.out.println("The pidgeon is asleep. I hear some like to sleep on telephone wires!");
	}

	// getters and setters which access the private fields, and serve as the only access point for the user.
	// It's proper encapsulation practice to have these if meaningful interaction with data is expected; 
	// without them, access would be almost impossible!
	public boolean isSittingOnWire() {
		return sittingOnWire;
	}

	public void setSittingOnWire(boolean sittingOnWire) {
		this.sittingOnWire = sittingOnWire;
	}

	public boolean isInBackyard() {
		return inBackyard;
	}

	public void setInBackyard(boolean inBackyard) {
		this.inBackyard = inBackyard;
	}

	public int getNumFlocksMigrated() {
		return numFlocksMigrated;
	}

	public void setNumFlocksMigrated(int numFlocksMigrated) {
		this.numFlocksMigrated = numFlocksMigrated;
	}

	// hashCode() Object method implemented
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (inBackyard ? 1231 : 1237);
		result = prime * result + numFlocksMigrated;
		result = prime * result + (sittingOnWire ? 1231 : 1237);
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
		Pidgeon other = (Pidgeon) obj;
		if (inBackyard != other.inBackyard)
			return false;
		if (numFlocksMigrated != other.numFlocksMigrated)
			return false;
		if (sittingOnWire != other.sittingOnWire)
			return false;
		return true;
	}
	
	
	

}
