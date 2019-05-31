package kingdom.animals;
/*
 * This class is using inheritance to share behaviors with other objects that implement or extend the AnimalAbstract class or AnimalInterface interface.
 */
public class Lion extends AnimalAbstract implements AnimalInterface{

	//an example of encapsulation through the variable omnivore as a private boolean and can't be accessed outside of the Lion class
	private boolean carnivore = true;
	
	public Lion() {
		this.setLegs(4);
	}
	
	public void nap() {
		System.out.println("This kitty is catching some Zzzz");
	}
	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("RAWR!");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
			System.out.println("*Eats fresh meat*");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (carnivore ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lion other = (Lion) obj;
		if (carnivore != other.carnivore)
			return false;
		return true;
	}

}
