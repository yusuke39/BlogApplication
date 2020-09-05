// package com.example.demo.security;

// // import java.util.Optional;
// // import java.util.Collection;


// import com.example.demo.mapper.UserMapper;

// import org.springframework.security.core.userdetails.User;
// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.security.core.GrantedAuthority;
// // import org.springframework.security.core.authority.AuthorityUtils;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// @Service
// public class UserSecurityService implements UserDetailsService {
  
//   @Autowired
//   UserMapper userMapper;

//   @Transactional(readOnly = true)
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//         /*DBから管理者情報を検索して、見つからなければ、UsernameNotFoundExceptionをスローする*/
//         // com.example.demo.domain.User userDomain = Optional.ofNullable(userMapper.findUser(email))
//         //         .orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりませんでした"));

//         System.out.println(email);

//         com.example.demo.domain.User userDomain = userMapper.findUser(email);

//                 System.out.println(userDomain + "userDomain詰まったよー");

//         /*アカウント情報が見つかった場合はLoginUserを生成する*/
//         // return new LoginUser(userDomain, getAuthorities(userDomain));

//         return User.withUsername(email)
//         .password(userDomain.getPassword())
//         .authorities("ROLE_USER") // ユーザの権限
//         .build();
//     }

//     // private Collection<GrantedAuthority> getAuthorities(User user) {
//     //         return AuthorityUtils.createAuthorityList("USER");
//     // }

// }