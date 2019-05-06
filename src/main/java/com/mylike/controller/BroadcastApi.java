package com.mylike.controller;

import com.mylike.entity.Broadcast;
import com.mylike.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/broadcast")
@RestController
public class BroadcastApi {

    @Autowired
    public BroadcastService service;

//    查询广播
    @RequestMapping("/showBroadcast")
    public List<Broadcast> show(String bBelong){
        return service.selectAll(bBelong);
    }
//    添加广播
    @RequestMapping(value = "/addBroadcast")
    public List<Broadcast> add(@RequestBody List<Broadcast> broadcast){
        System.out.println(123);
        return broadcast;
    }
}
