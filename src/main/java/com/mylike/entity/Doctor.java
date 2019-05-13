package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Doctor implements Serializable {
    private Integer dId;

    private String dHeadpic;

    private String dName;

    private String dDuty;

    private String dAdept;

    private String dIntro;

    private String dNumber;

    private Integer dGood;

    private Integer dFans;

    private Integer dConsult;

    private Integer dSubscribe;

    private String dWeibo;

    private String dAttestation;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date dAddtime;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdHeadpic() {
        return dHeadpic;
    }

    public void setdHeadpic(String dHeadpic) {
        this.dHeadpic = dHeadpic == null ? null : dHeadpic.trim();
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public String getdDuty() {
        return dDuty;
    }

    public void setdDuty(String dDuty) {
        this.dDuty = dDuty == null ? null : dDuty.trim();
    }

    public String getdAdept() {
        return dAdept;
    }

    public void setdAdept(String dAdept) {
        this.dAdept = dAdept == null ? null : dAdept.trim();
    }

    public String getdIntro() {
        return dIntro;
    }

    public void setdIntro(String dIntro) {
        this.dIntro = dIntro == null ? null : dIntro.trim();
    }

    public String getdNumber() {
        return dNumber;
    }

    public void setdNumber(String dNumber) {
        this.dNumber = dNumber;
    }

    public Integer getdGood() {
        return dGood;
    }

    public void setdGood(Integer dGood) {
        this.dGood = dGood;
    }

    public Integer getdFans() {
        return dFans;
    }

    public void setdFans(Integer dFans) {
        this.dFans = dFans;
    }

    public Integer getdConsult() {
        return dConsult;
    }

    public void setdConsult(Integer dConsult) {
        this.dConsult = dConsult;
    }

    public Integer getdSubscribe() {
        return dSubscribe;
    }

    public void setdSubscribe(Integer dSubscribe) {
        this.dSubscribe = dSubscribe;
    }

    public String getdWeibo() {
        return dWeibo;
    }

    public void setdWeibo(String dWeibo) {
        this.dWeibo = dWeibo == null ? null : dWeibo.trim();
    }

    public String getdAttestation() {
        return dAttestation;
    }

    public void setdAttestation(String dAttestation) {
        this.dAttestation = dAttestation == null ? null : dAttestation.trim();
    }

    public Date getdAddtime() {
        return dAddtime;
    }

    public void setdAddtime(Date dAddtime) {
        this.dAddtime = dAddtime;
    }
}