package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Dynamic implements Serializable {
    private Integer dId;

    private String dName;

    private String dHeadpic;

    private String dContent;

    private String dSite;

    private Integer dLike;

    private Integer dBrowse;

    private String imgUrl;

    private String videoUrl;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dAddtime;

    private String dHot;

    private String dLabel;

    private Integer dNum;

    private Integer sex;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getdLabel() {
        return dLabel;
    }

    public void setdLabel(String dLabel) {
        this.dLabel = dLabel;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdHeadpic() {
        return dHeadpic;
    }

    public void setdHeadpic(String dHeadpic) {
        this.dHeadpic = dHeadpic;
    }

    public String getdContent() {
        return dContent;
    }

    public void setdContent(String dContent) {
        this.dContent = dContent;
    }

    public String getdSite() {
        return dSite;
    }

    public void setdSite(String dSite) {
        this.dSite = dSite;
    }

    public Integer getdLike() {
        return dLike;
    }

    public void setdLike(Integer dLike) {
        this.dLike = dLike;
    }

    public Integer getdBrowse() {
        return dBrowse;
    }

    public void setdBrowse(Integer dBrowse) {
        this.dBrowse = dBrowse;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Date getdAddtime() {
        return dAddtime;
    }

    public void setdAddtime(Date dAddtime) {
        this.dAddtime = dAddtime;
    }


    public String getdHot() {
        return dHot;
    }

    public void setdHot(String dHot) {
        this.dHot = dHot;
    }

    public Integer getdNum() {
        return dNum;
    }

    public void setdNum(Integer dNum) {
        this.dNum = dNum;
    }

    @Override
    public String toString() {
        return "Dynamic{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dHeadpic='" + dHeadpic + '\'' +
                ", dContent='" + dContent + '\'' +
                ", dSite='" + dSite + '\'' +
                ", dLike=" + dLike +
                ", dBrowse=" + dBrowse +
                ", imgUrl='" + imgUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", dAddtime=" + dAddtime +
                ", dHot='" + dHot + '\'' +
                ", dLabel='" + dLabel + '\'' +
                ", dNum=" + dNum +
                ", sex=" + sex +
                '}';
    }
}