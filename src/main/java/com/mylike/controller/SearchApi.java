package com.mylike.controller;

import com.mylike.entity.Navigation;
import com.mylike.entity.Search;
import com.mylike.service.SearchService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.tools.rmi.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchApi {
    @Autowired
    private SearchService service;

//    查询关键词
    @RequestMapping("/showSearch")
    public List<Search> showSearch(String sBelong){
        return service.select(sBelong);
    }

//    添加关键词
    @RequestMapping("/addSearch")
    public String addSearch(@RequestBody List<Search> search){
        service.insert(search);
        return "success";
    }
}
