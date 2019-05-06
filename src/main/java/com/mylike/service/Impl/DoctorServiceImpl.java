package com.mylike.service.Impl;

import com.mylike.entity.Doctor;
import com.mylike.entity.Subscribe;
import com.mylike.mapper.DoctorMapper;
import com.mylike.mapper.SubscribeMapper;
import com.mylike.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper mapper;
    @Autowired
    private SubscribeMapper submapper;
    @Override
    public List<Doctor> selectother() {
        return mapper.selectother();
    }

    @Override
    public Doctor selectAll(String did) {
        return mapper.selectByPrimaryKey(Integer.parseInt(did));
    }

    @Override
    public void insertSub(Subscribe subscribe) {
        submapper.insert(subscribe);
    }

    @Override
    public void insertdoctor(Doctor doctor) {
        mapper.insert(doctor);
    }

    @Override
    public Object selectDocAll() {
        return mapper.selectAll();
    }
}
