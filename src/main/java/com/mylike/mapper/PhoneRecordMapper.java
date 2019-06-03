package com.mylike.mapper;

import com.mylike.entity.PhoneRecord;

public interface PhoneRecordMapper {

    int insertSelective(PhoneRecord record);
    int updateByPrimaryKeySelective(PhoneRecord phoneRecord);
}