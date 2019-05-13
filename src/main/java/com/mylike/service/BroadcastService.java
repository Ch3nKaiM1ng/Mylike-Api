package com.mylike.service;

import com.mylike.entity.Broadcast;

import java.util.List;

public interface BroadcastService {
    List<Broadcast> selectAll(String bBelong);

    void update(Broadcast broadcast);

    void delectById(Integer bId);
}
