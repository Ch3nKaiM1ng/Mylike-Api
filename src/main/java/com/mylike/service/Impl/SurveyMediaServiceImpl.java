package com.mylike.service.Impl;

import com.mylike.entity.SurveyMedia;
import com.mylike.mapper.SurveyMediaMapper;
import com.mylike.service.SurveyMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SurveyMediaServiceImpl implements SurveyMediaService {

    @Autowired
    private SurveyMediaMapper surveyMediaMapper;

    /**
     * 根据小渠道查询表单信息
     */
    @Override
    public List<SurveyMedia> showByChannel(String channel) {
        return surveyMediaMapper.selectByChannel(channel);
    }


    /**
     * 添加/修改小渠道表单信息
     */
    @Override
    public int addOrUpdate(SurveyMedia surveyMedia) {
        if (surveyMedia.getId() == null) {
            surveyMedia.setAddtime(new Date());
            return this.surveyMediaMapper.insertSelective(surveyMedia);
        } else {
            return this.surveyMediaMapper.updateByPrimaryKeySelective(surveyMedia);
        }
    }


}
