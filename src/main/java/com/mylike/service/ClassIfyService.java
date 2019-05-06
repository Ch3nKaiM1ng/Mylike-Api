package com.mylike.service;

import com.mylike.entity.Classify;

import java.util.List;

public interface ClassIfyService {
    List<Classify> selectAll();

    void insert(List<Classify> ify);

    void updateIfy(Classify classify);
}
