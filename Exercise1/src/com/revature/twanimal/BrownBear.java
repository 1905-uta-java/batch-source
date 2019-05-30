package com.revature.twanimal;

public class BrownBear extends Bear {

	// Brown Bear's fur color is brown, and is set as such when created.
		public BrownBear() {
			setFurColor("Brown");
		}
		
		// Brown Bear's home is a cave.
		@Override
		public void findHome() {
			System.out.println("Returned to cave.");
		}

		// Brown bear will eat any food items nearby.
		

}
