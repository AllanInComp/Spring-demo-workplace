package com.allanudemy.demo_drivers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allanudemy.springdemoxml.Coach;

public class BeanScopeDemo {
	public static void main(String[]args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scoped_spring.xml");
		
		Coach coach1 = context.getBean("myCoach",Coach.class);
		
		Coach coach2 = context.getBean("myCoach",Coach.class);
		
		
		boolean result = coach1==coach2;
		
		System.out.println("Same object: "+result);
		System.out.println("Memory Address for coach 1: "+coach1);
		System.out.println("Memory Address for coach 2: "+coach2);
		
		context.close();

	}
}
