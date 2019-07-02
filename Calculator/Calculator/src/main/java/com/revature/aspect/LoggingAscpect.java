package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAscpect {
	
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning("within(com.revature.beans.*)")
	public void methodSig(JoinPoint jp) {
		log.info(jp.getSignature());
	}
	
	@Around("within(com.revature.beans.Calculator*)")
	public Object arithLog(ProceedingJoinPoint pjp) throws Throwable {
		float n1 = (float) pjp.getArgs()[0];
		float n2 = (float) pjp.getArgs()[1];
		if(n2 == 0 && pjp.getSignature().toString().equals("float com.revature.beans.Calculator.divide(float,float)")) {
			log.error("Can't divide by zero");
		}else {
			Object val = pjp.proceed();
			switch(pjp.getSignature().toString()){
			case "float com.revature.beans.Calculator.divide(float,float)":
				log.info(n1+"/"+n2+"="+val);
				break;
			case "float com.revature.beans.Calculator.add(float,float)":
				log.info(n1+"+"+n2+"="+val);
				break;
			case "float com.revature.beans.Calculator.subtract(float,float)":
				log.info(n1+"-"+n2+"="+val);
				break;
			case "float com.revature.beans.Calculator.multiply(float,float)":
				log.info(n1+"*"+n2+"="+val);
				break;
			default:
				
			}
			
			return pjp.proceed();
		}
		return (Object) 0;
	}
	
}
