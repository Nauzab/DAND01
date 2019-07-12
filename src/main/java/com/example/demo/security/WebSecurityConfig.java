package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/firstpage", "/admin/authorizeAdmin", "/manager/managermain", "/manager/addmanager", "/manager/loginmanager",
                		"/runner/main", "/runner/runnerregister", "/runner/allrunners", "/runner/runnerlogin").permitAll() //Allows visit without authentication
                .anyRequest().anonymous()
                .anyRequest().authenticated()
                .and().headers().frameOptions().disable() //Allows localhost to connect to database 
                .and()
            .formLogin()//.defaultSuccessUrl("/Url", true) //if succesfull go to page 
                .loginPage("/firstpage")
                .permitAll() 
                .and()
             .logout()
                .permitAll();
    }
    


}