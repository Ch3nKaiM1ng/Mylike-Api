package com.mylike.mapper;

import com.mylike.entity.Anonymity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnonymityMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Anonymity record);

    Anonymity selectByPrimaryKey(Integer aId);

    List<Anonymity> selectAll();

    int seleceCount();

    Anonymity selectBywhere(@Param("num") Integer num);

    int updateByPrimaryKeySelective(Anonymity anonymity);
}