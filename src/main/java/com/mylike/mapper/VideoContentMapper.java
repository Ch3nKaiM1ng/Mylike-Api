package com.mylike.mapper;

import com.mylike.entity.VideoContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoContentMapper {
    int deleteByPrimaryKey(Integer vId);

    int insert(VideoContent record);

    VideoContent selectByPrimaryKey(Integer vId);

    List<VideoContent> selectAll(@Param("startId") int startId, @Param("endId") int endId);

    int updateByPrimaryKeySelective(VideoContent record);

    /**
     * 根据title查询视频内容
     */
    List<VideoContent> selectVideoContentsByTitle(@Param("title") String title);

    /**
     * 根据标签查询视频neiro
     */
    List<VideoContent> selectVideoContentsByLabel(@Param("label")String label);
}