package com.allanudemy.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass()+": Adding an Account");
	}
	
	public boolean addSillyMember() {
		System.out.println(getClass()+": Adding a silly member");
		return true;
	}
}
