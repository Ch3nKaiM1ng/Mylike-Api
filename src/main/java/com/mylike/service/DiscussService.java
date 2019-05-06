package com.mylike.service;

import com.mylike.entity.Discuss;

import java.util.List;

public interface DiscussService {
    void insert(Discuss discuss);

    List<Discuss> selectByDId(Integer dId);

    List<Discuss> showDiscussById(int parentId);
}
