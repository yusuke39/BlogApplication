package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Article;
import com.example.demo.domain.Tag;
import com.example.demo.mapper.ArticleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

  @Autowired
  ArticleMapper articleMapper;

  /**
   * Articleテーブルにインサートする.
   * 
   * @param articleTitle
   * @param tags
   * @param blogtext
   */
  public void insertArticle(String articleTitle, String tags, String blogtext) {

    //insert userId blogtext deleteflag to article table.
    Article article = new Article();
    article.setUserId(7);
    article.setArticleTitle(articleTitle);
    article.setContent(blogtext);
    article.setDeleteFlag(0);
    articleMapper.insertArticle(article);

    //call insertTag method
    List<Integer> tagIdList = insertTags(tags);

    //insert ArticleId and TagId at the same time.
    for(int tagId : tagIdList) {
      articleMapper.insertTagArticle(article.getArticleId(), tagId);
    }
  }

  /**
   * タグ名をインサートする.
   * @param tags
   * @return tag_idのリストを返す
   */
  public List<Integer> insertTags(String tags) {

     //split tagNames by ,
    String tagNameList[] = tags.split(",");

    // 登録されたタグをListに詰める.
    List<String> tagList = new ArrayList<>();
    for( String tagName : tagNameList ) {
        tagList.add(tagName);
    }

    //タグIDを入れるためのList
    List<Integer> tagIdList = new ArrayList<>();


    //全権取得したタグ名とクライアントから送信されたタグを比較して、すでにDBにあれば登録しない
    //ここめちゃパフォーマンス悪くなりそう,,,
    //何かしら別の方法を探ること
    for (String tagName : tagList) {
      for(Tag tagDomain : findAllTags()) {
        //もし、DBにすでにあるタグと被ったらすでにDBにあったTagIdを返す
        if(tagDomain.getTagName().equals(tagName)) {
          tagIdList.add(tagDomain.getTagId());
          return tagIdList;
        }
      }
     //自動採番して返ってきたtag_idをtagIdListにaddする.
        Tag tag = new Tag();
        tag.setTagName(tagName);
        articleMapper.insertTag(tag);
        tagIdList.add(tag.getTagId());
        // for(Tag tagDomain : tagDomainList) {
        //   System.out.println(tagDomain.getTagId() + "tagIdですよー");
        //   tagIdList.add(tagDomain.getTagId());
        // }
    }
    return tagIdList;
  }

  /**
   * タグを全権取得する.
   * @return
   */
  public List<Tag> findAllTags() {

    List<Tag> allTagList = articleMapper.findAllTags();

    return allTagList;
  }
}