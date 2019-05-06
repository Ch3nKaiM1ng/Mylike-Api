package com.mylike.service.Impl;

import com.mylike.entity.Sort;
import com.mylike.mapper.SortMapper;
import com.mylike.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortServiceImpl implements SortService {

    @Autowired
    private SortMapper mapper;
    @Override
    public List<Sort> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<Sort> showSortById(Integer sSid) {
        return mapper.showSortById(sSid);
    }

    @Override
    public void insert(Sort sort) {
        sort.setsSid(sort.getsSid()==null?0:sort.getsSid());
        mapper.insert(sort);
    }

    @Override
    public void delectSort(int sId) {
        mapper.deleteByPrimaryKey(sId);
    }
}
