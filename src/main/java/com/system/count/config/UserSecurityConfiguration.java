package com.system.count.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(1)
public class UserSecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserDetailsService userDetailsServiceImpl;

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http
			.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/admin/dashboard/**").hasAnyRole("ADMIN")
			.antMatchers("/dashboard/**").hasRole("CLIENTE")
			.antMatchers("/").permitAll()
			.anyRequest()
			.authenticated().and().formLogin()
			.loginPage("/login").defaultSuccessUrl("/default", true).permitAll().and().logout().permitAll().and()
				.exceptionHandling();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**");
	}

	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
	}
	

}
