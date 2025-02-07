package com.allanudemy.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.allanudemy.springsecurity.demo")
public class DemoAppConfig {
	
	//allows specification of front end html files as a Bean
	@Bean 
	public ViewResolver viewResolver() {
		System.out.println(getClass()+": viewResolver()");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
				
		return viewResolver;
		
	}
}
