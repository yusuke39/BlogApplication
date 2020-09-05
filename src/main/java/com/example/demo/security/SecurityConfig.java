// package com.example.demo.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// @EnableWebSecurity
// @Configuration
// public class SecurityConfig extends WebSecurityConfigurerAdapter {


//   @Autowired
//   UserSecurityService userSecurityService;
  

//   @Override
//   protected void configure(HttpSecurity http) throws Exception{

//         http
//           .cors()
//           .and()
//           .authorizeRequests()
//           .antMatchers("/**/**").permitAll()
//           .anyRequest().authenticated()
//           .and().logout()
//           .and().csrf().disable()
//           .addFilter(new JWTAuthenticationFilter(authenticationManager(), bCryptPasswordEncoder()))
//           .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//           .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//   }

//   @Autowired
//   public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
//       auth
//         .userDetailsService(userSecurityService)
//         .passwordEncoder(bCryptPasswordEncoder());
//   }


//   @Bean
//   public BCryptPasswordEncoder bCryptPasswordEncoder() {
//       return new BCryptPasswordEncoder();
//   }

// }