package com.revature.animals;

// By extending from Animal, Hawk is polymorphic.
// By overriding the eat, sleep, and move methods inherited from Animal class, the Hawk class
// displays polymorphism: it makes use of the Animal class's methods, but implements them in its own way.

// By implementing the Predatory interface, this program achieves a layer of abstraction.
// Anyone using an instance of the Hawk class does not have to worry about how a hawk is a predator.
// Instead, the relevant details are that a hawk IS predatory-- key information that the interface provides the user.
public class Hawk extends Animal implements Predatory
{
	
	// As with most class fields, these are kept private in order to prevent inadvertent change.
	// Protection against inadvertent change facilitates the Encapsulation pillar. 
	private String pitch;
	private boolean longBeak;
	private int altitude;
	
	// As explained in the "Animal" class, a no-args constructor is best practice.
	public Hawk()
	{
		super();
	}
	
	// An additional constructor with parameters is present below.
	public Hawk(String pitch, boolean longBeak, int altitude)
	{
		this.pitch = pitch;
		this.longBeak = longBeak;
		this.altitude = altitude;
	}
	
	// As explained in "Animal" class, getters and setters facilitate Encapsulation
	// by protecting data from inadvertent changes. 
	public String getPitch() {
		return pitch;
	}

	public void setPitch(String pitch) {
		this.pitch = pitch;
	}

	public boolean isLongBeak() {
		return longBeak;
	}

	public void setLongBeak(boolean longBeak) {
		this.longBeak = longBeak;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	
	// Because eat and sleep methods are abstract in the Animal class, they are defined
	// more concretely here in the Hawk class.
	// The Hawk class implements this separate definition--method overriding-- which is a seminal aspect of polymorphism.
	@Override
	public void eat() 
	{
		System.out.println("The hawk eats dinner!");	
	}
	
	
	@Override
	public void sleep() 
	{
		System.out.println("The hawk dozes in its comfy loft, high above ground!");
		
	}
	
	// Hawk can have unique methods, such as screech()
	public void screech()
	{
		System.out.println("The hawk cries out, its call ringing against the mountains.");
	}

	// Because Hawk implements the Predatory interface, it also has access to bringPreyHome().
	@Override
	public void bringPreyHome() 
	{
		System.out.println("The hawk takes its prey by the talons, and takes to the skies!");
	}

	
	// hashCode() Object method implemented.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + altitude;
		result = prime * result + (longBeak ? 1231 : 1237);
		result = prime * result + ((pitch == null) ? 0 : pitch.hashCode());
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
		Hawk other = (Hawk) obj;
		if (altitude != other.altitude)
			return false;
		if (longBeak != other.longBeak)
			return false;
		if (pitch == null) 
		{
			if (other.pitch != null)
				return false;
		} 
		else if (!pitch.equals(other.pitch))
			return false;
		return true;
	}
	
	

}
