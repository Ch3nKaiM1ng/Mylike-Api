package com.mylike.service;


import com.mylike.entity.VideoContent;

import java.util.List;

public interface VideoContentService {
    void insert(VideoContent content);

    List<VideoContent> selectAll(int startId, int endId);

    VideoContent selectId(int vId);

    void delectById(int vId);

    List<VideoContent> showVideoContentsByTitle(String title);
}
