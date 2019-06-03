package com.mylike.service.Impl;

import com.mylike.entity.PhoneRecord;
import com.mylike.mapper.PhoneRecordMapper;
import com.mylike.service.PhoneRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PhoneRecordServiceImpl implements PhoneRecordService {

    @Autowired
    private PhoneRecordMapper phoneRecordMapper;

    @Override
    public int addOrUpdate(PhoneRecord phoneRecord) {

        if (phoneRecord.getId()==null){
            phoneRecord.setAddtime(new Date());
            return this.phoneRecordMapper.insertSelective(phoneRecord);
        }else {
            return this.phoneRecordMapper.updateByPrimaryKeySelective(phoneRecord);
        }
    }
}
