package com.revature.project0.util;

public class MathUtil {
	
	private static final double APPROX_PRECISION = 0.001;
	
	public static boolean approxEqual(double a, double b) {
		
		return Math.abs(a - b) < APPROX_PRECISION;
	}
}
