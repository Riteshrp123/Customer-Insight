package com.xworkz.customerinsigt.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.xworkz.customerinsigt.config.BeanConfiguration;

public class FrontControllerConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	public FrontControllerConfig() {
		System.out.println("created "+this.getClass().getSimpleName());
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {BeanConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {BeanConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
