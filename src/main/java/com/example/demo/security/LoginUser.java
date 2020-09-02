package com.example.demo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User {

  private static final long serialVersionUID = 1L;

  private static com.example.demo.domain.User userDomain;

  private User user;


  public LoginUser(com.example.demo.domain.User user2, Collection<? extends GrantedAuthority> authorities) {
    super(userDomain.getEmail(), userDomain.getPassword(), authorities);
}


/*認証処理成功後の処理でアカウント情報にアクセスできるようにするためにgetterメソッドを用意する*/
public User getUser(){
  return user;
}
  
}