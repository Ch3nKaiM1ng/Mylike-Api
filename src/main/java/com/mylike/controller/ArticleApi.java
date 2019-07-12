package com.mylike.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.mylike.dto.ArticleDTO;
import com.mylike.entity.Article;
import com.mylike.service.ArticleService;
import com.mylike.service.DiscussService;
import com.mylike.utils.DateUtils;
import com.mylike.utils.DiscussDTO;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/article")
@RestController
public class ArticleApi {
    @Autowired
    private ArticleService articleService;

    //    时间utils
    private DateUtils data = new DateUtils();
    //    返回utils
    private ReturnDiscern re = new ReturnDiscern();
    //    评论
    @Autowired
    private DiscussService discussService;
    //  递归
    private DiscussDTO disTo = new DiscussDTO();

    //  添加文章
    @RequestMapping("/addArticle")
    public Map<String, Object> addArticle(@RequestBody Article article) {
        articleService.insert(article);
        if (article.getaId() != null) {
            return re.SUCCESS();
        }
        return re.ERROR();
    }

    //    查询All文章
    @RequestMapping("/showArticleAll")
    public Map<String, Object> showArticleAll() {

        List<Article> articles = articleService.seleceAll();
        List<ArticleDTO> articleDTOs = new ArrayList<>();
        for (Article article : articles) {
            ArticleDTO articleDTO = new ArticleDTO();
            BeanUtils.copyProperties(article, articleDTO);
            Integer count = this.discussService.showCountByAid(article.getaId());
            articleDTO.setDiscussNum(count);
            articleDTOs.add(articleDTO);
        }

        return re.SUCCESSOBJ(articleDTOs);
    }

    //    查询文章byID
    @RequestMapping("/showArticleBy")
    public Map<String, Object> showArticleById(Integer aId) {
//       查询评论
        Map<String, Object> map = new HashMap<>();
        if (aId != null) {
            map = re.SUCCESSOBJ(articleService.selectById(aId));
            //查询评价
            map.put("discuss", disTo.convert(0, discussService.selectByAId(aId)));
            //浏览数加一   
            this.articleService.addBrowseNum(aId);
            return map;
        }
        return re.ERROR();
    }

    //    通过分类查文章
    @RequestMapping("/showArticleSort")
    public Map<String, Object> showArticleSort(@RequestParam("sId") Integer sId,@RequestParam("startId")Integer startId,@RequestParam("endId") Integer endId) {
        List<Article> list = articleService.showArticleSort(sId,startId,endId);
        return re.SUCCESSOBJ(list);
    }

    //    文章修改
    @RequestMapping("/updateArticle")
    public Map<String, Object> updateArticle(@RequestBody Article article) {
        if (article.getaId() != null) {
            articleService.updateArticle(article);
            return re.SUCCESS();
        }
        return re.ERROR();
    }

    //    文章删除
    @RequestMapping("/delectArticle")
    public Map<String, Object> delectArticle(Integer aId) {
        if (aId != null) {
            articleService.delectArticle(aId);
            return re.SUCCESS();
        }
        return re.ERROR();
    }
//    通过添加顺序排序
    @RequestMapping("/selectByDesc")
    public Map<String,Object> selectByDesc(Integer index,Integer size){
        if (index!=null){
            Page<Article> page = new Page<>(index, size);
            Page<Article>articles = articleService.selectByDesc(page);
            return re.SUCCESSOBJ(articles);
        }
        return re.ERROR();
    }

}
