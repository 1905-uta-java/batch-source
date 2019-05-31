// Name: Benjamin Onwenu

package com.revature.oop;

// Inheritance- Brant inherits methods and vairables from duck
public class Brant extends Duck {
	
	private String name;
	
	public Brant() {
		name = "Donald";
	}
	
	public void displayName() {
		System.out.println("The duck's name is " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Brant other = (Brant) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}