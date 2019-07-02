package com.revature.calculator2;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingSteveCalc {
	
	private static Logger log = Logger.getRootLogger();
	
	
	@AfterReturning("within(com.revature.calculator2.*)")
	public void logAfter(JoinPoint jp) {
		log.info(jp.getSignature() + " was called upon.");
		System.out.println("hello");
	}

	@AfterReturning(pointcut = "execution(double *(..))", returning = "value")
	public void logAfterArithmetic(JoinPoint jp, Object value) {
		String method = jp.getSignature().getName();
		System.out.println(method);
		switch(method) {
		case "add":
			log.info(jp.getArgs()[0] + " + " + jp.getArgs()[1] + "=" + value);
			System.out.println("Hello!");
			break;
		case "subtract":
			log.info(jp.getArgs()[0] + " - " + jp.getArgs()[1] + "=" + value);
			break;
		case "multiply":
			log.info(jp.getArgs()[0] + " * " + jp.getArgs()[1] + "=" + value);
			break;
		case "divide":
			log.info(jp.getArgs()[0] + " / " + jp.getArgs()[1] + "=" + value);
			break;
		default:
			break;
		}
	}
	
	@AfterThrowing("within(com.revature.calculator2.*)")
	public void logAfterException(JoinPoint jp) {
		log.error(jp.getSignature() + " threw an exception. Cannot divide by 0.");
	}
	
}
