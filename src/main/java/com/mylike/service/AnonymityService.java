package com.mylike.service;


import com.mylike.entity.Anonymity;

import java.util.List;

public interface AnonymityService {
    List<Anonymity> selectAll();

    void addName(Anonymity anonymity);

    int update(Anonymity anonymity);

    int delete(Integer aId);

    Anonymity showById(Integer aId);
}
