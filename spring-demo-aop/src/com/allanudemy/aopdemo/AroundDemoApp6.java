package com.allanudemy.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.allanudemy.aopdemo.dao.AccountDAO;
import com.allanudemy.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp6 {
	
	public static void main(String []args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (Democonfig.class);
		
		//get bean from spring container
		AccountDAO dao = context.getBean("accountDAO",AccountDAO.class);
		
		System.out.println("\nMain program: AroundDemoApp6");
		
		//use Traffic
		TrafficFortuneService tfs = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("Calling getFortune");
		
		String data = tfs.getFortune();
		
		System.out.println("Fortune is: "+data);
		
		context.close();
	}
}
