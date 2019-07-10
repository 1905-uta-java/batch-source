package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;

public class Driver {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Bear b = (Bear) ac.getBean("bear");
		System.out.println("Bear is full:" + b.isFull());
		System.out.println("Bear is awake:" + b.isAwake());
		Bear.setWinter(true);
		b.setFull(true);
		b.bearHibernates();
		b.wakeBear();
		System.out.println(b);
		
	}

}
