package com.mylike.utils;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class DateUtils {

//    当前时间
    public Date NewDate(){
        Date date = new Date();
        return date;
    }
//    格式化时间
    public String Fornat(Date date){
        DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }
}
