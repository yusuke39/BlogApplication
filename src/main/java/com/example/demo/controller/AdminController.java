package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class AdminController {


  @RequestMapping("/registeruser")
  public String getMsg(){
    System.out.println("きた");
    return "{\"msg\":\"HelloWorld\"}";
  }
}