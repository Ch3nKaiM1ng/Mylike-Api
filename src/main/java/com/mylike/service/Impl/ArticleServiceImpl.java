package com.mylike.service.Impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.mylike.entity.Article;
import com.mylike.entity.Discuss;
import com.mylike.mapper.ArticleMapper;
import com.mylike.mapper.DiscussMapper;
import com.mylike.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper mapper;
    @Autowired
    private DiscussMapper discussMapper;

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
    public List<Article> showArticleSort(Integer sId,Integer startId, Integer endId) {
        return mapper.showArticleSort(sId,startId*endId,endId);
    }

    @Override
    public void updateArticle(Article article) {
        mapper.updateByPrimaryKey(article);
    }

    @Transactional
    @Override
    public void delectArticle(Integer aId) {
        int count = mapper.deleteByPrimaryKey(aId);
        if (count > 0) {
            Discuss discuss = new Discuss();
            discuss.setaId(aId);
            this.discussMapper.deleteByRelationId(discuss);
        }
    }

    @Override
    public List<Article> showArticlesByTitle(String keyWord) {
        return mapper.selectByTitle(keyWord);
    }

    @Override
    public List<Article> showArticlesByLabel(String label) {
        return this.mapper.selectArticlesByLabel(label);
    }

    /**
     * 浏览数加一
     */
    @Override
    public int addBrowseNum(Integer aId) {
        return this.mapper.addBrowseNum(aId);
    }

    @Override
    public Page<Article> selectByDesc(Page<Article> page) {
        return page.setRecords(this.mapper.selectByDesc(page));
    }


}
