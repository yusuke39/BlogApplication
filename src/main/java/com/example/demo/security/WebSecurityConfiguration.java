package com.example.demo.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsService;


    @Bean
    CorsConfigurationSource corsConfigurationSource(){
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.setAllowedOrigins(Arrays.asList("http://localhost:8081"));
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", config);
      return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .cors()
        .and()
        .csrf()
        .ignoringAntMatchers("/login", "/user/**")
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .and()
        .authorizeRequests()
        .antMatchers("/**").permitAll()
        .and()
        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    // @Override
    // public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth
    //       .inMemoryAuthentication()
    //       .withUser("admin").password("{noop}password").authorities("USER", "ADMIN")
    //       .and()
    //       .withUser("user").password("{noop}password").authorities("USER");
    // }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
  
        auth
          .userDetailsService(userDetailsService)
          .passwordEncoder(bCryptPasswordEncoder());
    }

    // @Configuration
    // protected static class AuthenticationConfiguration
    // extends GlobalAuthenticationConfigurerAdapter {
    //     @Autowired
    //     UserDetailsService userDetailsService;

    //     @Override
    //     public void init(AuthenticationManagerBuilder auth) throws Exception {
    //         // 認証するユーザーを設定する
    //         auth.userDetailsService(userDetailsService)
    //         // 入力値をbcryptでハッシュ化した値でパスワード認証を行う
    //         .passwordEncoder(new BCryptPasswordEncoder());

    //     }
    // }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}