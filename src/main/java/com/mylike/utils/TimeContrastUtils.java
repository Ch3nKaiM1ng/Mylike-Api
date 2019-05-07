package com.mylike.utils;

import java.text.SimpleDateFormat;

public class TimeContrastUtils {

    public String TimeContrast(String startDate,int minute){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String start = "0";
        try {
            start = String.valueOf(format.parse(startDate).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long time = System.currentTimeMillis();
        String endDate = String.valueOf(time/1000);
        int interval = Integer.parseInt(endDate) - Integer.parseInt(start);
        if (interval>(minute*60)){
            return "error";
        }
        return "success";
    }
}
