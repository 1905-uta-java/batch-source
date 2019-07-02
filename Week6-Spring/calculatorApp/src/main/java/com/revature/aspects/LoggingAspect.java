package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning("within(com.revature.beans.*)")
	public void logAfter(JoinPoint jp) {
		log.info(jp.getSignature() + "was called");
	}
	
	//@AfterThrowing("within(com.revature.beans.*)")
	@AfterThrowing(pointcut="execution(* com.revature.beans.Calculator.*(..))",throwing = "ex")
	public void logAfterException(JoinPoint jp, Throwable ex) {
		log.info(jp.getSignature() + " threw " + ex);
	}
	
	@AfterReturning(pointcut="execution(* com.revature.beans.Calculator.*(..))", returning="returnedValue")
	public void logParamsAndResult(JoinPoint jp, Object returnedValue) {
		Object[] objArr = jp.getArgs();
		
//		for(Object o : objArr) {
//			System.out.println("Here is a parameter" + o);
//		}
//		System.out.println("Returned is : "+ returnedValue);
		String s = jp.toShortString().substring(21);
		switch(s) {
		case "add(..))":
			log.info(objArr[0] + " + " + objArr[1] + " = " + returnedValue);
			break;
		case "sub(..))":
			log.info(objArr[0] + " - " + objArr[1] + " = " + returnedValue);
			break;
		case "mult(..))":
			log.info(objArr[0] + " * " + objArr[1] + " = " + returnedValue);
			break;
		case "div(..))":
			log.info(objArr[0] + " / " + objArr[1] + " = " + returnedValue);
			break;
		default:
			log.info("Can't log execution, method does not exist");
		}
		//log.info(objArr[0] + " + " + objArr[1] + "= " + returnedValue);

	}
	
	
	
}
