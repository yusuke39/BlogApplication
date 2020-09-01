package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class AdminController {


  @PostMapping("/registerUser")
  public String registerUser(
    @RequestParam("nickName") String nickName, 
    @RequestParam("email") String email,
    @RequestParam("blogName") String blogName,
    @RequestParam("password") String password
    ){
    System.out.println(nickName);
    System.out.println(email);
    System.out.println(blogName);
    System.out.println(password);
    return "{\"msg\":\"HelloWorld\"}";
  }
}