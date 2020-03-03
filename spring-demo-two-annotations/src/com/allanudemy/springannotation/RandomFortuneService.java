package com.allanudemy.springannotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RandomFortuneService implements FortuneService {
	Vector<String> fortunes = new Vector<>();
	
	@Override
	public String getFortune() {
		Scanner sc;
		try {
			sc = new Scanner (new File("C:\\eclipse\\workspace\\spring-demo-two-annotations\\src\\fortunes.txt"));
			while(sc.hasNextLine()) {
				fortunes.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: fortunes");
		}
		
		Random rand = new Random();
		return fortunes.get(rand.nextInt(fortunes.size()));
	}

}
