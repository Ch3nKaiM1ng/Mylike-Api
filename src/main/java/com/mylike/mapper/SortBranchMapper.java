package com.mylike.mapper;

import com.mylike.entity.SortBranch;
import java.util.List;

public interface SortBranchMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(SortBranch record);

    SortBranch selectByPrimaryKey(Integer sId);

    List<SortBranch> selectAll();

    int updateByPrimaryKey(SortBranch record);
}