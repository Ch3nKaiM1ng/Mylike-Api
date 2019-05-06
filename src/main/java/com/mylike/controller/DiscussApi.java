package com.mylike.controller;


import com.mylike.entity.Discuss;
import com.mylike.service.DiscussService;
import com.mylike.utils.DiscussDTO;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;
import java.util.List;
import java.util.Map;

@RequestMapping("/discuss")
@RestController
public class DiscussApi {
    @Autowired
    private DiscussService service;
    private ReturnDiscern re = new ReturnDiscern();

    //  递归
    private DiscussDTO disTo = new DiscussDTO();
//  添加评论
    @RequestMapping("/addDiscuss")
    public Map<String,Object> addDiscuss(Discuss discuss){
        service.insert(discuss);
        if (discuss.getId()!=null){
            return re.SUCCESS();
        }
        return re.ERROR();
    }
//    查询单个评论
    @RequestMapping("/showDiscussById")
    public Map<String,Object>showDiscussById(int id){
        List<Discuss> discuss =service.showDiscussById(id);
        int num = 0;
        for (Discuss discuss1:discuss){
            if (discuss1.getId()==id){
                num = discuss1.getParentId();
            }
        }
        return re.SUCCESSOBJ(disTo.convert(num,discuss));
    }
}
