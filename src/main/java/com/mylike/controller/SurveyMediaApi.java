package com.mylike.controller;

import com.mylike.entity.SurveyMedia;
import com.mylike.service.SurveyMediaService;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/surveyMedia")
public class SurveyMediaApi {


    @Autowired
    private SurveyMediaService surveyMediaService;

    private ReturnDiscern re = new ReturnDiscern();

    /**
     * 查询表单全部信息
     */
//    @RequestMapping("/showAll")
//    public Map<String, Object> showAll() {
//
//    }

    /**
     * 根据渠道查询表单所有内容
     */
    @RequestMapping("/showByChannel")
    public Map<String, Object> showByChannel(@RequestParam("channel") String channel) {

        List<SurveyMedia> surveyMedia = this.surveyMediaService.showByChannel(channel);

        return re.SUCCESSOBJ(surveyMedia);
    }

    @RequestMapping("/addOrUpdate")
    public Map<String, Object> addOrUpdate(@RequestBody SurveyMedia surveyMedia) {

        int count = this.surveyMediaService.addOrUpdate(surveyMedia);

        if (count <= 0) {
            return re.ERROR();
        } else {
            return re.SUCCESS();
        }

    }
}
