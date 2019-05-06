package com.mylike.mapper;

import com.mylike.entity.Classify;
import java.util.List;

public interface ClassifyMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Classify record);

    Classify selectByPrimaryKey(Integer cId);

    List<Classify> selectAll();

    int updateByPrimaryKey(Classify record);
}