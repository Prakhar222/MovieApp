package com.yash.mba.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{

@Override
protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	.antMatchers("/movie/movies/{movie_id}").hasAuthority("ADMIN")//movie delete by id
	.antMatchers("/movie/update/{movie_id}").hasAnyAuthority("USER","CREATOR","ADMIN")//update movie by id
	.antMatchers("/movie/save").hasAnyAuthority("ADMIN")
	.antMatchers("/auditorium/auditoriums").hasAnyAuthority("USER","CREATOR","ADMIN")
	.antMatchers("/auditorium/save").hasAuthority("ADMIN")
	.antMatchers("/customer/**").hasAnyAuthority("USER","CREATOR","ADMIN")
	.antMatchers("/screening/**").hasAnyAuthority("USER", "CREATOR","ADMIN")
	.antMatchers("/theatre/theatres").hasAuthority("ADMIN")
	.antMatchers("/theatre/save").hasAuthority("ADMIN")
	.antMatchers("/theatre/update/{theatre_id}").hasAnyAuthority("ADMIN","CREATOR")
	.antMatchers("/theatre/delete/{theatre_id}").hasAuthority("ADMIN")	.anyRequest().permitAll()
	.and()
	.formLogin();
}
@Override
public void configure(WebSecurity web) throws Exception {
web.ignoring().antMatchers("/**");
}
}
