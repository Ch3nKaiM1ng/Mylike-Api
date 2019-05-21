package com.mylike.entity;

import java.io.Serializable;

public class VideoContent implements Serializable {
    private Integer vId;

    private String vName;

    private String vHeadpic;

    private String vTitle;

    private String vContent;

    private String vVideourl;

    private String vImgurl;

    private Integer vLike;

    private String vUrl;

    private String vHot;

    private String vLabel;

    public String getvLabel() {
        return vLabel;
    }

    public void setvLabel(String vLabel) {
        this.vLabel = vLabel;
    }

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName == null ? null : vName.trim();
    }

    public String getvHeadpic() {
        return vHeadpic;
    }

    public void setvHeadpic(String vHeadpic) {
        this.vHeadpic = vHeadpic == null ? null : vHeadpic.trim();
    }

    public String getvTitle() {
        return vTitle;
    }

    public void setvTitle(String vTitle) {
        this.vTitle = vTitle == null ? null : vTitle.trim();
    }

    public String getvContent() {
        return vContent;
    }

    public void setvContent(String vContent) {
        this.vContent = vContent == null ? null : vContent.trim();
    }

    public String getvVideourl() {
        return vVideourl;
    }

    public void setvVideourl(String vVideourl) {
        this.vVideourl = vVideourl == null ? null : vVideourl.trim();
    }

    public String getvImgurl() {
        return vImgurl;
    }

    public void setvImgurl(String vImgurl) {
        this.vImgurl = vImgurl == null ? null : vImgurl.trim();
    }

    public Integer getvLike() {
        return vLike;
    }

    public void setvLike(Integer vLike) {
        this.vLike = vLike;
    }

    public String getvUrl() {
        return vUrl;
    }

    public void setvUrl(String vUrl) {
        this.vUrl = vUrl == null ? null : vUrl.trim();
    }

    public String getvHot() {
        return vHot;
    }

    public void setvHot(String vHot) {
        this.vHot = vHot == null ? null : vHot.trim();
    }
}