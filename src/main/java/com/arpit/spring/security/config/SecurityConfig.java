package com.arpit.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import com.arpit.spring.security.filter.CORSFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("arpit").password("user")
				.roles("USER");
		auth.inMemoryAuthentication().withUser("arpit").password("admin")
				.roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class)
				.logout().logoutUrl("/logout").deleteCookies("JSESSIONID")
				.permitAll().and().csrf().and().authorizeRequests()
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").and()
				.formLogin();
	}
}
