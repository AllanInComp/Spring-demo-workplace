package com.allanudemy.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune() {
		
		//simlate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Expect heavy traffic this morning";
	}
	
	public String getFortuneErr() {
		
		throw new RuntimeException ("Fortune exception thrown");
		
	}

}
