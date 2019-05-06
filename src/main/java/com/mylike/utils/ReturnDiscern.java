package com.mylike.utils;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ReturnDiscern {
    public Map<String,Object> SUCCESS(){
        Map<String,Object> map = new HashMap<>();
        map.put("data","0");
        map.put("content","提交成功！");
        return map;
    }
    public Map<String,Object> ERROR(){
        Map<String,Object> map = new HashMap<>();
        map.put("data","-1");
        map.put("content","提交失败！");
        return map;
    }
    public Map<String,Object> SUCCESSOBJ(Object obj){
        Map<String,Object> map = new HashMap<>();
        map.put("data","0");
        map.put("content","提交成功！");
        map.put("obj",obj);
        return map;
    }
    public String video(){
        return "video";
    }
    public String img(){
        return "img";
    }
}
