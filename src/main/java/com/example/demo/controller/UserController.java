package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UserController {

  @Autowired
  UserRegisterService userRegisterService;

  //ユーザーを登録する
  @PostMapping("/registerUser")
  public String registerUser(
    @RequestParam("userName") String userName, 
    @RequestParam("email") String email,
    @RequestParam("blogName") String blogName,
    @RequestParam("password") String password
    ){
    
    User user = new User();
    user.setUserName(userName);
    user.setEmail(email);
    user.setBlogName(blogName);
    user.setPassword(password);
    userRegisterService.userRegister(user);

    return "{\"msg\":\"HelloWorld\"}";
  }
}