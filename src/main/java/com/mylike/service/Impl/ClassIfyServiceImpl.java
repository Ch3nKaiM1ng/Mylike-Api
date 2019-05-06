package com.mylike.service.Impl;

import com.mylike.entity.Classify;
import com.mylike.mapper.ClassifyMapper;
import com.mylike.service.ClassIfyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassIfyServiceImpl implements ClassIfyService {
    @Autowired
    private ClassifyMapper mapper;

    @Override
    public List<Classify> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void insert(List<Classify> ify) {
        for (Classify ifys:ify){
            mapper.insert(ifys);
        }
    }

    @Override
    public void updateIfy(Classify classify) {
        mapper.updateByPrimaryKey(classify);
    }
}
