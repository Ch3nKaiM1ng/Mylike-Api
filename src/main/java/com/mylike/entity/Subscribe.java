package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Subscribe implements Serializable {
    private Integer sId;

    private Integer dId;

    private String sName;

    private String sPhone;

    private String sDate;

    private String sTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sAddtime;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone == null ? null : sPhone.trim();
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate == null ? null : sDate.trim();
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime == null ? null : sTime.trim();
    }

    public Date getsAddtime() {
        return sAddtime;
    }

    public void setsAddtime(Date sAddtime) {
        this.sAddtime = sAddtime;
    }
}