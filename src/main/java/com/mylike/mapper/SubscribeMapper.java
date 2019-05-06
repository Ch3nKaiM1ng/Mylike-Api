package com.mylike.mapper;

import com.mylike.entity.Subscribe;
import java.util.List;

public interface SubscribeMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Subscribe record);

    Subscribe selectByPrimaryKey(Integer sId);

    List<Subscribe> selectAll();

    int updateByPrimaryKey(Subscribe record);
}