package com.mylike.entity;

import java.io.Serializable;

public class Material implements Serializable {
    private Integer mId;

    private Integer rId;

    private String mUrl;

    private String mBlong;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl == null ? null : mUrl.trim();
    }

    public String getmBlong() {
        return mBlong;
    }

    public void setmBlong(String mBlong) {
        this.mBlong = mBlong == null ? null : mBlong.trim();
    }
}