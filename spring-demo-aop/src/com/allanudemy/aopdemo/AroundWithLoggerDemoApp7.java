package com.allanudemy.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.allanudemy.aopdemo.dao.AccountDAO;
import com.allanudemy.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp7 {
	
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp7.class.getName());
	
	public static void main(String []args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (Democonfig.class);
		
		//get bean from spring container
		AccountDAO dao = context.getBean("accountDAO",AccountDAO.class);
		
		myLogger.info("\nMain program: AroundDemoApp6");
		
		//use Traffic
		TrafficFortuneService tfs = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("Calling getFortune");
		
		String data = tfs.getFortune();
		
		myLogger.info("Fortune is: "+data);
		
		context.close();
	}
}
