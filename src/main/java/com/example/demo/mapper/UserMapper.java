package com.example.demo.mapper;

import java.util.List;

import com.example.demo.domain.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  /**
   * ユーザーを登録する.
   * @param user
   */
  void insertUser(User user);

  /**
   * ユーザーをemailで1件検索する.
   * @param email
   * @return
   */
  User findUserByEmail(String email);


  /**
   * ユーザーをuserIdで１件検索する.
   * @param userId
   * @return
   */
  User findUserById(int userId);

  /**
   * ユーザーを1件updateする.
   * @param user
   */
  void updataUserInfo(User user);

  /**
   * ユーザー全権取得.
   * @return
   */
  List<User> getAllUser();


  /**
   * ユーザーの総数をカウント
   * @return
   */
  int countAllUser();

}