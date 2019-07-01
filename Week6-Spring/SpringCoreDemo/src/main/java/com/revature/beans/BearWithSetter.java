package com.revature.beans;

public class BearWithSetter extends Bear {
	
	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "BearWithSetter [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}



	
}
