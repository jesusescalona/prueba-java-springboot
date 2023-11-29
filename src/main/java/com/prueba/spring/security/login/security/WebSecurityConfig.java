package com.prueba.spring.security.login.security;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;


import com.prueba.spring.security.login.security.jwt.AuthTokenFilter;
import com.prueba.spring.security.login.security.services.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {
  
  @Value("${spring.h2.console.path}")
  private String h2ConsolePath;
  
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Bean
  AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  @Bean
  DaoAuthenticationProvider authenticationProvider() {
	  
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
  }
 
  @Bean
  AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @SuppressWarnings({ "removal", "deprecation" })
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
          .headers(headers -> headers.frameOptions().disable())
          .csrf(csrf -> csrf.disable()).authorizeRequests(
          requests -> requests
          .requestMatchers("/doc/swagger-ui").permitAll()
          .requestMatchers("/api/auth/**").permitAll()
          .requestMatchers("/api/test/**").permitAll()
          .requestMatchers("/h2/**").permitAll()
          //.anyRequest().authenticated()
          )
          .authenticationProvider(authenticationProvider())
          .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

      return http.build();
		
	}
}
