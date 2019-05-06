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
    public void insert(List<Search> search) {
        for (Search se:search){
            if (se.getsAddtime()==null){
                se.setsAddtime(new Date());
            }
            mapper.insert(se);
        }
    }
}
