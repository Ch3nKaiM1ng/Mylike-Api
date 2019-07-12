package com.mylike.service.Impl;

import com.mylike.entity.PhoneRecord;
import com.mylike.mapper.PhoneRecordMapper;
import com.mylike.service.PhoneRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public List<PhoneRecord> showPhone() {
        return this.phoneRecordMapper.selectAll();
    }

    @Override
    public int delect(Integer id) {
        return this.phoneRecordMapper.delect(id);
    }

    @Override
    public Integer updateState(Integer id) {
        PhoneRecord record = new PhoneRecord();
        record.setState("1");
        record.setId(id);
        return this.addOrUpdate(record);
    }

}
