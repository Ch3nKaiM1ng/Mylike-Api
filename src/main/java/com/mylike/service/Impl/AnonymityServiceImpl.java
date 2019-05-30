package com.mylike.service.Impl;

import com.mylike.entity.Anonymity;
import com.mylike.mapper.AnonymityMapper;
import com.mylike.service.AnonymityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        anonymity.setaAddtime(new Date());
        mapper.insert(anonymity);
    }

    @Override
    public int update(Anonymity anonymity) {
        return this.mapper.updateByPrimaryKeySelective(anonymity);
    }

    @Override
    public int delete(Integer aId) {
        return this.mapper.deleteByPrimaryKey(aId);
    }

    /**
     * 根据主键查询匿名详情
     */
    @Override
    public Anonymity showById(Integer aId) {
        return this.mapper.selectByPrimaryKey(aId);
    }


}
