package com.mylike.service.Impl;

import com.mylike.entity.Article;
import com.mylike.mapper.ArticleMapper;
import com.mylike.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper mapper;

    @Override
    public void insert(Article article) {
        mapper.insert(article);
    }

    @Override
    public List<Article> seleceAll() {
        return mapper.selectAll();
    }

    @Override
    public Article selectById(int aId) {
        return mapper.selectByPrimaryKey(aId);
    }

    @Override
    public List<Article> showArticleSort(Integer sId) {
        return mapper.showArticleSort(sId);
    }

    @Override
    public void updateArticle(Article article) {
        mapper.updateByPrimaryKey(article);
    }

    @Override
    public void delectArticle(Integer aId) {
        mapper.deleteByPrimaryKey(aId);
    }
}
