package com.mylike.service.Impl;


import com.mylike.entity.Discuss;
import com.mylike.entity.Dynamic;
import com.mylike.entity.Material;
import com.mylike.entity.MaterialRelevance;
import com.mylike.mapper.DiscussMapper;
import com.mylike.mapper.DynamicMapper;
import com.mylike.service.DynamicService;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DynamicServiceImpl implements DynamicService {

    //    动态库
    @Autowired
    private DynamicMapper dynamicMapper;
    @Autowired
    private DiscussMapper discussMapper;

    MaterialRelevance relevance = new MaterialRelevance();
    Material material = new Material();
    private ReturnDiscern re = new ReturnDiscern();

    @Override
    public void insert(Dynamic dynamic) {
        if (dynamic.getVideoUrl() == null) {
            System.out.println("success!");
        }
        dynamicMapper.insert(dynamic);
    }

    @Override
    public List<Dynamic> selectAll() {
        List<Dynamic> dynamic = dynamicMapper.selectAll();
        return dynamic;
    }

//    单个查询

    @Override
    public Dynamic showDynamicById(Integer dId) {
        Dynamic dynamic = dynamicMapper.selectByPrimaryKey(dId);
        return dynamic;
    }

    //    文章点赞
    @Override
    public void dynamicLike(Integer dId) {
        dynamicMapper.dynamicLike(dId);
    }

    //文章更新
    @Override
    public void updateDynamic(Dynamic dynamic) {
        dynamicMapper.updateByPrimaryKeySelective(dynamic);
    }

    @Transactional
    @Override
    public void delecetDynamic(Integer dId) {
        int count = dynamicMapper.deleteByPrimaryKey(dId);
        if (count > 0) {
            Discuss discuss = new Discuss();
            discuss.setdId(dId);
            this.discussMapper.deleteByRelationId(discuss);
        }
    }

    @Override
    public List<Dynamic> showAll() {
        return dynamicMapper.showAll();
    }

    @Override
    public List<Dynamic> showDynamicsByLabel(String label) {
        return this.dynamicMapper.selectDynamicsByLabel(label);
    }
}
