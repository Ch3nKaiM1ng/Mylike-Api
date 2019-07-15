package com.mylike.service.Impl;

import com.mylike.entity.UserManage;
import com.mylike.mapper.UserManageMapper;
import com.mylike.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired(required = false)
    private UserManageMapper mapper;
    @Override
    public List<UserManage> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public UserManage selectObj(UserManage userManage) {
        return mapper.selectByPrimaryKey(userManage);
    }

    @Override
    public void updateObj(UserManage userManage) {
        mapper.updateByPrimaryKey(userManage);
    }

    @Override
    public void delectById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }
}
