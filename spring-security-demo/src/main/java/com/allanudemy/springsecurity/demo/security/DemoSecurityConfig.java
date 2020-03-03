package com.allanudemy.springsecurity.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		System.out.println(getClass()+":configure(AuthenticationManagerBuilder auth)");

		//add users for in memory authentication 
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("EMPLOYEE","MANAGER"))
			.withUser(users.username("allan").password("test123").roles("EMPLOYEE","ADMIN"));
			
	}

	/**
	 * Maps the login page and processing of user/password to user specified parameters 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println(getClass()+":configure(HttpSecurity http)");
		http.authorizeRequests()
			.antMatchers("/").hasAnyRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasAnyRole("MANAGER") //leaders and all sub-directories (**) 
			.antMatchers("/system/**").hasAnyRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateUsers")
			.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
}
