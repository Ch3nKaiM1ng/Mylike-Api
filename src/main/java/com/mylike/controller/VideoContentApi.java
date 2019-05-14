package com.mylike.controller;


import com.mylike.entity.VideoContent;
import com.mylike.service.DiscussService;
import com.mylike.service.VideoContentService;
import com.mylike.utils.DiscussDTO;
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

    //  return
    private ReturnDiscern re = new ReturnDiscern();
    //  递归
    private DiscussDTO disTo = new DiscussDTO();
    //  评价
    @Autowired
    private DiscussService discussService;

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
    public Map<String,Object> showVideo(Integer vId){
        Map<String,Object> map =new HashMap<>();
        if (vId!=null){
            map = re.SUCCESSOBJ(service.selectId(vId));
            //        查询评价
            map.put("discuss",disTo.convert(0,discussService.selectByVId(vId)));
            return map;
        }
        return re.ERROR();

    }
//    删除视频
    @RequestMapping("/delectVideo")
    public Map<String,Object> delectVideo(int vId){
        service.delectById(vId);
        return re.SUCCESS();
    }
//    视频修改
    @RequestMapping("/updateVideo")
    public Map<String,Object>updateVideo(@RequestBody VideoContent video){
        if (video.getvId()!=null){
            service.updateVideo(video);
            return re.SUCCESS();
        }
        return re.ERROR();
    }
}
