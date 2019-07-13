package com.mylike.service.Impl;

import com.mylike.entity.FloatWindow;
import com.mylike.mapper.FloatWindowMapper;
import com.mylike.service.FloatWindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloatWindowServiceImpl implements FloatWindowService {

    @Autowired(required = false)
    private FloatWindowMapper mapper;
    @Override
    public List<FloatWindow> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public FloatWindow selectObj(FloatWindow floatWindow) {
        return mapper.selectByPrimaryKey(floatWindow);
    }

    @Override
    public void insertFloat(FloatWindow floatWindow) {
        mapper.insert(floatWindow);
    }


    @Override
    public void updateFloat(FloatWindow floatWindow) {
        mapper.updateByPrimaryKey(floatWindow);
    }

    @Override
    public void delectById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }
}
