package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator c = (Calculator) ac.getBean("calculator");
		c.add(1,2);
		c.sub(1,2);
		c.mult(1,2);
		c.div(4,2);
		c.div(1,0);

	}

}
