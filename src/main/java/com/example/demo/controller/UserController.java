package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  /**
   * ユーザーを登録する.
   * @param userName
   * @param email
   * @param blogName
   * @param password
   */
  @PostMapping("/registerUser")
  public void registerUser(
    @RequestParam("userName") String userName, 
    @RequestParam("email") String email,
    @RequestParam("blogName") String blogName,
    @RequestParam("password") String password
    ){
      userService.userRegister(userName, email, blogName, password);
  }

  /**
   * ユーザーを1件userIdで検索して、Userドメインを返す.
   * @param userId
   * @return
   */
  @GetMapping("/findUserById")
  public User findUserById(
    @RequestParam("userId") int userId
  ) {
    return userService.findUserById(userId);
  }



  /**
   * ユーザー情報を1件updateする.
   * @param userName
   * @param email
   * @param blogName
   * @param userImg
   * @param blogImg
   */
   @PostMapping("/updataUserInfo")
   public void updataUserInfo(
    @RequestParam("userId") int userId, 
    @RequestParam("userName") String userName, 
    @RequestParam("email") String email,
    @RequestParam("blogName") String blogName,
    @RequestParam("iconImageUrl") String userImg,
    @RequestParam("blogMainImageUrl") String blogImg
   ){
      userService.updataUserInfo(userId, userName, email, userImg, blogName, blogImg);
   }
}