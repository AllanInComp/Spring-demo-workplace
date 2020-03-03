package com.allanudemy.springannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Shows injection of values from property file by using @PropertySource in the Configuration file SportsConfiguration
 * the @Value annotations allows injection of value from the property file into the field 
 * @author Allan Yu
 *
 */
//Does not need @Component annotation since the SwimCoach class has its @Bean definition constructed in the SportConfiguration file
public class SwimCoach implements Coach {
	FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService happyFortuneService) {
		this.fortuneService = happyFortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Swim for 100 relays";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	

}
