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
		// TODO Auto-generated method stub
		return null;
	}

	//maps servlet configuration class (similar to servlet.xml)
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{DemoAppConfig.class};
	}

	//maps servlet dispatcher 
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String [] {"/"};
	}
	
}
