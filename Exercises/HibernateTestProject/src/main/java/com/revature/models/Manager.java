package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="USER_ID")
public class Manager extends User {
	
	@OneToMany(
			mappedBy = "manager",
			fetch = FetchType.EAGER)
	private List<Driver> drivers;
	
	@OneToMany(mappedBy = "manager",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	private List<Route> routes;
	
	public Manager() {
		super();
	}
	
	public List<Driver> getDrivers() {
		return drivers;
	}
	
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}
	
	public List<Route> getRoutes() {
		return routes;
	}
	
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
	
	@Override
	public String toString() {
		return "Manager [getId()=" + getId() + ", getUsername()=" + getUsername()
				+ ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone() + "]";
	}
}