package com.allanudemy.springdemoxml;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String email_address;
	private String team;
	
	
	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		System.out.println("inside setter for CricketCoach email_address");
		this.email_address = email_address;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("inside setter for CricketCoach team");
		this.team = team;
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Swing some Crickets";
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


}
