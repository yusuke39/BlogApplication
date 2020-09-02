package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

  private String userName;

  private String email;

  private String blogName;

  private String password;
}