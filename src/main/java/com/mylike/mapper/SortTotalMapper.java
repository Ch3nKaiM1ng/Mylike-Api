package com.mylike.mapper;

import com.mylike.entity.SortTotal;
import java.util.List;

public interface SortTotalMapper {
    int deleteByPrimaryKey(Integer sTid);

    int insert(SortTotal record);

    SortTotal selectByPrimaryKey(Integer sTid);

    List<SortTotal> selectAll();

    int updateByPrimaryKey(SortTotal record);
}