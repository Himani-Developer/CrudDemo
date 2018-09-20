package com.niit.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//similar to dispatcher-servlet.xml file configuration

@Configuration
@EnableWebMvc //mvc-annotation-driven> tag in dispatcher-servlet.xml
@ComponentScan(basePackages= {"com.niit","crudDemoMiddleware"})
public class WebAppConfig extends WebMvcConfigurerAdapter{

	
	
}
