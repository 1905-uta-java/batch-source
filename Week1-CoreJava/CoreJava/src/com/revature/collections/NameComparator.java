package com.revature.collections;

import java.util.Comparator;

public class NameComparator implements Comparator<RaceHorse> {

	@Override
	public int compare(RaceHorse rh1, RaceHorse rh2) {
		return rh1.getName().compareTo(rh2.getName());
	}

}
