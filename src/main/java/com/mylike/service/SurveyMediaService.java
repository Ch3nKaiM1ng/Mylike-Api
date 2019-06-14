package com.mylike.service;

import com.mylike.entity.SurveyMedia;

import java.util.List;

public interface SurveyMediaService {

    /**
     * 根据渠道查询表单信息
     */
    public List<SurveyMedia> showByChannel(String channel);

    /**
     * 添加/修改小渠道表单信息
     */
    public int addOrUpdate(SurveyMedia surveyMedia);

    int delect(Integer id);
}
