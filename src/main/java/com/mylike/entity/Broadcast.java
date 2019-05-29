package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


public class Broadcast implements Serializable {
    private Integer bId;

    private String bContent;

    private String bUrl;

    private String bRank;

    private String bBelong;

    private String bStatus;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date bAddtime;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent == null ? null : bContent.trim();
    }

    public String getbUrl() {
        return bUrl;
    }

    public void setbUrl(String bUrl) {
        this.bUrl = bUrl == null ? null : bUrl.trim();
    }

    public String getbRank() {
        return bRank;
    }

    public void setbRank(String bRank) {
        this.bRank = bRank == null ? null : bRank.trim();
    }

    public String getbBelong() {
        return bBelong;
    }

    public void setbBelong(String bBelong) {
        this.bBelong = bBelong == null ? null : bBelong.trim();
    }

    public String getbStatus() {
        return bStatus;
    }

    public void setbStatus(String bStatus) {
        this.bStatus = bStatus == null ? null : bStatus.trim();
    }

    public Date getbAddtime() {
        return bAddtime;
    }

    public void setbAddtime(Date bAddtime) {
        this.bAddtime = bAddtime;
    }
}