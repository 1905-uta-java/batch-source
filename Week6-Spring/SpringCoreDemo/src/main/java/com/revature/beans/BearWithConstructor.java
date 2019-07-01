package com.revature.beans;

public class BearWithConstructor extends Bear {

	public BearWithConstructor() {
		super();
	}

	public BearWithConstructor(int id, String name, Cave cave) {
		super(id, name, cave);
	}
	
	public BearWithConstructor(Cave cave) {
		super();
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "BearWithConstructor [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}



	

}
