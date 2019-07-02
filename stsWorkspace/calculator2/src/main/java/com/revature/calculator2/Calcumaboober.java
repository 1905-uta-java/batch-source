package com.revature.calculator2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Calcumaboober {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator c = (Calculator) ac.getBean("calculator");
		
		System.out.println(c.add(1, 2));
		System.out.println(c.subtract(4, 1));
		System.out.println(c.multiply(3, 3));
		System.out.println(c.division(6, 2));
		System.out.println(c.division(6, 0));

	}

}
