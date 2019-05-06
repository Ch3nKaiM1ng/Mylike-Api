package com.mylike.mapper;

import com.mylike.entity.Article;
import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Article record);

    Article selectByPrimaryKey(Integer aId);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

    List<Article> showArticleSort(Integer sId);
}