package com.example.demo.controller;

import com.example.demo.form.RegisterUserForm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class AdminController {


  @RequestMapping("/registerUser")
  public String registerUser(RegisterUserForm registerUserForm){
    System.out.println(registerUserForm.getNickName());
    System.out.println("きた");
    return "{\"msg\":\"HelloWorld\"}";
  }
}