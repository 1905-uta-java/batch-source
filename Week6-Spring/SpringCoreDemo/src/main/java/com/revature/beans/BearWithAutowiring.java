package com.revature.beans;

public class BearWithAutowiring extends Bear {

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "BearWithAutowiring [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}
	


}
