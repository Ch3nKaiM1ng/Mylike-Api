package com.mylike.mapper;

import com.mylike.entity.Navigation;
import java.util.List;

public interface NavigationMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Navigation record);

    Navigation selectByPrimaryKey(Integer nId);

    List<Navigation> selectAll(String nBelong);

    int updateByPrimaryKey(Navigation record);
}