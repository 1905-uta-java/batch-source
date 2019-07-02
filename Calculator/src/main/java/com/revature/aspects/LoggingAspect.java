package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	@Before("within(com.revature.calculate.Calculator)")
	public void logMethod(JoinPoint jp) {
		log.info(jp.getSignature());
	}
	
	@AfterReturning(pointcut= "execution(float add(float, float))", returning = "returnVal")
	public void logAdd(JoinPoint jp, Object returnVal) {
		log.info(jp.getArgs()[0] + " + " + jp.getArgs()[1] + " = " + returnVal);
	}
	
	@AfterReturning(pointcut= "execution(float subtract(float, float))", returning = "returnVal")
	public void logSubtract(JoinPoint jp, Object returnVal) {
		log.info(jp.getArgs()[0] + " - " + jp.getArgs()[1] + " = " + returnVal);
	}
	
	@AfterReturning(pointcut= "execution(float multiply(float, float))", returning = "returnVal")
	public void logMultiply(JoinPoint jp, Object returnVal) {
		log.info(jp.getArgs()[0] + " * " + jp.getArgs()[1] + " = " + returnVal);
	}
	
	@AfterReturning(pointcut= "execution(float divide(float, float))", returning = "returnVal")
	public void logDivide(JoinPoint jp, Object returnVal) {
		log.info(jp.getArgs()[0] + " / " + jp.getArgs()[1] + " = " + returnVal);
	}
	
	@Around("execution(float divide(float, float))")
	public float preventZero(ProceedingJoinPoint jp) throws Throwable {
		
		if(jp.getArgs()[1] instanceof Float && (Float) jp.getArgs()[1] == 0) {
			log.error("Tried to divide by 0");
		}
		else {
			return (Float) jp.proceed();
		}
		return 0;
	}

}
