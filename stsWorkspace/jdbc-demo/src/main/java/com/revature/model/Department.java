package com.revature.model;

import java.io.Serializable;

public class Department implements Serializable {
	
	private static final long serialVersionUID = 3848462898024013861L;
	private int id;
	private String name;
	private double monthlyBudget;
	
	public Department() {
		super();
	}
	
	public Department(int id, String name, double monthlyBudget) {
		super();
		this.id = id;
		this.name = name;
		this.monthlyBudget = monthlyBudget;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMonthlyBudget() {
		return monthlyBudget;
	}

	public void setMonthlyBudget(double monthlyBudget) {
		this.monthlyBudget = monthlyBudget;
	}
	
	
}
