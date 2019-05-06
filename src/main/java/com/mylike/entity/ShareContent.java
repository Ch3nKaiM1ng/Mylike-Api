package com.mylike.entity;

import java.io.Serializable;
import java.util.Date;

public class ShareContent implements Serializable {
    private Integer sId;

    private String sName;

    private String sHeadpic;

    private String sContent;

    private Integer sLabel;

    private String sDistrict;

    private Integer sLike;

    private Integer sUrl;

    private Integer sBrowse;

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

    public String getsHeadpic() {
        return sHeadpic;
    }

    public void setsHeadpic(String sHeadpic) {
        this.sHeadpic = sHeadpic == null ? null : sHeadpic.trim();
    }

    public String getsContent() {
        return sContent;
    }

    public void setsContent(String sContent) {
        this.sContent = sContent == null ? null : sContent.trim();
    }

    public Integer getsLabel() {
        return sLabel;
    }

    public void setsLabel(Integer sLabel) {
        this.sLabel = sLabel;
    }

    public String getsDistrict() {
        return sDistrict;
    }

    public void setsDistrict(String sDistrict) {
        this.sDistrict = sDistrict == null ? null : sDistrict.trim();
    }

    public Integer getsLike() {
        return sLike;
    }

    public void setsLike(Integer sLike) {
        this.sLike = sLike;
    }

    public Integer getsUrl() {
        return sUrl;
    }

    public void setsUrl(Integer sUrl) {
        this.sUrl = sUrl;
    }

    public Integer getsBrowse() {
        return sBrowse;
    }

    public void setsBrowse(Integer sBrowse) {
        this.sBrowse = sBrowse;
    }

    public Date getsAddtime() {
        return sAddtime;
    }

    public void setsAddtime(Date sAddtime) {
        this.sAddtime = sAddtime;
    }
}