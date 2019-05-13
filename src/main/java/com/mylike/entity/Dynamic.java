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

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date dAddtime;

    private String dHot;


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
}