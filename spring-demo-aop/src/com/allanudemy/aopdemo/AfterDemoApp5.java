package com.allanudemy.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.allanudemy.aopdemo.dao.AccountDAO;

public class AfterDemoApp5 {
	
	public static void main(String []args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (Democonfig.class);
		
		//get bean from spring container
		AccountDAO dao = context.getBean("accountDAO",AccountDAO.class);
		
		System.out.println("\nMain program: AfterThrowingDemoApp3");
		
		List<Account> theAccounts = null;
		
		dao.findAccounts();
		
		context.close();
	}
}
