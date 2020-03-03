package com.allanudemy.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.allanudemy.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp3 {
	
	public static void main(String []args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (Democonfig.class);
		
		//get bean from spring container
		AccountDAO dao = context.getBean("accountDAO",AccountDAO.class);
		
		System.out.println("\nMain program: AfterThrowingDemoApp3");
		
		List<Account> theAccounts = null;
		
		try {
			boolean tripWire = true;
			theAccounts = dao.findErrorAccounts(tripWire);
			
		}catch(Exception exc) {
			System.out.println("\n\nMain program: caught exception: "+exc);
		}
		
		context.close();
	}
}
