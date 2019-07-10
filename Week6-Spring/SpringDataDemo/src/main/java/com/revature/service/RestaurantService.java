package com.revature.service;

import java.util.List;

import com.revature.model.Restaurant;

public interface RestaurantService {
	
	public List<Restaurant> findAllRestaurants();
	public Restaurant findRestaurantById(Integer id);
	public List<Restaurant> findRestaurantByName(String name);
	public Restaurant addRestaurant(Restaurant r);
	public Restaurant updateRestaurant(Restaurant r);
	public Restaurant deleteRestaurant(Restaurant r);
	
	

}
