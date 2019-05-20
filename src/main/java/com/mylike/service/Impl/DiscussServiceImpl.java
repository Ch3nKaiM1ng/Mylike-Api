package com.mylike.service.Impl;

import com.mylike.entity.Anonymity;
import com.mylike.entity.Discuss;
import com.mylike.mapper.AnonymityMapper;
import com.mylike.mapper.DiscussMapper;
import com.mylike.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DiscussServiceImpl implements DiscussService {
    @Autowired
    private DiscussMapper mapper;
    @Autowired
    private AnonymityMapper anonymityMapper;

    //    添加评论
    public void insert(Discuss discuss) {
        int num = anonymityMapper.seleceCount();
        int nums = new Random().nextInt(num - 0) + 0;
        Anonymity anonymity = anonymityMapper.selectBywhere(nums);
        discuss.setAnId(anonymity.getaId());
        mapper.insert(discuss);
    }

    //    心得/动态单个查询
    @Override
    public List<Discuss> selectByDId(Integer dId) {
        return mapper.selectByDid(dId);
    }

    //    评论单个查询
    @Override
    public List<Discuss> showDiscussById(int parentId) {
        return mapper.selectByPrimaryKey(parentId);
    }

    //  视频评论查询
    @Override
    public List<Discuss> selectByVId(int vId) {
        return mapper.selectByVid(vId);
    }

    @Override
    public List<Discuss> selectByAId(Integer aId) {
        return mapper.selectByAid(aId);
    }

    @Override
    public Integer showCountByDid(Integer dId) {
        return this.mapper.countByDid(dId);
    }

    @Override
    public Integer showCountByVid(Integer vId) {
        return this.mapper.countByVid(vId);
    }

    @Override
    public Integer showCountByAid(Integer aId) {
        return this.mapper.countByAid(aId);
    }

    /**
     * 修改评论
     */
    @Override
    public int update(Discuss discuss) {
        return this.mapper.updateByPrimaryKeySelective(discuss);
    }


    @Override
    public int deleteByRelationId(Discuss discuss) {
        return this.mapper.deleteByRelationId(discuss);
    }


}
