package com.mylike.service.Impl;

import com.mylike.entity.Anonymity;
import com.mylike.mapper.AnonymityMapper;
import com.mylike.service.AnonymityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnonymityServiceImpl implements AnonymityService {
    @Autowired
    private AnonymityMapper mapper;

    @Override
    public List<Anonymity> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void addName(Anonymity anonymity) {
        mapper.insert(anonymity);
    }


}
