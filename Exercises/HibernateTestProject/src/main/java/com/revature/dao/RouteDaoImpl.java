package com.revature.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Driver;
import com.revature.models.Manager;
import com.revature.models.Route;
import com.revature.models.RouteNode;
import com.revature.util.HibernateUtil;

public class RouteDaoImpl implements RouteDao {
	
	public void createRoute(Route route) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.save(route);
		
		t.commit();
		s.close();
	}
	
	public void createRouteNode(RouteNode node) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.save(node);
		
		t.commit();
		s.close();
	}

	public Route getRoute(int routeId) {
		
		Session s = HibernateUtil.getSession();
		
		Route route = s.get(Route.class, routeId);
		
		s.close();
		
		return route;
	}

	public RouteNode getRouteNode(int routeNodeId) {
		
		Session s = HibernateUtil.getSession();
		
		RouteNode routeNode = s.get(RouteNode.class, routeNodeId);
		
		s.close();
		
		return routeNode;
	}
	
	public List<Route> getRoutesForDriver(int driverId) {
		
		Session s = HibernateUtil.getSession();
		
		List<Route> routes = s.get(Driver.class, driverId).getRoutes();
		
		s.close();
		
		return routes;
	}
	
	public List<Route> getRoutesForManager(int managerId) {
		
		Session s = HibernateUtil.getSession();
		
		List<Route> routes = s.get(Manager.class, managerId).getRoutes();
		
		s.close();
		
		return routes;
	}
	
	public void updateRoute(Route route) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.update(route);
		
		t.commit();
		s.close();
	}

	public void updateRouteNode(RouteNode node) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.update(node);
		
		t.commit();
		s.close();
	}

	public void deleteRoute(int routeId) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Route route = new Route();
		route.setId(routeId);
		
		s.delete(route);
		
		t.commit();
		s.close();
	}

	public void deleteRouteNode(int routeNodeId) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		RouteNode node = new RouteNode();
		node.setId(routeNodeId);
		
		s.delete(node);
		
		t.commit();
		s.close();
	}
}
