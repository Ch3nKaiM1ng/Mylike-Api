package com.mylike.utils;



import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MassageReturnUtils {
    public Map<String,Object> CodeVerify(JSONObject obj){
        Map<String,Object> map = new HashMap<>();
        if (obj.get("code").equals("000000")){
            map.put("data","0");
            map.put("content","提交成功！");
        }else if (obj.get("code").equals("100008")){
            map.put("data","-1");
            map.put("content",obj.get("msg"));
        } else if (obj.get("code").equals("100015")){
            map.put("data","-1");
            map.put("content",obj.get("msg"));
        }else if (obj.get("code").equals("105153")){
            map.put("data","-1");
            map.put("content",obj.get("msg"));
        }else if (obj.get("code").equals("300003")){
            map.put("data","-1");
            map.put("content",obj.get("msg"));
        }else if (obj.get("code").equals("300005")){
            map.put("data","-1");
            map.put("content","信息发送频率过高，请稍后重试！");
        }else if (obj.get("code").equals("300006")){
            map.put("data","-1");
            map.put("content","信息发送频率过高，请稍后重试！");
        }else if (obj.get("code").equals("105150")){
            map.put("data","-1");
            map.put("content","信息发送频率过高，请稍后重试！");
        }else if (obj.get("code").equals("105147")){
            map.put("data","-1");
            map.put("content","信息发送量已达上限，请第二天重试！");
        }
        return map;
    }
}
