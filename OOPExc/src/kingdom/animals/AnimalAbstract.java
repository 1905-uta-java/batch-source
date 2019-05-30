package kingdom.animals;

public abstract class AnimalAbstract implements AnimalInterface{

	/*the following variables support encapsulation and abstraction by being protected from manipulation outside of this package
	*and by being insuring any subclass will have these properties.
	*/ 
	protected int legs;
	
	public void move(int steps) {
		System.out.println(this.getClass() + " has moved " + steps + " steps!");
	}
	

	/* by making hashCode and equals abstract methods we are ensuring that subclasses will implement a 'unique' version
	 * of these otherwise default methods to the Object class.
	 */
	public abstract int hashCode();


	public abstract boolean equals(Object obj);

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}


	
}
