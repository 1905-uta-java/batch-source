package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.CoffeeMachine;

public class CoffeeMachineService {
	
	private List<CoffeeMachine> machines = new ArrayList<>();
	
	public CoffeeMachineService() {
		machines.add(new CoffeeMachine(1, true, true, 5));
		machines.add(new CoffeeMachine(2, false, false, 0));
		machines.add(new CoffeeMachine(3, true, false, 20));
		machines.add(new CoffeeMachine(4, false, true, 20));	
	}
	
	public List<CoffeeMachine> getCoffeeMachines(){
		return machines;
	}
	
	public void addCoffeeMachine(CoffeeMachine cm) {
		machines.add(cm);
	}

}
