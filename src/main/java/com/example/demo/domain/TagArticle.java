package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagArticle {

  private int tagArticleId;

  private int  articleId;
  
  private int tagId;
  
}