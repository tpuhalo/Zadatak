package com.zadatak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("12345").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        .antMatchers("/home").hasRole("USER")
	        .and()
	        .formLogin()
	            .loginPage("/home")
	            .loginProcessingUrl("/contact")
	            .usernameParameter("username")
	            .defaultSuccessUrl("/home", true)
	        .and()
	        .logout()
	            .logoutUrl("/home")
	        .and()
	        .csrf().disable();

	        super.configure(http);
	    }
}