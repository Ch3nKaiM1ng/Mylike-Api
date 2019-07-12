package com.mylike.service;

import com.mylike.entity.Search;

import java.util.List;

public interface SearchService {
    List<Search> select(String sBelong);

    Integer insert(Search search);

    int delect(Integer sId);
}
