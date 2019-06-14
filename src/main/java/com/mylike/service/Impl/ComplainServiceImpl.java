package com.mylike.service.Impl;

import com.mylike.entity.Complain;
import com.mylike.mapper.ComplainMapper;
import com.mylike.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainServiceImpl implements ComplainService {
    @Autowired
    private ComplainMapper mapper;

    @Override
    public int install(Complain complain) {
        return mapper.insert(complain);
    }

    @Override
    public List<Complain> selectComplain(Integer state) {
        if (state == -1){
            return mapper.selectAll();
        }else{
            return mapper.selectByState(state);
        }
    }

    @Override
    public int updateState(Complain complain) {
        return mapper.updateByPrimaryKey(complain);
    }
}
