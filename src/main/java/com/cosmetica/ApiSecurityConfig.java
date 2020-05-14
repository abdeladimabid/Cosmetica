package com.cosmetica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cosmetica.authentication.RequestFilter;

@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailService;

	@Autowired
	private RequestFilter jwtrequestfilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests().antMatchers("/swagger-ui.html","/webjars/**","/v2/api-docs","/swagger-resources/**").permitAll().and()
		.authorizeRequests().antMatchers("/COSMETICA/authenticate").permitAll().and()
		.authorizeRequests().antMatchers("/COSMETICA/review/**").permitAll().and()
		.authorizeRequests().antMatchers("/COSMETICA/brand/**").permitAll().and()
		.authorizeRequests().antMatchers("/COSMETICA/category/**").permitAll().and()
		.authorizeRequests().antMatchers("/COSMETICA/product/**").permitAll().and()
		.authorizeRequests().antMatchers("/COSMETICA/coupon/**").permitAll().and()
		.authorizeRequests().antMatchers("/COSMETICA/image/**").permitAll().and()
		.authorizeRequests().antMatchers("/COSMETICA/user/**").permitAll().and()
		.authorizeRequests().antMatchers("/COSMETICA/superadmin/**").hasAnyAuthority("superadmin").and()
		.authorizeRequests().antMatchers("/COSMETICA/supervisor/**").hasAnyAuthority("superadmin","supervisor").and()
		.authorizeRequests().antMatchers("/COSMETICA/cart/**").hasAnyAuthority("superadmin","user").and()
		.authorizeRequests().antMatchers("/COSMETICA/client/**").hasAnyAuthority("superadmin","user").and()
		.authorizeRequests().antMatchers("/COSMETICA/order/**").hasAnyAuthority("superadmin").and()
		.authorizeRequests().antMatchers("/COSMETICA/role/**").hasAnyAuthority("superadmin").and()
		.authorizeRequests().antMatchers("/COSMETICA/tag/**").hasAnyAuthority("superadmin").and()
		.authorizeRequests().antMatchers("/COSMETICA/saller/**").hasAnyAuthority("superadmin","saller").and()
		.authorizeRequests().antMatchers("/COSMETICA/head/**").hasAnyAuthority("superadmin","user").and()
		.authorizeRequests().antMatchers("/COSMETICA/body/**").hasAnyAuthority("superadmin","user")
		
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(jwtrequestfilter, UsernamePasswordAuthenticationFilter.class);
		
		
	}
	
	
}

