package com.allanudemy.demo2driver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allanudemy.springannotation.Coach;

public class AnnotationDemoAoo {

	public static void main(String[] args) {

		//read spring config file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		
		//get bean from spring container
		Coach coach = context.getBean("tennisCoach",Coach.class);
		
		//call method on bean
		System.out.println(coach.getDailyWorkOut());
		System.out.println(coach.getDailyFortune());

		//get bean from spring containing
		Coach coach1 = context.getBean("badmintonCoach",Coach.class);
		Coach coach2 = context.getBean("badmintonCoach",Coach.class);

		//call method on bean
		System.out.println(coach1.getDailyWorkOut());
		System.out.println(coach1.getDailyFortune());
		System.out.println("coach1: "+coach1+"\tcoach2: "+coach2);
		
		
		//close context
		context.close();
		
	}

}
