package com.mylike.mapper;

import com.mylike.entity.BannerImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerImgMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(BannerImg record);

    BannerImg selectByPrimaryKey(Integer bId);

    List<BannerImg> selectAll(@Param("bBelong") String bBelong, @Param("bSite") String bSite);

    int updateByPrimaryKey(BannerImg record);
}