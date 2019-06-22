package com.revature.collections;

public class RaceHorse implements Comparable<RaceHorse> {
	
	private int speed;
	private int number;
	private String name;
	private int rank;
	
	public RaceHorse() {
		super();
	}

	public RaceHorse(int speed, int number, String name, int rank) {
		super();
		this.speed = speed;
		this.number = number;
		this.name = name;
		this.rank = rank;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "RaceHorse [speed=" + speed + ", number=" + number + ", name=" + name + ", rank=" + rank + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + rank;
		result = prime * result + speed;
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
		RaceHorse other = (RaceHorse) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (rank != other.rank)
			return false;
		if (speed != other.speed)
			return false;
		return true;
	}

	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * compareTo returns an int result
	 * if it returns a negative value, the "this" object 
	 * 		is considered to be of a lesser value
	 * 
	 * if it returns a positive value, the "this" object 
	 * 		is considered to have a greater value than the compared object
	 * 
	 * if it returns 0, the compared values are considered to be the same
	 * 
	 */
	@Override
	public int compareTo(RaceHorse otherHorse) {
		return this.speed - otherHorse.speed;
	}
	
	
	
	

}
