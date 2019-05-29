package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ClientUser {
    private Integer cId;

    private String cName;

    private String cNickname;

    private String cPhoto;

    private Integer cAge;

    private String cPhone;

    private String cSex;

    private String cAccNumber;

    private String cPwd;

    private String cEmail;

    private String cDistrict;

    private String cGrade;

    private Integer qqid;

    private Integer wechatid;

    private Integer alipayid;

    private String cStatus;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

    public String getcNickname() {
        return cNickname;
    }

    public void setcNickname(String cNickname) {
        this.cNickname = cNickname == null ? null : cNickname.trim();
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto == null ? null : cPhoto.trim();
    }

    public Integer getcAge() {
        return cAge;
    }

    public void setcAge(Integer cAge) {
        this.cAge = cAge;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }

    public String getcAccNumber() {
        return cAccNumber;
    }

    public void setcAccNumber(String cAccNumber) {
        this.cAccNumber = cAccNumber == null ? null : cAccNumber.trim();
    }

    public String getcPwd() {
        return cPwd;
    }

    public void setcPwd(String cPwd) {
        this.cPwd = cPwd == null ? null : cPwd.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    public String getcDistrict() {
        return cDistrict;
    }

    public void setcDistrict(String cDistrict) {
        this.cDistrict = cDistrict == null ? null : cDistrict.trim();
    }

    public String getcGrade() {
        return cGrade;
    }

    public void setcGrade(String cGrade) {
        this.cGrade = cGrade == null ? null : cGrade.trim();
    }

    public Integer getQqid() {
        return qqid;
    }

    public void setQqid(Integer qqid) {
        this.qqid = qqid;
    }

    public Integer getWechatid() {
        return wechatid;
    }

    public void setWechatid(Integer wechatid) {
        this.wechatid = wechatid;
    }

    public Integer getAlipayid() {
        return alipayid;
    }

    public void setAlipayid(Integer alipayid) {
        this.alipayid = alipayid;
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