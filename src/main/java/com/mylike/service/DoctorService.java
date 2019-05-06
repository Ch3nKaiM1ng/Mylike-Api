package com.mylike.service;

import com.mylike.entity.Doctor;
import com.mylike.entity.Subscribe;

import java.util.List;
import java.util.Map;

public interface DoctorService {
    List<Doctor> selectother();

    Doctor selectAll(String did);

    void insertSub(Subscribe subscribe);

    void insertdoctor(Doctor doctor);

    Object selectDocAll();
}
