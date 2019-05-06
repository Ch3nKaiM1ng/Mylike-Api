package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Search implements Serializable {
    private Integer sId;

    private String sName;

    private String sUrl;

    private Integer sRank;

    private String sBelong;

    private String sStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl == null ? null : sUrl.trim();
    }

    public Integer getsRank() {
        return sRank;
    }

    public void setsRank(Integer sRank) {
        this.sRank = sRank;
    }

    public String getsBelong() {
        return sBelong;
    }

    public void setsBelong(String sBelong) {
        this.sBelong = sBelong == null ? null : sBelong.trim();
    }

    public String getsStatus() {
        return sStatus;
    }

    public void setsStatus(String sStatus) {
        this.sStatus = sStatus == null ? null : sStatus.trim();
    }

    public Date getsAddtime() {
        return sAddtime;
    }

    public void setsAddtime(Date sAddtime) {
        this.sAddtime = sAddtime;
    }

    @Override
    public String toString() {
        return "Search{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sUrl='" + sUrl + '\'' +
                ", sRank=" + sRank +
                ", sBelong='" + sBelong + '\'' +
                ", sStatus='" + sStatus + '\'' +
                ", sAddtime=" + sAddtime +
                '}';
    }
}