package com.mylike.service;


import com.mylike.entity.Anonymity;

import java.util.List;

public interface AnonymityService {
    List<Anonymity> selectAll();

    void addName(Anonymity anonymity);
}
