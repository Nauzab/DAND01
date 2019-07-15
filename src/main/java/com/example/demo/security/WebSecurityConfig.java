package com.example.demo.security;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;



import com.example.demo.model.CustomUserDetailsService;
import com.example.demo.repo.AdministratorRepo;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AdministratorRepo adminRepo;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
               	.antMatchers("/**", "/firstpage", "/admin/authorizeAdmin", "/manager/managermain", "/manager/addmanager", "/manager/loginmanager",
                		"/runner/main", "/runner/runnerregister", "/runner/allrunners", "/runner/runnerlogin").permitAll() //Allows visit without authentication
                .antMatchers("/admin/**").hasRole("Admin")
                .anyRequest().anonymous()
                
                .and().headers().frameOptions().disable() //Allows localhost to connect to database 
                .and()
            .formLogin()//.defaultSuccessUrl("/Url", true) //if succesfull go to page 
                .loginPage("/admin/authorizeAdmin").usernameParameter("username").passwordParameter("password").permitAll()
                .defaultSuccessUrl("/admin/adminmain")
                .failureForwardUrl("/firstpage")
                .permitAll() 
                .and()
             .logout()
                .permitAll();
        	
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        
    	return new CustomUserDetailsService();
    	    
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }
    


}*/