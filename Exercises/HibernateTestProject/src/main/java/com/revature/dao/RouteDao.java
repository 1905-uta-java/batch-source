package com.revature.dao;

import java.util.List;
import java.util.Set;

import com.revature.models.Route;
import com.revature.models.RouteNode;

public interface RouteDao {
	
	void createRoute(Route route);
	void createRouteNode(RouteNode node);
	
	Route getRoute(int routeId);
	RouteNode getRouteNode(int routeNodeId);
	List<Route> getRoutesForDriver(int driverId);
	List<Route> getRoutesForManager(int managerId);
	
	void updateRoute(Route route);
	void updateRouteNode(RouteNode node);
	
	void deleteRoute(int routeId);
	void deleteRouteNode(int routeNodeId);
}
