package com.allanudemy.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.allanudemy.aopdemo.Account;

@Aspect
@Component
@Order(1) //controls order of aspects, lower order = higher priority
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.allanudemy.aopdemo.dao.*.* (..))")
	private void forDaoPackage() {} //self defined method name
	
	//create pointcut for getter methods
	@Pointcut("execution(* com.allanudemy.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	//create pointcut for setter methods
	@Pointcut("execution(* com.allanudemy.aopdemo.dao.*.set*(..))")
	private void setter() {}

	//create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	//start with @Before 
	//@Before("execution(public void addAccount())")
	//@Before("execution(* add*(com.allanudemy.aopdemo.Account))") //specify param type as an object class 
	//@Before("forDaoPackageNoGetterSetter()")
	@Before("com.allanudemy.aopdemo.aspect.MyDemoLoggingAspect.forDaoPackageNoGetterSetter()") //can use fully qualified method name if want to specify in multiple aspects 
	//@Before ("execution(* com.allanudemy.aopdemo.dao.*.*(..))")
	//@Before("execution(public void add*())") //wildcard for anymethod beginning with 'add'
	//@Before("execution(public void com.allanudemy.aopdemo.dao.AccountDAO.addAccount())") //if want to specify class 
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
		//custom code s.a. logging, security ..
		System.out.println("\n========>>>Executing @Before advice on addAccount()");
		
		//display the method signature 
		MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: "+methoSig);
		
		//display method arguemtns
		Object [] args = theJoinPoint.getArgs();
		
		//loop through the args
		for(Object tempArg:args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("Account name: "+theAccount.getName());
				System.out.println("Account level: "+theAccount.getLevel());
			}
		}
		
	}
	
	
	
	@Before("forDaoPackageNoGetterSetter()")
	public void perfromApiAnaltics() {
		System.out.println("\n========>>>Performing API analytics");
	}
	
	
	/**
	 * returning = "result" will allocate the returning value to the argument parameter named result (the List<Account> result)
	 * @param theJoinPoint
	 * @param result
	 */
	@AfterReturning(pointcut="execution(* com.allanudemy.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//pring out which result we're advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("Executing @AfterReturning on method "+method);
		//print out the result of the method call
		System.out.println("\n======>>> result is :"+result);
		
		//Modify the result before it is retrieved by the calling program (AfterReturningDemoApp.java)
		if(!result.isEmpty()){
			Account tempAccount = result.get(0);
			tempAccount.setName("Daffy Duck"); //this will modify the result retrieved by the calling function 
		}
		
	}
	
	@AfterThrowing(pointcut="execution(* com.allanudemy.aopdemo.dao.AccountDAO.*(..))", throwing = "theExc") //specify where the exception is expected to be thrown
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){ //theExc specified in the @AfterThrowing parameters 
		System.out.println("Executing @AfterThrowing advice, the exception is "+theExc+"\n\tThe method is :"+theJoinPoint.getSignature());
	}
	
	/**
	 * Will execute before @AfterThrowing or @AfterReturning advices
	 * @param theJoinPoint
	 */
	@After("execution(* com.allanudemy.aopdemo.dao.AccountDAO.*(..))")
	public void afterFindAccountsAdvice(JoinPoint theJoinPoint) {
		System.out.println("Executing @After advice on method: "+theJoinPoint.getSignature().toShortString());
	}
	
	@Around("execution (* com.allanudemy.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		//print out method we're advising on
		System.out.println("\n=====>Executing @Around on method: "+theProceedingJoinPoint.getSignature().toShortString());
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//execute method
		Object result = theProceedingJoinPoint.proceed();
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute and display duration
		System.out.println("\tDuration: "+(end-begin)/1000.0+" seconds");
		
		return result;
	}
	
	@Around("execution (* com.allanudemy.aopdemo.service.*.getFortuneErr(..))")
	public Object aroundGetFortune2 (ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		Object result = null;
		
		try {
			//execute method
			result = theProceedingJoinPoint.proceed();
		}catch(Exception exc) {
			//log the exception
			myLogger.warning(exc.getMessage());
			
			//give the user custom message
			System.out.println("@Around advice aroundGetFortune2 threw execption: "+exc);
			result = "Major accident: modified by "+getClass();
		}
		return result;

	}

	
	
	
}
