package com.mylike.controller;

import com.mylike.entity.Discuss;
import com.mylike.entity.Dynamic;
import com.mylike.service.DiscussService;
import com.mylike.service.DynamicService;
import com.mylike.utils.DiscussDTO;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dynamic")
public class DynamicApi {

    @Autowired
    private DynamicService service;

//  评价
    @Autowired
    private DiscussService discussService;
//  return
    private ReturnDiscern re = new ReturnDiscern();
//  递归
    private DiscussDTO disTo = new DiscussDTO();

//    心得/动态添加
    @RequestMapping("/addDynamic")
    public Map<String,Object> addDynamic(Dynamic dynamic){
        dynamic.setdAddtime(new Date());
        System.out.println(dynamic.toString());
        service.insert(dynamic);
        if (dynamic.getdId()==null){
            return re.ERROR();
        }
        return re.SUCCESS();
    }
//    心得/动态查询
    @RequestMapping("/showDynamic")
    public Map<String,Object>showDynamic(){
        return service.selectAll();
    }
//    心得/动态单个查询
    @RequestMapping("/showDynamicById")
    public Map<String,Object>showDynamicById(Integer dId){
        Map<String,Object> map = new HashMap<>();
        Dynamic dynamic = service.showDynamicById(dId);
        if (dynamic.getdId()!=null){
            map.putAll(re.SUCCESSOBJ(dynamic));
//        查询评价
            map.put("discuss",disTo.convert(0,discussService.selectByDId(dId)));
            return map;
        }
        return re.ERROR();
    }
//    心得点赞
    @RequestMapping("/dynamicLike")
    public Map<String,Object> dynamicLike(Integer dId){
        service.dynamicLike(dId);
        return re.SUCCESS();
    }
//    心得修改
    @RequestMapping("updateDynamic")
    public Map<String,Object> updateDynamic(Dynamic dynamic){
        if (dynamic.getdId()!=null){
            service.updateDynamic(dynamic);
            return re.SUCCESS();
        }
        return re.ERROR();
    }

}
