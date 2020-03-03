package com.allanudemy.springdemoxml;

public class BaseBallCoach implements Coach{
	
	//define a private field for dependency
	private FortuneService fortuneService;
	
	//define ctor for DI
	public BaseBallCoach(FortuneService fortuneService) {
		System.out.println("Inside ctor for BaseBallCoach");
		this.fortuneService=fortuneService;
	}
	
	public String getDailyWorkOut() {
		return "Batting practice by BaseBallCoach";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
