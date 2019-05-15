package com.mylike.mapper;

import com.mylike.entity.Discuss;
import java.util.List;

public interface DiscussMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Discuss record);

    List<Discuss> selectByPrimaryKey(Integer id);

    List<Discuss> selectAll();

    int updateByPrimaryKey(Discuss record);

    List<Discuss> selectByDid(Integer dId);

    List<Discuss> selectByVid(Integer vId);

    List<Discuss> selectByAid(Integer aId);

    Integer countByDid(Integer dId);

    Integer countByVid(Integer vId);

    Integer countByAid(Integer aid);
}