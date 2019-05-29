package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class BannerImg implements Serializable {
    private Integer bId;

    private String bName;

    private String bUrl;

    private String bSite;

    private String bStatus;

    private String bBelong;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date bAddtime;

    private String title;

    private String intro;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbUrl() {
        return bUrl;
    }

    public void setbUrl(String bUrl) {
        this.bUrl = bUrl == null ? null : bUrl.trim();
    }

    public String getbSite() {
        return bSite;
    }

    public void setbSite(String bSite) {
        this.bSite = bSite == null ? null : bSite.trim();
    }

    public String getbStatus() {
        return bStatus;
    }

    public void setbStatus(String bStatus) {
        this.bStatus = bStatus == null ? null : bStatus.trim();
    }

    public String getbBelong() {
        return bBelong;
    }

    public void setbBelong(String bBelong) {
        this.bBelong = bBelong == null ? null : bBelong.trim();
    }

    public Date getbAddtime() {
        return bAddtime;
    }

    public void setbAddtime(Date bAddtime) {
        this.bAddtime = bAddtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}