package com.mylike.service;

import com.mylike.entity.FloatWindow;
import com.mylike.entity.UserManage;

import java.util.List;

public interface UserManageService {
    List<UserManage> selectAll();

    UserManage selectObj(UserManage userManage);

    void updateObj(UserManage userManage);

    void delectById(Integer id);
}
