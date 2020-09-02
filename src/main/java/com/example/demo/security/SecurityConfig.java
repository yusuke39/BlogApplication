package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserSecurityService UserSecurityService;

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  /**
  * 静的ファイルに認証はかけない.
  * @param web
  * @throws Exception
  */
  @Override
  public void configure(WebSecurity web) throws Exception{
    web
    .ignoring()
    .antMatchers( "/css/**", "/js/**", "/images/**");
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http
          .antMatcher("/admin/**")
          .authorizeRequests()
          .antMatchers("/**").permitAll()
          .antMatchers("/admin/**").hasAuthority("ADMIN")
          .anyRequest()
          .authenticated();

        http
          .formLogin()
          .loginProcessingUrl("/admin/login")//ログイン処理をするURL
          .loginPage("/admin/adminLogin")//ログイン画面のURL
          .failureUrl("/admin/loginPage?error")//ログイン失敗時
          .defaultSuccessUrl("/admin/adminTop")//認証成功時のURL
          .usernameParameter("email")//ユーザーのパラメーター名
          .passwordParameter("password")
          .and();

        http
          .logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
          .logoutSuccessUrl("/admin/adminLogin")
          .permitAll()
          .deleteCookies("JSESSIONID")
          .invalidateHttpSession(true)
          .and();
    }  
}