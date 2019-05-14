package com.mylike.mapper;

import com.mylike.entity.ClientUser;
import org.apache.ibatis.annotations.Param;

public interface ClientUserMapper {

    int insertSelective(ClientUser clientUser);

    int updateByPrimaryKeySelective(ClientUser clientUser);


    ClientUser selectByPhone(@Param("phone") String phone);
}