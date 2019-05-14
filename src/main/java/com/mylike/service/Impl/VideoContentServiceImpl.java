package com.mylike.service.Impl;


import com.mylike.entity.VideoContent;
import com.mylike.mapper.MaterialMapper;
import com.mylike.mapper.VideoContentMapper;
import com.mylike.service.VideoContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoContentServiceImpl implements VideoContentService {
    @Autowired
    private VideoContentMapper videoContentMapper;


    public void insert(VideoContent content) {

//        String[] nameStrArray=content.getmUrl().split(",");
        videoContentMapper.insert(content);

//        关联库
//        MaterialRelevance materialRelevance = new MaterialRelevance();
//        materialRelevance.setvId(content.getvId());
//        relevanceMapper.insert(materialRelevance);


//        System.out.println(content.getvId().toString());
    }

    @Override
    public List<VideoContent> selectAll(int startId, int endId) {
        int nums = 0;
        List<VideoContent> Contents = videoContentMapper.selectAll(startId, endId);
        return Contents;
    }

    @Override
    public VideoContent selectId(int vId) {
        return videoContentMapper.selectByPrimaryKey(vId);
    }

    @Override
    public void delectById(int vId) {
        videoContentMapper.deleteByPrimaryKey(vId);
    }

    @Override
    public List<VideoContent> showVideoContentsByTitle(String title) {
        return videoContentMapper.selectVideoContentsByTitle(title);
    }

    @Override
    public void updateVideo(VideoContent video) {
        videoContentMapper.updateByPrimaryKey(video);
    }
}
