package com.allanudemy.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.allanudemy.aopdemo.dao.AccountDAO;
import com.allanudemy.aopdemo.dao.MembershipDAO;
import com.allanudemy.aopdemo.dao.NotComponentDAO;

public class MainDemoApp {


	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (Democonfig.class);
		
		//get bean from spring container
		AccountDAO dao = context.getBean("accountDAO",AccountDAO.class);
		Account myAccount = new Account("Allan","Gold");
		
		//call business method
		dao.addAccount(myAccount);
		
		//call again to verify @Before function
		System.out.println("\nCalling again");
		dao.addAccount(myAccount);
		
		
		
		//test another class calling method with same addAccount() name method
		MembershipDAO mdao = context.getBean("membershipDAO",MembershipDAO.class);
		mdao.addAccount();
		
		//calls to getter and setter methods, need to exclude getters and setters from aspects
		dao.setName("foobar");
		dao.setServiceCode("silver");
		
		
		String name= dao.getName();
		String code= dao.getServiceCode();
		
		//dao that is not a component, but in the package, is calling its method
		//will not trigger aspects since Democonfig did not scan this class
		NotComponentDAO notCDao = new NotComponentDAO();
		notCDao.doSomething();
		
		//close context
		context.close();
	}

}
