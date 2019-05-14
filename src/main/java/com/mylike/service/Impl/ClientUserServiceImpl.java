package com.mylike.service.Impl;

import com.mylike.entity.ClientUser;
import com.mylike.mapper.ClientUserMapper;
import com.mylike.service.ClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ClientUserServiceImpl implements ClientUserService {


    @Autowired
    private ClientUserMapper clientUserMapper;

    /**
     * 保存/修改用户信息
     */
    @Override
    public int addOrUpdate(ClientUser clientUser) {
        if (clientUser.getcId() == null) {
            clientUser.setcAddtime(new Date());
            return this.clientUserMapper.insertSelective(clientUser);
        } else {
            //修改用户信息
            return this.clientUserMapper.updateByPrimaryKeySelective(clientUser);
        }

    }

    @Override
    public ClientUser showByPhone(String phone) {
        return this.clientUserMapper.selectByPhone(phone);
    }

}
