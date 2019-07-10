package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

	public List<Restaurant> findRestaurantByRating(Integer rating);
	public List<Restaurant> findRestaurantByName(String name);
	
}
