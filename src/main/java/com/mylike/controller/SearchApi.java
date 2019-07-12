package com.mylike.controller;

import com.mylike.dto.ArticleDTO;
import com.mylike.dto.DynamicDTO;
import com.mylike.dto.VideoContentDTO;
import com.mylike.entity.Article;
import com.mylike.entity.Dynamic;
import com.mylike.entity.Search;
import com.mylike.entity.VideoContent;
import com.mylike.service.*;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
    @Autowired
    private DiscussService discussService;
    @Autowired
    private DynamicService dynamicService;

    private ReturnDiscern re = new ReturnDiscern();

    //    查询关键词
    @RequestMapping("/showSearch")
    public List<Search> showSearch(String sBelong) {
        return service.select(sBelong);
    }

    //    添加关键词
    @RequestMapping("/addSearch")
    public String addSearch(@RequestBody List<Search> search) {
        for (Search se:search){
            if (se.getsAddtime()==null){
                se.setsAddtime(new Date());
            }
            service.insert(se);
        }

        return "success";
    }
//    删除关键词
    @RequestMapping("/delectSearch")
    public Map<String,Object> delectSearch(Integer sId){
        if (sId!=null){
            int count = this.service.delect(sId);
            if (count>0){
                return re.SUCCESS();
            }
        }
        return re.ERROR();
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
        return re.SUCCESSOBJ(this.sortService.showSortsByName(keyWord));
    }

    /**
     * 检索标签
     */
    @RequestMapping("/showByLabel")
    public Map<String, Object> showByLabel(String label) {

        List<Article> articles = this.articleService.showArticlesByLabel(label);

        List<ArticleDTO> articleDTOs = new ArrayList<>();
        for (Article article : articles) {
            ArticleDTO articleDTO = new ArticleDTO();
            BeanUtils.copyProperties(article, articleDTO);
            Integer count = this.discussService.showCountByAid(article.getaId());
            articleDTO.setDiscussNum(count);
            articleDTOs.add(articleDTO);
        }

        List<VideoContent> videoContents = this.videoContentService.showVideoContentsByLabel(label);

        List<VideoContentDTO> videoContentDTOs = new ArrayList<>();
        for (VideoContent videoContent : videoContents) {
            VideoContentDTO videoContentDTO = new VideoContentDTO();
            BeanUtils.copyProperties(videoContent, videoContentDTO);
            Integer count = this.discussService.showCountByVid(videoContent.getvId());
            videoContentDTO.setDiscussNum(count);
            videoContentDTOs.add(videoContentDTO);
        }

        List<Dynamic> dynamics = this.dynamicService.showDynamicsByLabel(label);

        List<DynamicDTO> dynamicDTOs = new ArrayList<>();
        for (Dynamic dynamic : dynamics) {
            DynamicDTO dynamicDTO = new DynamicDTO();
            BeanUtils.copyProperties(dynamic, dynamicDTOs);
            Integer count = this.discussService.showCountByVid(dynamic.getdId());
            dynamicDTO.setDiscussNum(count);
            dynamicDTOs.add(dynamicDTO);
        }

        Map<String, Object> obj = new HashMap<>();
        obj.put("articles", articles);
        obj.put("videoContents", videoContents);
        obj.put("dynamics", dynamics);

        return re.SUCCESSOBJ(obj);
    }
//    添加排序关键字
    @RequestMapping("/addRank")
    public Map<String,Object>addRank(Search search){
        int count = this.service.insert(search);
        if (count>0){
            return re.SUCCESS();
        }
        return re.ERROR();
    }
}
