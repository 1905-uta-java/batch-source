package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class CalcDriver {
	static ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	static Calculator c = (Calculator) ac.getBean("calculator");
	public static void main(String args[]) {
		c.add(5, 5);
		c.subtract(8, 3);
		c.multiply(4, 5);
		c.divide(8, 2);
		c.divide(5, 0);
	}
}
