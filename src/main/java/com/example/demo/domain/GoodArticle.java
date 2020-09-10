package com.example.demo.domain;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodArticle {

  private int goodArticleId;

  private int userId;

  private int articleId;

  private Date saveDate;
}