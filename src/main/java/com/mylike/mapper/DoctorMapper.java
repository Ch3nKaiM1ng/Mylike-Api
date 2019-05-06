package com.mylike.mapper;

import com.mylike.entity.Doctor;
import java.util.List;

public interface DoctorMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Doctor record);

    Doctor selectByPrimaryKey(Integer dId);

    List<Doctor> selectAll();

    int updateByPrimaryKey(Doctor record);

    List<Doctor> selectother();
}