package com.mylike.mapper;

import com.mylike.entity.ShareContent;
import java.util.List;

public interface ShareContentMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(ShareContent record);

    ShareContent selectByPrimaryKey(Integer sId);

    List<ShareContent> selectAll();

    int updateByPrimaryKey(ShareContent record);
}