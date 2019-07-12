package com.mylike.service.Impl;

import com.mylike.entity.Search;
import com.mylike.mapper.SearchMapper;
import com.mylike.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchMapper mapper;
    @Override
    public List<Search> select(String sBelong) {
        return mapper.selectAll(sBelong);
    }

    @Override
    public Integer insert(Search search) {
           return mapper.insert(search);
    }

    @Override
    public int delect(Integer sId) {
        return this.mapper.deleteByPrimaryKey(sId);
    }
}
