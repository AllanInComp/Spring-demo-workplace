package com.allan.springtest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarFactory {
	
	public Car getCar(String type) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("car_spring.xml");
		switch (type) {
			case "RaceCar": return (RaceCar)context.getBean("RaceCar");
			case "Van": return (Van) context.getBean("Van");
			
			default: return null;
		}
	}
}
