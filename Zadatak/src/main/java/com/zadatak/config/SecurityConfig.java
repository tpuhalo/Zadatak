package com.zadatak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Method for adding username and password in memory.
	 * 
	 * @param auth
	 * @throws Exception
	 */

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = passwordEncoder();
		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("12345")).roles("USER");
	}

	/**
	 * Password encoder.
	 * 
	 * @return BCryptPasswordEncoder
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Method for configuration of access parameters for spring security.
	 * 
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/contact").access("hasRole('ROLE_USER')").antMatchers("/address")
				.access("hasRole('ROLE_USER')").antMatchers("/city").access("hasRole('ROLE_USER')")
				.antMatchers("/country").access("hasRole('ROLE_USER')").and().formLogin().loginPage("/login")
				.failureUrl("/login?error").usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/contact").and().logout().logoutSuccessUrl("/login").and().csrf();
	}
}