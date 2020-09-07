package com.example.demo.mapper;

import java.util.List;

import com.example.demo.domain.Article;
import com.example.demo.domain.Tag;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {

  /**
   * 記事を登録する.
   * @param article
   */
  void insertArticle(Article article);

  /**
   * タグを登録する.
   */
  void insertTag(Tag tag);

  /**
   * articleテーブルとtagテーブルの中間テーブルへそれぞれのIDをインサート.
   * @param tagArticle
   */
  void insertTagArticle(@Param("articleId") int articleId, @Param("tagId") int tagId);


  /**
   * タグを全権取得.
   * @return
   */
  List<Tag> findAllTags();

  /**
   * 投稿した記事を全権取得.
   * @return
   */
  List<Article> findAllArticles();
  
}