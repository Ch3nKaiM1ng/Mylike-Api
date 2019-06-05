package com.mylike.service;

import com.mylike.entity.Discuss;

import java.util.List;

public interface DiscussService {
    void insert(Discuss discuss);

    List<Discuss> selectByDId(Integer dId);

    List<Discuss> showDiscussById(int parentId);

    List<Discuss> selectByVId(int vId);

    List<Discuss> selectByAId(Integer aId);

    /**
     * 根据心得id查询好评数
     */
    Integer showCountByDid(Integer dId);

    /**
     * 根据视频Id查询好评数
     */
    Integer showCountByVid(Integer vId);

    /**
     * 根据文章Id查询好评数
     */
    Integer showCountByAid(Integer aId);

    /**
     * 修改评论
     */
    int update(Discuss discuss);


    /**
     * 根据关联id删除评论
     */
    int deleteByRelationId(Discuss discuss);

    int delectById(Discuss discuss);
}
