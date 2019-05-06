package com.mylike.service.Impl;

import com.mylike.entity.Navigation;
import com.mylike.mapper.NavigationMapper;
import com.mylike.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    private NavigationMapper mapper;
    @Override
    public List<Navigation> selectAll(String nBelong) {
        return mapper.selectAll(nBelong);
    }

    @Override
    public void insert(List<Navigation> nav) {
        for (Navigation navs: nav) {
            mapper.insert(navs);
        }
    }
}
