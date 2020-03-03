package com.allanudemy.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Substitubes web.xml
 * @author Allan Yu
 *
 */
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println(getClass()+": getRootConfigClasses()");

		// TODO Auto-generated method stub
		return null;
	}

	//maps servlet configuration class (similar to servlet.xml)
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println(getClass()+": getServletConfigClasses()");
		return new Class[]{DemoAppConfig.class};
	}

	//maps servlet dispatcher 
	@Override
	protected String[] getServletMappings() {
		System.out.println(getClass()+": getServletMappings()");
		// TODO Auto-generated method stub
		return new String [] {"/"};
	}
	
}
