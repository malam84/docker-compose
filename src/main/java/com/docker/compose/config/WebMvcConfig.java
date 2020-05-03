package com.docker.compose.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 
 * @author    Alam    
 * @2020
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

   
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
 
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/dashboard").setViewName("dashboard");
    }
}
