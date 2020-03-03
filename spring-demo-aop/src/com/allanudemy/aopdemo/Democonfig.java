package com.allanudemy.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Configuration file, scans package for compoenents to put in spring container
 * @author Allan Yu
 *
 */

@Configuration
@EnableAspectJAutoProxy //spring AOP proxy support 
@ComponentScan("com.allanudemy.aopdemo") //recurses to all subdirectories
public class Democonfig {
	
}
