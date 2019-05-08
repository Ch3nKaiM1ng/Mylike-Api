package com.mylike.mapper;

import com.mylike.entity.Verification;
import java.util.List;

public interface VerificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Verification record);

    Verification selectByPrimaryKey(Integer id);

    List<Verification> selectAll();

    int updateByPrimaryKey(Verification record);
}