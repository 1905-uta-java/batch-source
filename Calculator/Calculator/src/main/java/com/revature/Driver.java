package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Calculator c = (Calculator) ac.getBean("calculator");
		
		c.add(15, 12);
		c.subtract(10, 7);
		c.multiply(5, 3);
		c.divide(10, 2);
		c.divide(10, 0);
	}

}
