package com.mylike.controller;

import com.mylike.entity.Classify;
import com.mylike.service.ClassIfyService;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/classify")
@RestController
public class ClassifyApi {
    @Autowired
    private ClassIfyService service;

    private ReturnDiscern re = new ReturnDiscern();
//    查询分类
    @RequestMapping("/showIfy")
    public List<Classify> showIfy(){
        return service.selectAll();
    }
//    添加分类
    @RequestMapping("/addIfy")
    public String addIfy(@RequestBody List<Classify> ify){
        service.insert(ify);
        return "success";
    }
//  修改分类
    @RequestMapping("/updateIfy")
    public Map<String,Object> updateIfy(@RequestBody Classify classify){
        service.updateIfy(classify);
        return re.SUCCESS();
    }

}
