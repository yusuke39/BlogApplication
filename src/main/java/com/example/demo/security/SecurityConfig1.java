// package com.example.demo.security;

// import javax.servlet.http.HttpServletResponse;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpStatus;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.authentication.HttpStatusEntryPoint;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @EnableWebSecurity
// @Configuration
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//   @Bean
//   PasswordEncoder passwordEncoder(){
//       return new BCryptPasswordEncoder();
//   }

//   @Override
//   public void configure(WebSecurity web) throws Exception{
//       web
//         .ignoring()
//         .antMatchers( "/css/**", "/js/**", "/images/**");
//   }

//   @Override
//   protected void configure(HttpSecurity http) throws Exception{
//         http
//               .antMatcher("/admin/**")
//               .authorizeRequests()
//               .antMatchers("/login","/userRegister").permitAll()
//               .antMatchers("/login").hasAuthority("USER")
//               .anyRequest().permitAll()
//               .and();

//       JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter =
//           new JsonUsernamePasswordAuthenticationFilter(authenticationManager());
//           jsonUsernamePasswordAuthenticationFilter.setUsernameParameter("email");
//           jsonUsernamePasswordAuthenticationFilter.setPasswordParameter("password");
//           // ログイン後にリダイレクトのリダイレクトを抑制
//           jsonUsernamePasswordAuthenticationFilter
//               .setAuthenticationSuccessHandler((req, res, auth) -> res.setStatus(HttpServletResponse.SC_OK));
//           // ログイン失敗時のリダイレクト抑制
//           jsonUsernamePasswordAuthenticationFilter
//               .setAuthenticationFailureHandler((req, res, ex) -> res.setStatus(HttpServletResponse.SC_UNAUTHORIZED));
  
//           // FormログインのFilterを置き換える
//           http.addFilterAt(jsonUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
  
//           // Spring Securityデフォルトでは、アクセス権限（ROLE）設定したページに未認証状態でアクセスすると403を返すので、
//           // 401を返すように変更
//           http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
//           // 今回は、403エラー時にHTTP Bodyを返さないように設定
//           http.exceptionHandling().accessDeniedHandler((req, res, ex) -> res.setStatus(HttpServletResponse.SC_FORBIDDEN));


//           http
//           .logout()
//           .logoutUrl("/logout")
//           // ログアウト時のリダイレクト抑制
//           .logoutSuccessHandler((req, res, auth) -> res.setStatus(HttpServletResponse.SC_OK))
//           .invalidateHttpSession(true);
//   }
  
// }