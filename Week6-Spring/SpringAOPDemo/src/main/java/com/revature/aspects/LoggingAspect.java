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
	
	private static Logger log = Logger.getRootLogger();
	// create advice to be injected in our application methods to handling the cross cutting concern of logging
	
	@AfterReturning("within(com.revature.beans.*)")
	public void logAfter(JoinPoint jp) {
		log.info(jp.getSignature()+" was called");
	}
	
	@AfterThrowing("within(com.revature.beans.Bear)")
	public void logAfterException(JoinPoint jp) {
		log.error(jp.getSignature()+ " threw an exception");
	}
	
	@After("execution(void bearHibernates())")
	public void logWithHibernate() {
		log.info("bear attempted to hibernate");
	}
	
	@After("execution(void set*(..))")
	public void logSetters(JoinPoint jp) {
		log.info("setter called "+ "("+jp.getSignature().getName()+")");
	}

}
