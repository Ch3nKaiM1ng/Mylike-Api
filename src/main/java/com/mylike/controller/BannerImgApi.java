package com.mylike.controller;

import com.mylike.entity.BannerImg;
import com.mylike.service.BannerImgService;
import com.mylike.utils.ReturnDiscern;
import com.mylike.utils.UpdateImgNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


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
    public List<BannerImg> showBanner(String bBelong,String bSite){
        return service.selectAll(bBelong,bSite);
    }
//    添加banner
    @RequestMapping("/addBanner")
    public String addBanner(@RequestBody List<BannerImg> banner) {
        System.out.println(123);
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
