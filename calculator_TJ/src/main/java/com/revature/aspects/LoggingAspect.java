package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private static Logger l = Logger.getRootLogger();
	
	@AfterReturning("within(com.revature.beans.*)")
	public void LogMethod(JoinPoint jp) {
		l.info(jp.getSignature() + ": ");
	}
	
	@AfterReturning(pointcut = "execution(int add(int, int))", returning="total")
	public void LogAdd(JoinPoint jp, int total) {
		Object[] nums = jp.getArgs();
		l.info(nums[0] + " + " + nums[1] + " = " + total);
	}
	@AfterReturning(pointcut = "execution(int subtract(int, int))", returning="total")
	public void LogSub(JoinPoint jp, int total) {
		Object[] nums = jp.getArgs();
		l.info(nums[0] + " - " + nums[1] + " = " + total);
	}
	@AfterReturning(pointcut = "execution(int multiply(int, int))", returning="total")
	public void LogMult(JoinPoint jp, int total) {
		Object[] nums = jp.getArgs();
		l.info(nums[0] + " * " + nums[1] + " = " + total);
	}
	@AfterReturning(pointcut = "execution(int divide(int, int))", returning="total")
	public void LogDiv(JoinPoint jp, int total) {
		Object[] nums = jp.getArgs();
		l.info(nums[0] + " / " + nums[1] + " = " + total);
	}
	@AfterThrowing(pointcut = "execution(int divide(int, int))")
	public void LogDivZero(JoinPoint jp) {
		l.error("Divided by zero.");
	}
}