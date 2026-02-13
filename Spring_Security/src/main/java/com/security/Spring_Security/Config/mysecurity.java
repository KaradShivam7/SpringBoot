package com.security.Spring_Security.Config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableAutoConfiguration
@Configuration
public class mysecurity {
	
	private myuserdetailservice usd;
	
	public mysecurity(myuserdetailservice usd) {
		this.usd=usd;
	}
	
	@Bean
	public SecurityFilterChain Mysecure(HttpSecurity http) {
			 return  http.csrf((i)->{i.disable();})
			 .authorizeHttpRequests((req)->{
				 req.requestMatchers(HttpMethod.POST).permitAll()
				 .requestMatchers(HttpMethod.GET).hasAnyAuthority("ADMIN")
				 .anyRequest().authenticated();
			 }).httpBasic((i)->{})
			 .build(); 
		 }
	
	
	@Bean
	public DaoAuthenticationProvider myauth() {
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider(usd); 
			
			provider.setPasswordEncoder(new BCryptPasswordEncoder(5));
			
			return provider;
			
		
	}
}

