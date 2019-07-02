package com.revature.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.calculate.Calculator;

public class Driver {
	
	public static void main(String[] arg) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator c1 = (Calculator) ac.getBean("calculator");
		
		
		
		System.out.println("3 + 7 =" + c1.add(3, 7));
		c1.subtract(3, 1);
		c1.multiply(3, 2);
		c1.divide(3, 3);
		c1.divide(3, 0);
		
		System.out.println();
	}
}
