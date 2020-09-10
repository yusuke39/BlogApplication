package com.example.demo.domain;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comment {

  private int commentId;

  private int articleId;

  private int userId;

  private String comment;

  private Date createDate;
}