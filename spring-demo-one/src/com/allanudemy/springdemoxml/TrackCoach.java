package com.allanudemy.springdemoxml;

public class TrackCoach implements Coach {
	public FortuneService fortuneService;
	
	/*
	 * public TrackCoach(FortuneService fortuneService) { this.fortuneService =
	 * fortuneService; }
	 */

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside fortune setter for TrackCoach");
		this.fortuneService = fortuneService;
	}


	public FortuneService getFortuneService() {
		return fortuneService;
	}


	@Override
	public String getDailyWorkOut() {
		return "Running drill by TrackCoach";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	/**
	 * add an init method
	 */
	public void doMyStarupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	/**
	 * add a destroy method
	 */
	public void doMyEndStuff() {
		System.out.println("TrackCoach: inside method doMyEndStuff");
	}

}
