/*package com.example.demo.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;	
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/cartest").permitAll() //Allows visit without authentication
                .anyRequest().authenticated()
                .and().csrf().ignoringAntMatchers("/h2-console/**") //Ignoring h2-console page
                .and().headers().frameOptions().disable() //Allows localhost to connect to database 
                .and()
            .formLogin()//.defaultSuccessUrl("/car/addnewcar", true) //if succesfull go to page 
                .loginPage("/login")
                .permitAll() 
                .and()
             .logout()
                .permitAll();
    }
    


}*/