/*package com.example.demo.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
    	//Adding four view to WebMvcConfigurer
        registry.addViewController("/cartest").setViewName("cartest");
        registry.addViewController("/").setViewName("cartest");
      registry.addViewController("/securitytest").setViewName("securitytest");
        registry.addViewController("/login").setViewName("login"); //will create later
    }



}*/