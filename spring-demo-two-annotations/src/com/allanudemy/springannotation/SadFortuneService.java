package com.allanudemy.springannotation;

import org.springframework.stereotype.Component;

/**
 * Another implementation of FortuneService to show how @Qualifier annotation allow injection of specified object type
 * while the interface corresponding to the bean id is implemented by multiple classes

 * @author Allan Yu
 *
 */
@Component
public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is bad Fortune";
	}

}
