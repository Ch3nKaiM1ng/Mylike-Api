package com.mylike.mapper;


import com.baomidou.mybatisplus.plugins.Page;
import com.mylike.entity.Dynamic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Dynamic record);

    Dynamic selectByPrimaryKey(Integer dId);

    List<Dynamic> selectAll();

    int updateByPrimaryKeySelective(Dynamic record);

    void dynamicLike(Integer dId);

    List<Dynamic> showAll();

    List<Dynamic> selectDynamicsByLabel(@Param("label") String label);

    List<Dynamic> selectcForHide(@Param("startId") Integer startId, @Param("endId") Integer endId);

    int addBrowseNum(@Param("dId") Integer dId);

    List<Dynamic> selectDynamicList(Page page);

    int updateHideOrDisplay(@Param("dId") Integer dId, @Param("dHot") String hide);
}