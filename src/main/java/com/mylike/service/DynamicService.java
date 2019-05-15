package com.mylike.service;

import com.mylike.entity.Dynamic;

import java.util.List;
import java.util.Map;

public interface DynamicService {
    void insert(Dynamic dynamic);

    List<Dynamic> selectAll();

    Dynamic showDynamicById(Integer dId);

    void dynamicLike(Integer dId);

    void updateDynamic(Dynamic dynamic);

    void delecetDynamic(Integer dId);

    List<Dynamic> showAll();

    List<Dynamic> showDynamicsByLabel(String label);
}
