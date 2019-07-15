package com.mylike.entity;

import java.io.Serializable;
import java.util.Date;

public class UserManage implements Serializable {
    private Integer mId;

    private Integer uID;//修改时查看的ID

    private String mName;

    private Integer mAge;

    private Long mPhone;

    private String mSex;

    private String mSection;

    private String mPost;

    private String mPwd;

    private String mStatus;

    private Date mAddTime;


    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getmAge() {
        return mAge;
    }

    public void setmAge(Integer mAge) {
        this.mAge = mAge;
    }

    public Long getmPhone() {
        return mPhone;
    }

    public void setmPhone(Long mPhone) {
        this.mPhone = mPhone;
    }

    public String getmSex() {
        return mSex;
    }

    public void setmSex(String mSex) {
        this.mSex = mSex;
    }

    public String getmSection() {
        return mSection;
    }

    public void setmSection(String mSection) {
        this.mSection = mSection;
    }

    public String getmPost() {
        return mPost;
    }

    public void setmPost(String mPost) {
        this.mPost = mPost;
    }

    public String getmPwd() {
        return mPwd;
    }

    public void setmPwd(String mPwd) {
        this.mPwd = mPwd;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public Date getmAddTime() {
        return mAddTime;
    }

    public void setmAddTime(Date mAddTime) {
        this.mAddTime = mAddTime;
    }

    public Integer getuID() {
        return uID;
    }

    public void setuID(Integer uID) {
        this.uID = uID;
    }
}