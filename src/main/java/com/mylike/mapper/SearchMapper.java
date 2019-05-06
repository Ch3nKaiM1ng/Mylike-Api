package com.mylike.mapper;

import com.mylike.entity.Search;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface SearchMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Search record);

    Search selectByPrimaryKey(Integer sId);

    List<Search> selectAll(String sBelong);

    int updateByPrimaryKey(Search record);
}