package com.mylike.controller;

import com.mylike.entity.Broadcast;
import com.mylike.service.BroadcastService;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/broadcast")
@RestController
public class BroadcastApi {

//    引用service
    @Autowired
    public BroadcastService service;
//引用return
    private ReturnDiscern re = new ReturnDiscern();
//    查询广播
    @RequestMapping("/showBroadcast")
    public List<Broadcast> show(String bBelong){
        return service.selectAll(bBelong);
    }
//    添加广播
    @RequestMapping("/addBroadcast")
    public List<Broadcast> add(@RequestBody List<Broadcast> broadcast){
        System.out.println(123);
        return broadcast;
    }
//    修改广播
    @RequestMapping("/updateBroadcast")
    public Map<String,Object>updateBroadcast(@RequestBody Broadcast broadcast){
        if (broadcast.getbId()!=null){
            service.update(broadcast);
            return re.SUCCESS();
        }
        return re.ERROR();
    }
//    删除广播
    @RequestMapping("/delectBroadcast")
    public Map<String,Object>delectBroadcast(Integer bId){
        if (bId!=null) {
            service.delectById(bId);
            return re.SUCCESS();
        }
        return re.ERROR();
    }
}
