package com.revature.models;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "routeSequence")
	@SequenceGenerator(name = "routeSequence", sequenceName = "SQ_ROUTE_PK")
	@Column(name = "ROUTE_ID")
	private int id;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "START_TIME")
	private Timestamp idealStartTime;
	
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Manager manager;
	
	@ManyToOne
	@JoinColumn(name = "DRIVER_ID")
	private Driver driver;
	
	@OneToMany(
			mappedBy = "route",
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER)
	private List<RouteNode> nodes;
	
	public Route() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Timestamp getIdealStartTime() {
		return idealStartTime;
	}
	
	public void setIdealStartTime(Timestamp idealStartTime) {
		this.idealStartTime = idealStartTime;
	}
	
	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public Driver getDriver() {
		return driver;
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public List<RouteNode> getNodes() {
		return nodes;
	}
	
	public void setNodes(List<RouteNode> nodes) {
		this.nodes = nodes;
	}
	
	@Override
	public String toString() {
		return "Route [id=" + id + ", description=" + description + ", idealStartTime=" + idealStartTime + "]";
	}
}