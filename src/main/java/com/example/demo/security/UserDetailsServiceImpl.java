package com.example.demo.security;

import com.example.demo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      // 本来ならここでDBなどからユーザを検索することになるが、サンプルのためリストに含まれるかで判定している
      com.example.demo.domain.User user = userMapper.findUserByEmail(username);

      if(user == null){
          throw new UsernameNotFoundException(username);
      }

      return User.withUsername(username)
              .password(user.getPassword())
              .authorities("ROLE_USER") // ユーザの権限
              .build();
  }
  
}