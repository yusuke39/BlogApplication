package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Article {

  private int articleId;

  private int userId;

  private String articleTitle;

  private String content;

  private int privateFlag;

  private int deleteFlag;  
}