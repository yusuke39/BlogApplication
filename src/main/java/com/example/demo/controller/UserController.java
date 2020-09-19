package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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

   /**
    * ユーザー情報全権取得.
    * @return
    */
   @RequestMapping("/getAllUser")
   public List<List<User>> getAllUser(){
    return makeUserList(userService.getAllUser());
   }


  //  /**
  //   * ユーザーをuseerIdで1件検索する.
  //   * @param userId
  //   */
  //  @RequestMapping("/findUserAndArticleByUserId")
  //  public void findUserfindUserAndArticleByUserIdByUserId(
  //    @RequestParam("userId") int userId
  //  ){
  //    System.out.println(userId);
  //  }

   /**
    * 取ってきたUserのListを４つ×n個にわけ、Listに詰め直す
    * @param userList
    * @return
    */
   public List<List<User>> makeUserList(List<User> userList){

     List<User> userBreakList = new ArrayList<>();

     List<List<User>> userListinList = new ArrayList<>();

     for (int i = 1; i <= userList.size(); i++){
       userBreakList.add(userList.get(i - 1));
       if((i % 4) == 0) {
        userListinList.add(userBreakList);
        userBreakList = new ArrayList<>();
       }
     } 
     if(userBreakList.size() == 0) {
       return userListinList;
     }
     userListinList.add(userBreakList);
     return userListinList;
   }
}