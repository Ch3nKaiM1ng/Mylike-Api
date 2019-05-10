package com.mylike.utils;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

//    当前时间
    public Date NewDate(){
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        Date date = calendar.getTime();
        return date;
    }
//    格式化时间
    public String Fornat(Date date){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
        return format.format(date);
    }
}
