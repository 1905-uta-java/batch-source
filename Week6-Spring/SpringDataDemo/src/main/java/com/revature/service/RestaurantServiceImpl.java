package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Restaurant;
import com.revature.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	RestaurantRepository rRepo;

	@Override
	public List<Restaurant> findAllRestaurants() {
		return rRepo.findAll();
	}

	@Override
	public Restaurant findRestaurantById(Integer id) {
		return rRepo.getOne(id);
	}

	@Override
	public Restaurant addRestaurant(Restaurant r) {
		return rRepo.save(r);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant r) {
		return rRepo.save(r);
	}

	@Override
	public Restaurant deleteRestaurant(Restaurant r) {
		rRepo.delete(r);
		return r;
	}

	@Override
	public List<Restaurant> findRestaurantByName(String name) {
		return rRepo.findRestaurantByName(name);
	}

}
