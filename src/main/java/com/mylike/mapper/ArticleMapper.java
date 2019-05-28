package com.mylike.mapper;

import com.mylike.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Article record);

    Article selectByPrimaryKey(Integer aId);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

    List<Article> showArticleSort(Integer sId);

    List<Article> selectByTitle(@Param("title") String title);

    List<Article> selectArticlesByLabel(@Param("label") String label);

    int addBrowseNum(@Param("aId") Integer aId);
}