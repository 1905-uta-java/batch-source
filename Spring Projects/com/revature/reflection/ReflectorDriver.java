
package com.revature.reflecton.ReflectorDriver;

public class ReflectorDriver {

	public static void main(String[] args) {
		//try {

			Class<?> c1 = Class.forName("com.revature.model.Cat");
			System.out.println("Class:" + c1.getName());
			System.out.println("Superclass: " + c1.getSuperclass());
			System.out.println("Superclass of superclass: " + c1.getSuperclass().getSuperclass());
			
			Class<?>[] interface = c1.getInterfaces();
			for(Class<?> inter : interface)
				System.out.println(inter);
		//}
		
		//catch (ClassNotFoundException e) {
		//	e.printStackTrace();
		//}
			
			System.out.println("methods");
			Method[] methods = c1.getDeclairedMethods();
			//program is broken, fix later??

	}

}
