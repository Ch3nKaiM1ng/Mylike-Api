package com.mylike.mapper;

import com.mylike.entity.SurveyMedia;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SurveyMediaMapper {

    int insertSelective(SurveyMedia record);

    SurveyMedia selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SurveyMedia record);

    List<SurveyMedia> selectByChannel(@Param("channel") String channel);
}