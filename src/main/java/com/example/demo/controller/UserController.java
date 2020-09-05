package com.example.demo.controller;

import com.example.demo.service.UserRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserRegisterService userRegisterService;

  //ユーザーを登録する
  @PostMapping("/registerUser")
  public void registerUser(
    @RequestParam("userName") String userName, 
    @RequestParam("email") String email,
    @RequestParam("blogName") String blogName,
    @RequestParam("password") String password
    ){
    userRegisterService.userRegister(userName, email, blogName, password);
  }
}