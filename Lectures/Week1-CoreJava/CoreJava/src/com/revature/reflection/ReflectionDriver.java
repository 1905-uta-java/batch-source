package com.revature.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.revature.models.Cat;

public class ReflectionDriver {
	
	
	public static void main(String[] args) {
		
		try {
			Class<?> c1 = Class.forName("com.revature.models.Cat");
			System.out.println("Class: "+c1.getName());
			System.out.println("Superclass: "+c1.getSuperclass());
			System.out.println("Superclass of superclass: "+c1.getSuperclass().getSuperclass());
			
			// get interface implemented by Cat class
			Class<?>[] interfaces = c1.getInterfaces();
			for(Class<?> inter : interfaces) {
				System.out.println(inter);
			}
			System.out.println();
			
			// access methods within a class
			System.out.println("methods:");
			Method[] methods = c1.getDeclaredMethods();
			for(Method m : methods) {
				System.out.println(m.toString());
			}
			System.out.println();
			
			// access fields within a class
			System.out.println("fields:");
			Field[] fields = c1.getDeclaredFields();
			for(Field f: fields) {
				System.out.println(f);
			}
			System.out.println();
			
			System.out.println("fields from super:");
			Field[] superFields = c1.getSuperclass().getDeclaredFields();
			for(Field f: superFields) {
				System.out.println(f);
			}
			System.out.println();
			
			// we can create an instance of Cat class and modify it using fields/methods
			Cat cat = (Cat) c1.newInstance();
			System.out.println(cat);
			
			Field whiskerField = c1.getDeclaredField("numOfWhiskers");
			whiskerField.setAccessible(true);
			whiskerField.set(cat, 20);
			whiskerField.setAccessible(false);
			System.out.println(cat);
			
			Method setWhiskersMethod = c1.getDeclaredMethod("setNumOfWhiskers", int.class);
			setWhiskersMethod.invoke(cat, 15);
			System.out.println(cat);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
