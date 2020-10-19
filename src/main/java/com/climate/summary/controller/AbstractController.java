package com.climate.summary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class will use to register any custom resource handlers
 * It can be also used to configure any view resolvers, etc
 * 
 * @author KhatriZ
 *
 */
@Controller
public class AbstractController implements WebMvcConfigurer {
	
	/**
	 * constant for the class path resources location
	 */
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/resources/",
			"classpath:/static/"};
	
	/**
	 * Register the resource handler configuration
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**").addResourceLocations(
					CLASSPATH_RESOURCE_LOCATIONS);
		}
	}

}
