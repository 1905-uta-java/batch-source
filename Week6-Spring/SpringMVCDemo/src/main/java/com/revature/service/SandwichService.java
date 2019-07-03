package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.model.BreadType;
import com.revature.model.MeatType;
import com.revature.model.Sandwich;

@Service
public class SandwichService {
	
	private List<Sandwich> sandwiches = new ArrayList<>();
	
	public SandwichService() {
		sandwiches.add(new Sandwich(1, BreadType.RYE, MeatType.ROAST_BEEF, true));
		sandwiches.add(new Sandwich(2, BreadType.WHITE, MeatType.HAM, false));
		sandwiches.add(new Sandwich(3, BreadType.WHEAT, MeatType.TURKEY, true));
	}
	
	public List<Sandwich> getAll(){
		return new ArrayList<Sandwich>(sandwiches);
	}

	public Sandwich getById(int id) {
		for(Sandwich s: sandwiches) {
			if(s.getId()==id) {
				return s;
			}
		}
		return null;
	}
	
	public void create(Sandwich s) {
		int maxId = 0;
		for(Sandwich sandwich : sandwiches) {
			if(sandwich.getId()>maxId) {
				maxId = sandwich.getId();
			}
		}
		s.setId(++maxId);
		sandwiches.add(s);
	}
	
}
