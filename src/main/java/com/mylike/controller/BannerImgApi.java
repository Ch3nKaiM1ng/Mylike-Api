package com.mylike.controller;

import com.alibaba.fastjson.JSONObject;
import com.mylike.entity.BannerImg;
import com.mylike.service.BannerImgService;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/banner")
public class BannerImgApi {

    @Autowired
    private  BannerImgService service;

    private ReturnDiscern re = new ReturnDiscern();

//    查询banner
    @RequestMapping("/showBanner")
    public Map<String, Object> showBanner(String bBelong, String bSite){

        System.out.println(bBelong+bSite);
        List<BannerImg> banner = service.selectAll(bBelong,bSite);

        System.out.println(JSONObject.toJSON(banner).toString());

        return re.SUCCESSOBJ(banner);
    }
//    添加banner
    @RequestMapping("/addBanner")
    public String addBanner(@RequestBody List<BannerImg> banner) {
        service.insert(banner);
        return "success";
    }
//    更改Banner图片
    @RequestMapping("/updeteBanner")
    public Map<String,Object> updateBanner(@RequestBody BannerImg banner){
        if (banner.getbId()==null){
            return re.ERROR();
        }
        return re.SUCCESS();
    }
}
