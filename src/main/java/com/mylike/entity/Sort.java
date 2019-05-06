package com.mylike.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Sort implements Serializable {
    private Integer sId;

    private String sName;

    private Integer sSid;

    private Date sAddtime;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Integer getsSid() {
        return sSid;
    }

    public void setsSid(Integer sSid) {
        this.sSid = sSid;
    }

    public Date getsAddtime() {
        return sAddtime;
    }

    public void setsAddtime(Date sAddtime) {
        this.sAddtime = sAddtime;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sSid=" + sSid +
                ", sAddtime=" + sAddtime +
                '}';
    }
}