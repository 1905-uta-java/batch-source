package com.revature.exercise1;

public class Tiger extends Animal implements Carnivore {
	
	// This class extends the Animal class (Inheritance) and implements the Carnivore Interface (Abstraction)

	// Instance variable set to private. Only accessed by getters and setters. (Encapsulation)
	private int numOfStripes;
	
	public void roar() {
		System.out.println("Roar!");
	}
	
	
	public int getNumOfStripes() {
		return numOfStripes;
	}

	public void setNumOfStripes(int numOfStripes) {
		this.numOfStripes = numOfStripes;
	}


		// Referencing the Interface (Abstraction)
		@Override
		public void hunt() {
			System.out.println("I hunt for prey to eat.");
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + numOfStripes;
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tiger other = (Tiger) obj;
			if (numOfStripes != other.numOfStripes)
				return false;
			return true;
		}
	
		@Override
		public String toString() {
			return "Tiger [Stripes: " + numOfStripes + ", Legs: " + getLegs() + ", Size: " + getSize() + ", Has Fur: " + getHasFur() + "]";
		}
}
