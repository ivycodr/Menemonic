package com.mnemonic.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	    

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        
    	
    	
    	auth.inMemoryAuthentication()
 	.passwordEncoder(new BCryptPasswordEncoder())
        .withUser("user1")
        .password("$2a$10$9B02FPqZCVEj37tzIrRenu/qs5RYN50z6FV/B.3GRpG.FTNbn7Jva")
        .authorities("ROLE_USER")
        .and()
        .withUser("jane")
        .password("$2a$10$9B02FPqZCVEj37tzIrRenu/qs5RYN50z6FV/B.3GRpG.FTNbn7Jva")
        .authorities("ROLE_DEVELOPER");
        
       
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	http.authorizeRequests()
        .antMatchers("/h2-console/**").permitAll();
        //.antMatchers("/swagger/**").permitAll()
        //.antMatchers("//swagger-resources/**").permitAll()
    	 //.antMatchers("/v2/api-docs/**").permitAll()
    	//.antMatchers("/configuration/**").permitAll()
    	//.antMatchers("/swagger-ui/**").permitAll();
    	
        //.anyRequest().authenticated();
    	
    	
    	
     	  http
      	  .csrf().disable()
            .authorizeRequests()
          
            .antMatchers(HttpMethod.OPTIONS,"/api/basicAuth/**").hasRole("DEVELOPER")
            .antMatchers("/api/basicAuth/**/").hasRole("DEVELOPER")
           
           
           
            .and()
            .httpBasic();
           
    	http
    	  
    	 
          .csrf().disable()
          .authorizeRequests()
          .antMatchers(HttpMethod.OPTIONS,"/api/v1/mnemonic/**").hasAnyRole("DEVELOPER")
          .antMatchers("/api/v1/mnemonic/**").hasRole("DEVELOPER")
         
          //.antMatchers("/api/v1/mnemonic/category/**").hasRole("DEVELOPER")
          //.antMatchers("/api/v1/mnemonic/phrases/**").hasRole("DEVELOPER")
         
          
        
          .and()
          .addFilter(new JWTAuthorizationFilter(authenticationManager()));
    	  
    	  http
    	  	
    	  	.headers().frameOptions().disable();
    	 
    	  
    	
   
    	  
  	
    	
          
      
        
       
    }

   
}