package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.BearWithAutomagic;
import com.revature.beans.BearWithAutowiring;
import com.revature.beans.BearWithConstructor;
import com.revature.beans.BearWithSetter;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BearWithConstructor b1 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		System.out.println(b1);
		
		BearWithSetter b2 = (BearWithSetter) ac.getBean("bearWithSetter");
		System.out.println(b2);
		
		BearWithAutowiring b3 = (BearWithAutowiring) ac.getBean("bearWithAutowiring");
		System.out.println(b3);
		
		BearWithAutomagic b4 = (BearWithAutomagic) ac.getBean("bearWithAutomagic");
		System.out.println(b4);
	}

}
