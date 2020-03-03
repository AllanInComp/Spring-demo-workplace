package com.allanudemy.springdemoxml;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	final String [] fortunes = {"Happy Fortune","Glorious Fortune","Great Fortune","Incredible Fortune","Wonderful Fortune"};
	
	@Override
	public String getFortune() {
		Random random = new Random();
		return fortunes[random.nextInt(fortunes.length)];
	}

}
