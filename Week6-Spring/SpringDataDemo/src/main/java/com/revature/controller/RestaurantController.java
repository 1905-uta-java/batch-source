package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Restaurant;
import com.revature.service.RestaurantService;

@RestController // @Controller + @ResponseBody over each method
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	RestaurantService rService;

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Restaurant> getAllRestaurants(@RequestParam(value="name", required=false) String name){
		if(name!=null) {
			return rService.findRestaurantByName(name);
		}
		return rService.findAllRestaurants();
	}
	
	@GetMapping(value="/{id}")
	public Restaurant getRestaurantById(@PathVariable("id") Integer id) {
		return rService.findRestaurantById(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant r) {
		List<Restaurant> restaurants = rService.findAllRestaurants();
		for(Restaurant restaurant: restaurants) {
			if(r.getId()==restaurant.getId()) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}
		return new ResponseEntity<Restaurant>(rService.addRestaurant(r), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Restaurant updateRestaurant(@PathVariable("id")Integer id, @RequestBody Restaurant r) {
		r.setId(id);
		return rService.updateRestaurant(r);
	}
	
	@DeleteMapping("/{id}")
	public Restaurant deleteRestaurant(@PathVariable("id") Integer id) {
		Restaurant r = new Restaurant(id);
		return rService.deleteRestaurant(r);
	}
}
