package com.mylike.service;

import com.mylike.entity.Search;

import java.util.List;

public interface SearchService {
    List<Search> select(String sBelong);

    void insert(List<Search> search);

    int delect(Integer sId);
}
