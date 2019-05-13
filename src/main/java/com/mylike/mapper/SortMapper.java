package com.mylike.mapper;

import com.mylike.entity.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Sort record);

    Sort selectByPrimaryKey(Integer sId);

    List<Sort> selectAll();

    int updateByPrimaryKey(Sort record);

    List<Sort> showSortById(Integer sSid);

    /**
     * 根据分类名称查询分类
     */
    List<Sort> selectSortsByName(@Param("name") String name);
}