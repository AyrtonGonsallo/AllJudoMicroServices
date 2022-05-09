package com.test.microservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.formLogin();//activer un formulaire d'authentifcation seulement pour statefull
		//http.authorizeRequests().anyRequest().permitAll();//aucune requette ne necessite une authentification prealable
		//je ne peux pas envoyer de requette post 
		http.csrf().disable();// spring security ne va pas generer le synchronizer token pour le placer dans la session utiliser le en cas de stateless
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().frameOptions().disable(); //desactiver la protection contre les frames pour un site qui les utilise
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/users/**").hasAnyAuthority("Super_Admin");
		http.authorizeRequests().anyRequest().authenticated();//toutes les requettes necessitent une authentifiation

		//installer le filtre qui va traiter le formulaire
		http.addFilterBefore(new JwtAutorisationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override @Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
}
