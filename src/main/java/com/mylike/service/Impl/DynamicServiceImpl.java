package com.mylike.service.Impl;


import com.mylike.entity.Dynamic;
import com.mylike.entity.Material;
import com.mylike.entity.MaterialRelevance;
import com.mylike.mapper.DiscussMapper;
import com.mylike.mapper.DynamicMapper;
import com.mylike.mapper.MaterialMapper;
import com.mylike.mapper.MaterialRelevanceMapper;
import com.mylike.service.DynamicService;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DynamicServiceImpl implements DynamicService {

//    动态库
    @Autowired
    private DynamicMapper dynamicMapper;
//    素材关联库
    @Autowired
    private MaterialRelevanceMapper relevanceMapper;
//    素材库
    @Autowired
    private MaterialMapper materialMapper;

    MaterialRelevance relevance = new MaterialRelevance();
    Material material = new Material();
    private ReturnDiscern re = new ReturnDiscern();

    @Override
    public void insert(Dynamic dynamic) {
        if (dynamic.getVideoUrl().equals("")){
            System.out.println("success!");
        }
        dynamicMapper.insert(dynamic);
        if (dynamic.getdId()!=null){
            relevance.setrId(null);
            relevance.setdId(dynamic.getdId());
            relevanceMapper.insert(relevance);
            if (relevance.getrId()!=null){
                material.setmId(null);
                material.setrId(relevance.getrId());
                System.out.println("-------"+dynamic.getVideoUrl()+"----");

                if (dynamic.getVideoUrl().equals("")) {
                    String[] urlArray=dynamic.getImgUrl().split(",");
                    material.setmBlong(re.img());
                    for (int i = 0;i<urlArray.length;i++){
                        material.setmUrl(urlArray[i]);
                        materialMapper.insert(material);
                    }
                }else if (dynamic.getImgUrl().equals("")){
                    material.setmUrl(dynamic.getVideoUrl());
                    material.setmBlong(re.video());
                    materialMapper.insert(material);
                }
            }
        }
    }

    @Override
    public Map<String, Object> selectAll() {
        Map<String,Object> map = new HashMap<>();
        List<Dynamic> dynamic = dynamicMapper.selectAll();
        for (Dynamic dynamics:dynamic){
            if (dynamics.getdId()!=null){
                System.out.println("error");
                relevance = relevanceMapper.selectByDId(dynamics.getdId());
                if (relevance.getrId()!=null){
                    dynamics.setMaterials(materialMapper.selectByRId(relevance.getrId()));
                }
            }
        }
        map.put("data",dynamic);
        return map;
    }

//    单个查询

    @Override
    public Dynamic showDynamicById(Integer dId) {
        Dynamic dynamic =dynamicMapper.selectByPrimaryKey(dId);
        if (dynamic.getdId()!=null){
            relevance = relevanceMapper.selectByDId(dynamic.getdId());
            if (relevance.getrId()!=null){
                dynamic.setMaterials(materialMapper.selectByRId(relevance.getrId()));
            }
        }
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
        dynamicMapper.updateByPrimaryKey(dynamic);
    }
}
