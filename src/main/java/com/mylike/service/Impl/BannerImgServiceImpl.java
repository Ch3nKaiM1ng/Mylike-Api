package com.mylike.service.Impl;

import com.mylike.entity.BannerImg;
import com.mylike.mapper.BannerImgMapper;
import com.mylike.service.BannerImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerImgServiceImpl implements BannerImgService {

    @Autowired
    private BannerImgMapper mapper;

    @Override
    public List<BannerImg> selectAll(String bBelong,String bSite) {
//        System.out.println(bBelong+"-------------"+bSite);
        return mapper.selectAll(bBelong,bSite);
    }

    @Override
    public void insert(List<BannerImg> banner) {
        for (BannerImg img:banner){
            mapper.insert(img);
        }
    }
}
