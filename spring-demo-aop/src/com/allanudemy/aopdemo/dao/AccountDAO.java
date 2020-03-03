package com.allanudemy.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.allanudemy.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount) {
		System.out.println(getClass()+ ": Adding an Account");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": Doing work");
		return false;
	}
	
	//getters and setters necessary for calling advice

	public String getName() {
		System.out.println(getClass()+": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	/**
	 * to call also a @AfterReturn method
	 * @return list of Account objects 
	 */
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		
		Account a1 = new Account("John","Silver");
		Account a2 = new Account("Madison","Platinum");
		Account a3 = new Account("Luca","Gold");
		
		myAccounts.add(a1);
		myAccounts.add(a2);
		myAccounts.add(a3);
		
		return myAccounts;
	}

	/**
	 * Simulates throwing an exception to test @AfterThrowing advice 
	 * @return
	 */
	public List<Account> findErrorAccounts(boolean trip) {
		//simulate an exception
		if(trip) {
			throw new RuntimeException("No accounts for you!");
		}
		return null;
	}
	
}
