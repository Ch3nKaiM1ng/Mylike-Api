package com.mylike.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.mylike.entity.Article;

import java.util.List;

public interface ArticleService {
    void insert(Article article);

    List<Article> seleceAll();

    Object selectById(int aId);


    void updateArticle(Article article);

    void delectArticle(Integer aId);

    List<Article> showArticlesByTitle(String keyWord);

    List<Article> showArticlesByLabel(String label);

    int addBrowseNum(Integer aId);

    Page<Article> selectByDesc(Page<Article> page);

    List<Article> showArticleSort(Integer sId, Integer startId, Integer endId);
}
