package com.allanudemy.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Aspect
@Component
@Order(1)
public class CRMLoggingAspect {
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.allanudemy.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//do the same for service and dao
	@Pointcut("execution(* com.allanudemy.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.allanudemy.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>> in @Before: calling method: "+theMethod);
		
		//display the arguements to the method
		
		//get the arguments
		Object [] args = theJoinPoint.getArgs();
		
		//loop through and display args
		for (Object obj:args) {
			myLogger.info("\t==> argument: "+ obj);
		}
		
	}
	
	//add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()",returning ="theResult")
	public void after(JoinPoint theJoinPoint,Object theResult) {
		//display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>> in @AfterReturn: from method: "+theMethod);
		
		//display data returned
		myLogger.info("======>Result: "+theResult);
		
	}
	
	
	
	
}
