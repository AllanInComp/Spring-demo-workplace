package com.allanudemy.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.allanudemy.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {
	
	public static void main(String []args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (Democonfig.class);
		
		//get bean from spring container
		AccountDAO dao = context.getBean("accountDAO",AccountDAO.class);
		
		//call findAccount to verify @AfterReturning function
		List <Account>accounts = dao.findAccounts();
		
		for(Account a: accounts) {
			System.out.println(a);
		}
		
		context.close();
	}
}
