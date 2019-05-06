package com.mylike.service;

import com.mylike.entity.Sort;

import java.util.List;

public interface SortService {
    List<Sort> selectAll();

    List<Sort> showSortById(Integer sSid);

    void insert(Sort sort);

    void delectSort(int sId);
}
