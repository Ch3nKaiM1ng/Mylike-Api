package com.mylike.controller;

import com.mylike.entity.Article;
import com.mylike.mapper.ArticleMapper;
import com.mylike.service.ArticleService;
import com.mylike.utils.DateUtils;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/article")
@RestController
public class ArticleApi {
    @Autowired
    private ArticleService service;

//    时间utils
    private DateUtils data = new DateUtils();
//    返回utils
    private ReturnDiscern re =new  ReturnDiscern();
//  添加文章
    @RequestMapping("/addArticle")
    public Map<String,Object> addArticle(@RequestBody Article article){
        article.setaAddtime(data.NewDate());
        service.insert(article);
        if (article.getaId()!=null){
            return re.SUCCESS();
        }
        return re.ERROR();
    }
//    查询All文章
    @RequestMapping("/showArticleAll")
    public Map<String,Object> showArticleAll(){
       List<Article> articles = service.seleceAll();
       return re.SUCCESSOBJ(articles);
    }
//    查询文章byID
    @RequestMapping("/showArticleBy")
    public Map<String,Object> showArticleById(int aId){
       return re.SUCCESSOBJ(service.selectById(aId));
    }
//    通过分类查文章
    @RequestMapping("/showArticleSort")
    public Map<String,Object>showArticleSort(int sId){
        List<Article> list = service.showArticleSort(sId);
        return re.SUCCESSOBJ(list);
    }
}
