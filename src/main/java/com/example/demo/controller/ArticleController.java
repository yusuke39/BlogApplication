package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
@RequestMapping("/article")
public class ArticleController {

  @PostMapping("/createArticle")
  public void createArticle(@RequestParam("articleTitle") String articleTitle) {
      System.out.println(articleTitle);
  }
  
  
}