package com.allanudemy.demo_drivers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allanudemy.springdemoxml.Coach;

/**
 * Shows how spring lifecycle
 * @author Allan Yu
 *
 */
public class BeanLifeCycleDemo {
	public static void main(String[]args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_life_spring.xml");
		
		Coach coach = context.getBean("myCoach",Coach.class);
		
		System.out.println(coach.getDailyFortune());
		
		context.close();

	}
}
