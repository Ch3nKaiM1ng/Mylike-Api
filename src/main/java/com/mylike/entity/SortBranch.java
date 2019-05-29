package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class SortBranch implements Serializable {
    private Integer sId;

    private Integer sTid;

    private String sContent;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sAddtime;

    private Integer sUserid;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getsTid() {
        return sTid;
    }

    public void setsTid(Integer sTid) {
        this.sTid = sTid;
    }

    public String getsContent() {
        return sContent;
    }

    public void setsContent(String sContent) {
        this.sContent = sContent;
    }

    public Date getsAddtime() {
        return sAddtime;
    }

    public void setsAddtime(Date sAddtime) {
        this.sAddtime = sAddtime;
    }

    public Integer getsUserid() {
        return sUserid;
    }

    public void setsUserid(Integer sUserid) {
        this.sUserid = sUserid;
    }
}