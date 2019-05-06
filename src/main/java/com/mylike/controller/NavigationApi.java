package com.mylike.controller;

import com.mylike.entity.Navigation;
import com.mylike.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/navigation")
public class NavigationApi {
    @Autowired
    private NavigationService service;

//    查询导航
    @RequestMapping("/showNav")
    public List<Navigation> showNav(String nBelong){
        return service.selectAll(nBelong);
    }
//    添加导航
    @RequestMapping("/addNav")
    public String addNav(@RequestBody List<Navigation> nav){
        System.out.println(1);
        for (Navigation navs:nav){
            System.out.println(nav.toString());
        }
        service.insert(nav);
        return "success";
    }

}
