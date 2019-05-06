package com.mylike.mapper;

import com.mylike.entity.Material;
import java.util.List;

public interface MaterialMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Material record);

    Material selectByPrimaryKey(Integer mId);

    List<Material> selectAll();

    int updateByPrimaryKey(Material record);

    List<Material> selectByRId(Integer getrId);
}