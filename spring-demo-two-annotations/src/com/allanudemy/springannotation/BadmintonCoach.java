package com.allanudemy.springannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Desmonstrates uses for @Component, @Scope, @Autowired, @Qualifier
 * @author Allan Yu
 *
 */
@Component
@Scope
public class BadmintonCoach implements Coach{
	@Autowired
	@Qualifier("randomFortuneService")
	FortuneService fortuneService;

	
	@PostConstruct
	public void born() {
		System.out.println("A badminton coach with address:"+this.toString()+" is constructed");
	}
	
	/**
	 * PreDestroy methods won't be called if the scope of the bean object is prototype
	 */
	@PreDestroy
	public void death() {
		System.out.println("A badminton coach with address:"+this.toString()+" is destroyed");
	}
	
	
	@Override
	public String getDailyWorkOut() {
		return "Hit the shuttle 1000 times";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
