package com.mylike.service.Impl;


import com.mylike.entity.Discuss;
import com.mylike.entity.VideoContent;
import com.mylike.mapper.DiscussMapper;
import com.mylike.mapper.VideoContentMapper;
import com.mylike.service.VideoContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideoContentServiceImpl implements VideoContentService {
    @Autowired
    private VideoContentMapper videoContentMapper;
    @Autowired
    private DiscussMapper discussMapper;


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

    @Transactional
    @Override
    public void delectById(int vId) {
        int count = videoContentMapper.deleteByPrimaryKey(vId);
        if (count > 0) {
            //删除评论
            Discuss discuss = new Discuss();
            discuss.setvId(vId);
            this.discussMapper.deleteByRelationId(discuss);
        }
    }

    @Override
    public List<VideoContent> showVideoContentsByTitle(String title) {
        return videoContentMapper.selectVideoContentsByTitle(title);
    }

    @Override
    public void updateVideo(VideoContent video) {
        videoContentMapper.updateByPrimaryKeySelective(video);
    }

    @Override
    public List<VideoContent> showVideoContentsByLabel(String label) {
        return this.videoContentMapper.selectVideoContentsByLabel(label);
    }

    @Override
    public int addBrowseNum(Integer vId) {
        return this.videoContentMapper.addBrowseNum(vId);
    }
}
