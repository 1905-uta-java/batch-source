package kingdom.animals;
/*
 * This class is using inheritance to share behaviors with other objects that implement or extend the AnimalAbstract class or AnimalInterface interface.
 */
public class Giraffe extends AnimalAbstract implements AnimalInterface{
	
	//an example of encapsulation through the variable omnivore as a private boolean and can't be accessed outside of the Giraffe class
	private boolean herbivore = true;
	
	public Giraffe() {
		this.setLegs(4);
	}
	
	public void reach() {
		System.out.println("This guy has a long neck to reach high places");
	}
	
	public void move(int steps) {
		System.out.println("This Giraffe has moved " + steps +" steps.");
	}
	
	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Idk what sounds Giraffe's make...");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("*Eats some leaves*");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (herbivore ? 1231 : 1237);
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
		Giraffe other = (Giraffe) obj;
		if (herbivore != other.herbivore)
			return false;
		return true;
	}

}
