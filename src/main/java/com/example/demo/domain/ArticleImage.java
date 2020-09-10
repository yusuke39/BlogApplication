package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticleImage {
  
  private int articleImageId;

  private int articleId;

  private String articleImg;
}