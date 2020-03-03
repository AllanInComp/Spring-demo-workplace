package com.allanudemy.demo_drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allanudemy.springdemoxml.Coach;
import com.allanudemy.springdemoxml.CricketCoach;

public class DIDemoApp {
	public static void main(String[]args) {
		//load spring config file
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("Container created, objects instantiatedg\n");
		
		//retrieve bean from spring container
		Coach coach = context.getBean("myBCoach",Coach.class);
		//call methods from bean
		System.out.println(coach.getDailyWorkOut());
		//call new method for fortunes
		System.out.println(coach.getDailyFortune());
		
		System.out.println();
		
		coach = context.getBean("myBCoach",Coach.class);
		//call methods from bean
		System.out.println(coach.getDailyWorkOut());
		//call new method for fortunes
		System.out.println(coach.getDailyFortune());
		
		
		CricketCoach ccoach = context.getBean("myCCoach",CricketCoach.class);
		//call methods from bean
		System.out.println(ccoach.getDailyWorkOut());
		//call new method for fortunes
		System.out.println(ccoach.getDailyFortune());
		//call new method for coach email and team
		System.out.println("Coach info"+ccoach.getTeam()+" email:"+ccoach.getEmail_address());
		
		CricketCoach ccoach2 = context.getBean("myCCoach2",CricketCoach.class);
		//call methods from bean
		System.out.println(ccoach2.getDailyWorkOut());
		//call new method for fortunes
		System.out.println(ccoach2.getDailyFortune());
		//call new method for coach email and team
		System.out.println("Coach info"+ccoach2.getTeam()+" email:"+ccoach2.getEmail_address());
		
		//close context
		((AbstractApplicationContext) context).close();
	}
}
