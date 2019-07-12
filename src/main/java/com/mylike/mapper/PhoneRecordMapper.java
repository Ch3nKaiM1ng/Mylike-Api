package com.mylike.mapper;

import com.mylike.entity.PhoneRecord;

import java.util.List;

public interface PhoneRecordMapper {

    int insertSelective(PhoneRecord record);
    int updateByPrimaryKeySelective(PhoneRecord phoneRecord);

    List<PhoneRecord> selectAll();

    int delect(Integer id);
}