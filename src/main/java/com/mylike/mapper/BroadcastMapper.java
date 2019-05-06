package com.mylike.mapper;

import com.mylike.entity.Broadcast;
import java.util.List;

public interface BroadcastMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Broadcast record);

    Broadcast selectByPrimaryKey(Integer bId);

    List<Broadcast> selectAll(String bBelong);

    int updateByPrimaryKey(Broadcast record);
}