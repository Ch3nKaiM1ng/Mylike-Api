package com.mylike.service;

import com.mylike.entity.ClientUser;

public interface ClientUserService {
    /**
     * 保存/修改用户信息
     */
    public int addOrUpdate(ClientUser clientUser);

    /**
     * 根据手机号码查询用户信息
     */
    public ClientUser showByPhone(String phone);
}
