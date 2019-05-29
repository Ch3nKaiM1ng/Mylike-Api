package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Navigation implements Serializable {
    private Integer nId;

    private String nName;

    private String nUrl;

    private String nRank;

    private String nBelong;

    private String mStatus;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date mAddtime;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName == null ? null : nName.trim();
    }

    public String getnUrl() {
        return nUrl;
    }

    public void setnUrl(String nUrl) {
        this.nUrl = nUrl == null ? null : nUrl.trim();
    }

    public String getnRank() {
        return nRank;
    }

    public void setnRank(String nRank) {
        this.nRank = nRank == null ? null : nRank.trim();
    }

    public String getnBelong() {
        return nBelong;
    }

    public void setnBelong(String nBelong) {
        this.nBelong = nBelong == null ? null : nBelong.trim();
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus == null ? null : mStatus.trim();
    }

    public Date getmAddtime() {
        return mAddtime;
    }

    public void setmAddtime(Date mAddtime) {
        this.mAddtime = mAddtime;
    }

    @Override
    public String toString() {
        return "Navigation{" +
                "nId=" + nId +
                ", nName='" + nName + '\'' +
                ", nUrl='" + nUrl + '\'' +
                ", nRank='" + nRank + '\'' +
                ", nBelong='" + nBelong + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mAddtime=" + mAddtime +
                '}';
    }
}