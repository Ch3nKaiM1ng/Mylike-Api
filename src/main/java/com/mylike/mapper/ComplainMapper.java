package com.mylike.mapper;

import com.mylike.entity.Complain;
import java.util.List;

public interface ComplainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Complain record);

    Complain selectByPrimaryKey(Integer id);

    List<Complain> selectAll();

    int updateByPrimaryKey(Complain record);

    List<Complain> selectByState(Integer state);
}