package com.mylike.service;

import com.mylike.entity.PhoneRecord;

import java.util.List;

public interface PhoneRecordService {

    int addOrUpdate(PhoneRecord phoneRecord);

    List<PhoneRecord> showPhone();

    int delect(Integer id);

    Integer updateState(Integer id);
}
