package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class RouteNode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "routeNodeSequence")
	@SequenceGenerator(name = "routeNodeSequence", sequenceName = "SQ_ROUTE_NODE_PK")
	@Column(name = "ROUTE_NODE_ID")
	private int id;
	
	@Column(name = "GEO_LOC")
	private String location;
	
	@ManyToOne
	@JoinColumn(name = "ROUTE_ID")
	private Route route;
	
	@Column(name = "ORDER_POS")
	private int order;
	
	public RouteNode() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Route getRoute() {
		return route;
	}
	
	public void setRoute(Route route) {
		this.route = route;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "RouteNode [id=" + id + ", location=" + location + ", route=" + route + ", order=" + order + "]";
	}
}
