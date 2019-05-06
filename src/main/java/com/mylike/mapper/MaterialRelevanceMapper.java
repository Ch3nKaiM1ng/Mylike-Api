package com.mylike.mapper;

import com.mylike.entity.MaterialRelevance;
import java.util.List;

public interface MaterialRelevanceMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(MaterialRelevance record);

    MaterialRelevance selectByPrimaryKey(Integer rId);

    List<MaterialRelevance> selectAll();

    int updateByPrimaryKey(MaterialRelevance record);

    MaterialRelevance selectByDId(Integer dId);
}