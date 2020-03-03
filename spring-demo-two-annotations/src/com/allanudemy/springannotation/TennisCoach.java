package com.allanudemy.springannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Class showing annotated class (without using a Configuration Class such as SportConfiguration) allowing it to by instantiated by the spring
 * container by specifying bean id in the @Component ("*bean name*") annotation
 * on top of the TennisCoach class
 * 
 * FortuneService fortuneService:
 * using @Autowired on the class field, can 
 * 
 * Ctor:
 * Uses Constructor Autowiring to inject a FortuneService object into the ctor
 * of TennisCoach annotation @Autowired is no longer necessary if there is only
 * one constructor
 * 
 * setFortuneService
 * Uses setter Autowiring to inject a FortuneService object into the setter
 * dependency on a FortuneService object
 *  
 * customMethodNameToSetService
 * Shows that any method can be Autowired for DI by using the @Autowire annotation
 * 
 * If no bean name is specified, the default bean id would be the class name
 * with first character in lower case
 * 
 * shows how @Qualifier resolves no unique bean exception for multiple implementations of FortuneService Interface
 * 
 * @author Allan Yu
 *
 */
//requires @Component since a Coach class object is required instead of a TennisCoach object when retrieving the bean
@Component
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;

	/*
	 * @Autowired public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService=fortuneService; }
	 */
	@Override
	public String getDailyWorkOut() {
		return "TennisCoach: Swing Tennis Bat";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

//	/**
//	 * Can use @Autowired on setter as well for setter injection
//	 * 
//	 * @param fortuneService
//	 */
//	 @Autowired 
//	 @Qualifier("happyFortuneService")
//	 public void setFortuneService(FortuneService fortuneService) {
//	 this.fortuneService = fortuneService; }
		 

//	@Autowired
//	public void customMethodNameToSetService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//
//	}

}
