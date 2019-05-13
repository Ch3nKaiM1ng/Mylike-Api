package com.mylike.service.Impl;

import com.mylike.entity.Broadcast;
import com.mylike.mapper.BroadcastMapper;
import com.mylike.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastServiceImpl implements BroadcastService{
    @Autowired
    public BroadcastMapper mapper;

    @Override
    public List<Broadcast> selectAll(String bBelong) {
        return mapper.selectAll(bBelong);
    }

    @Override
    public void update(Broadcast broadcast) {
        mapper.updateByPrimaryKey(broadcast);
    }

    @Override
    public void delectById(Integer bId) {
        mapper.deleteByPrimaryKey(bId);
    }
}
