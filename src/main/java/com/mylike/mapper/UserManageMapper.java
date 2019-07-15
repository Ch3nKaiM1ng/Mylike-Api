package com.mylike.mapper;

import com.mylike.entity.FloatWindow;
import com.mylike.entity.UserManage;

import java.util.List;

public interface UserManageMapper {
    List<UserManage> selectAll();

    int insert(UserManage userManager);

    UserManage selectByPrimaryKey(UserManage userManager);

    int updateByPrimaryKey(UserManage userManager);

    int deleteByPrimaryKey(Integer Id);
}