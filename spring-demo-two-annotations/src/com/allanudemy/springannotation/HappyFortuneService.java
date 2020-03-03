package com.allanudemy.springannotation;

import org.springframework.stereotype.Component;

/**
 * Example of autowired implementing class ofr FortuneService
 * @author Allan Yu
 *
 */
@Component 
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is good Fortune";
	}

}
