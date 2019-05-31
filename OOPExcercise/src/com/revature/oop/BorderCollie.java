// Name: Benjamin Onwenu

package com.revature.oop;

public class BorderCollie extends Dog {
	
	private String name;
	
	public BorderCollie() {
		name = "Lassie";
	}
	
	public void displayName() {
		System.out.println("The dog's name is " + name);
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
		BorderCollie other = (BorderCollie) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}
	
	
}
