package com.mylike.entity;

import java.io.Serializable;
import java.util.Date;

public class Classify implements Serializable {
    private Integer cId;

    private String cName;

    private String cImg;

    private String cUrl;

    private String cRank;

    private String cStatus;

    private Date cAddtime;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcImg() {
        return cImg;
    }

    public void setcImg(String cImg) {
        this.cImg = cImg == null ? null : cImg.trim();
    }

    public String getcUrl() {
        return cUrl;
    }

    public void setcUrl(String cUrl) {
        this.cUrl = cUrl == null ? null : cUrl.trim();
    }

    public String getcRank() {
        return cRank;
    }

    public void setcRank(String cRank) {
        this.cRank = cRank == null ? null : cRank.trim();
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus == null ? null : cStatus.trim();
    }

    public Date getcAddtime() {
        return cAddtime;
    }

    public void setcAddtime(Date cAddtime) {
        this.cAddtime = cAddtime;
    }
}