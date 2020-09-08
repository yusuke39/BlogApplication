package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

  private int userId;

  private String userName;

  private String email;

  private String userImg;

  private String blogName;

  private String password;

  private String blogImg;

  private String deleteFlag;

  private String createDate;

  private String updateDate;
}