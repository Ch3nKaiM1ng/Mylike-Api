package com.mylike.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SortTotal implements Serializable {
    private Integer sTid;

    private String sTcontent;

    private Date sTaddtime;

    private Integer sTuserid;

    private List<SortBranch> branches;

    public Integer getsTid() {
        return sTid;
    }

    public void setsTid(Integer sTid) {
        this.sTid = sTid;
    }

    public String getsTcontent() {
        return sTcontent;
    }

    public void setsTcontent(String sTcontent) {
        this.sTcontent = sTcontent == null ? null : sTcontent.trim();
    }

    public Date getsTaddtime() {
        return sTaddtime;
    }

    public void setsTaddtime(Date sTaddtime) {
        this.sTaddtime = sTaddtime;
    }

    public Integer getsTuserid() {
        return sTuserid;
    }

    public void setsTuserid(Integer sTuserid) {
        this.sTuserid = sTuserid;
    }

    public List<SortBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<SortBranch> branches) {
        this.branches = branches;
    }
}