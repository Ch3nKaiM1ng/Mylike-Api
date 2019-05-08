package com.mylike.controller;


import com.mylike.entity.VideoContent;
import com.mylike.service.VideoContentService;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/videoContent")
public class VideoContentApi {
    @Autowired
    private VideoContentService service;

    private ReturnDiscern re = new ReturnDiscern();

//  添加视频内容
    @RequestMapping("/addContent")
    public Map<String, Object> addContent(@RequestBody VideoContent cont){

        service.insert(cont);
        Map<String,Object> map = new HashMap<>();
        map.put("content",cont);
        return map;
    }
//    展示首页视频
    @RequestMapping("/showContent" )
    public List<VideoContent> showContent(@RequestParam(value = "startId") Integer startId,@RequestParam(value = "endId") Integer endId){
        return service.selectAll(startId,endId);
    }
//    视频详情展示
    @RequestMapping("/showVideo")
    public VideoContent showVideo(int vId){
        return service.selectId(vId);
    }
//    删除视频
    @RequestMapping("/delectVideo")
    public Map<String,Object> delectVideo(int vId){
        service.delectById(vId);
        return re.SUCCESS();
    }
}
