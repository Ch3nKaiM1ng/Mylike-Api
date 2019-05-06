package com.mylike.service;


import com.mylike.entity.BannerImg;

import java.util.List;

public interface BannerImgService {
    List<BannerImg> selectAll(String bBelong,String bSite);

    void insert(List<BannerImg> banner);
}
