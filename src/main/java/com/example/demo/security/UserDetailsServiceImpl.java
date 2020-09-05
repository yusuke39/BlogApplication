// package com.example.demo.security;

// import com.example.demo.mapper.UserMapper;

// import java.util.ArrayList;
// import java.util.Collection;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// @Service
// public class UserDetailsServiceImpl implements UserDetailsService {

//   @Autowired
//   UserMapper userMapper;

//   // private static List<String> usernameList = Arrays.asList("nyasba", "admin");
//   // private static String ENCRYPTED_PASSWORD = "$2a$10$5DF/j5hHnbeHyh85/0Bdzu1HV1KyJKZRt2GhpsfzQ8387A/9duSuq"; // "password"を暗号化した値


//   @Override
//   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//     com.example.demo.domain.User user = userMapper.findUser(email);

//       // 本来ならここでDBなどからユーザを検索することになるが、サンプルのためリストに含まれるかで判定している
//       // if(!user.contains(user.getEmail())){
//       //     throw new UsernameNotFoundException(user.getEmail());
//       // }

//       Collection<GrantedAuthority> authorityList = new ArrayList<>();
// 		  authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
// 		  UserDetails userDetails = User.withUsername(user.getEmail()).password(user.getPassword()).authorities(authorityList).build();


//       return userDetails;
//   } 
  
// }