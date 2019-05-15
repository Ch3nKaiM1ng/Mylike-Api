package com.mylike.mapper;


import com.mylike.entity.Dynamic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Dynamic record);

    Dynamic selectByPrimaryKey(Integer dId);

    List<Dynamic> selectAll();

    int updateByPrimaryKey(Dynamic record);

    void dynamicLike(Integer dId);

    List<Dynamic> showAll();

    List<Dynamic> selectDynamicsByLabel(@Param("label")String label);
}