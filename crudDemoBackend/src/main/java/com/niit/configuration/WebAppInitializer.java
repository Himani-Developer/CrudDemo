package com.niit.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// create beans for Datasource, session factory, HibernateTransaction Manager
		return new Class[] {DBConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// enable web-mvc, handler mapping,scan all the components in the base package "com.niit"
		return new Class[] {WebAppConfig.class};
	}

	
	//forward all the incoming requests to DispatcherServlet by specifying the url pattern as "/"
	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"}; //url pattern in web.xml for the servlet dispatcher
	}

}
