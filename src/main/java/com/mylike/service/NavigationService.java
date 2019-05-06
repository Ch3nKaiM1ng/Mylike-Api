package com.mylike.service;

import com.mylike.entity.Navigation;

import java.util.List;

public interface NavigationService {
    List<Navigation> selectAll(String nBelong);

    void insert(List<Navigation> nav);
}
