package com.allanudemy.demo2driver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allanudemy.springannotation.Coach;
import com.allanudemy.springannotation.SportConfiguration;
import com.allanudemy.springannotation.SwimCoach;

public class AnnotationWithJavaConfigDemo {
	public static void main(String [] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfiguration.class);
		
		Coach coach = context.getBean("tennisCoach",Coach.class);
		System.out.println(coach.getDailyWorkOut());
		System.out.println(coach.getDailyFortune());

		SwimCoach coach1 = context.getBean("swimCoach",SwimCoach.class);

		System.out.println(coach1.getDailyWorkOut());
		System.out.println(coach1.getDailyFortune());
		System.out.println("coach1 info: "+coach1.getEmail()+", "+coach1.getTeam());
	}
}
