package com.revature.model;

import org.springframework.stereotype.Component;

@Component
public class Sandwich {
	
	private int id;
	private BreadType breadType;
	private MeatType meat;
	private boolean hasCrust;
	
	public Sandwich() {
		super();
	}

	public Sandwich(int id, BreadType breadType, MeatType meat, boolean hasCrust) {
		super();
		this.id = id;
		this.breadType = breadType;
		this.meat = meat;
		this.hasCrust = hasCrust;
	}

	public Sandwich(BreadType breadType, MeatType meat, boolean hasCrust) {
		super();
		this.breadType = breadType;
		this.meat = meat;
		this.hasCrust = hasCrust;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BreadType getBreadType() {
		return breadType;
	}

	public void setBreadType(BreadType breadType) {
		this.breadType = breadType;
	}

	public MeatType getMeat() {
		return meat;
	}

	public void setMeat(MeatType meat) {
		this.meat = meat;
	}

	public boolean isHasCrust() {
		return hasCrust;
	}

	public void setHasCrust(boolean hasCrust) {
		this.hasCrust = hasCrust;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breadType == null) ? 0 : breadType.hashCode());
		result = prime * result + (hasCrust ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((meat == null) ? 0 : meat.hashCode());
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
		Sandwich other = (Sandwich) obj;
		if (breadType != other.breadType)
			return false;
		if (hasCrust != other.hasCrust)
			return false;
		if (id != other.id)
			return false;
		if (meat != other.meat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sandwich [id=" + id + ", breadType=" + breadType + ", meat=" + meat + ", hasCrust=" + hasCrust + "]";
	}
	
}
