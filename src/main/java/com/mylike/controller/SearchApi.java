package com.mylike.controller;

import com.mylike.entity.Article;
import com.mylike.entity.Navigation;
import com.mylike.entity.Search;
import com.mylike.entity.VideoContent;
import com.mylike.service.ArticleService;
import com.mylike.service.SearchService;
import com.mylike.service.SortService;
import com.mylike.service.VideoContentService;
import com.mylike.utils.ReturnDiscern;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.tools.rmi.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchApi {
    @Autowired
    private SearchService service;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private VideoContentService videoContentService;
    @Autowired
    private SortService sortService;

    private ReturnDiscern re = new ReturnDiscern();

    //    查询关键词
    @RequestMapping("/showSearch")
    public List<Search> showSearch(String sBelong) {
        return service.select(sBelong);
    }

    //    添加关键词
    @RequestMapping("/addSearch")
    public String addSearch(@RequestBody List<Search> search) {
        service.insert(search);
        return "success";
    }

    /**
     * 全文检索
     */
    @RequestMapping("/showByKey")
    public Map<String, Object> fullTextSearch(String keyWord) {

        System.out.println(keyWord);
        List<Article> articles = this.articleService.showArticlesByTitle(keyWord);

        List<VideoContent> videoContents = this.videoContentService.showVideoContentsByTitle(keyWord);

        Map<String, Object> map = new HashMap<>();
        map = re.SUCCESS();
        map.put("article", articles);
        map.put("video", videoContents);

        return map;
    }

    /**
     * 检索分类
     */
    @RequestMapping("/showSort")
    public Map<String, Object> showSort(@RequestParam("keyWord") String keyWord) {

        Map<String, Object> map = re.SUCCESS();
        map.put("sort", this.sortService.showSortsByName(keyWord));

        return map;
    }
}
