package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserMapper userMapper;

  // @Autowired
  // PasswordEncoder passwordEncoder;

  /**
   * Userドメインに詰めてUserMapperへ渡しユーザー新規登録.
   * @param userName
   * @param email
   * @param blogName
   * @param password
   */
  public void userRegister (String userName, String email, String blogName, String password) {
    User user = new User();
    user.setUserName(userName);
    user.setEmail(email);
    user.setBlogName(blogName);
    user.setPassword(password);
    userMapper.insertUser(user);
  }

}