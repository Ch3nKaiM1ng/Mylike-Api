package com.mylike.service;

import com.mylike.entity.Article;

import java.util.List;

public interface ArticleService {
    void insert(Article article);

    List<Article> seleceAll();

    Object selectById(int aId);

    List<Article> showArticleSort(Integer sId);

    void updateArticle(Article article);

    void delectArticle(Integer aId);

    List<Article> showArticlesByTitle(String title);
}
