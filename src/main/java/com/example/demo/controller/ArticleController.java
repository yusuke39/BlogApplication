package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
@RequestMapping("/article")
public class ArticleController {

  @Autowired
  ArticleService articleService;

  /**
   * 記事投稿、タグ保存のサービスにそれぞれ値を渡す.
   * @param articleTitle
   * @param tags
   * @param blogText
   */
  @PostMapping("/createArticle")
  public void createArticle(@RequestParam("articleTitle") String articleTitle,
                            @RequestParam("tags") String tags,
                            @RequestParam("blogText") String blogText){

    articleService.insertArticle(articleTitle,tags,blogText);


  }
  
  
}